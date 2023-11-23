package com.kwak.nov223.member;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.db.manager.KwakDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	// index.jsp <jsp:include=${lp } /> 부분
	//	로그인 중 + 로그인 성공 >> 로그인 축하페이지
	//  로그인 상태가 아니거나 + 로그인 실패 >> 로그인 하는 페이지
	public static boolean loginCheck(HttpServletRequest req) {
		// 로그인이 된 상태면 Member 자바빈에 채워질 것
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			// 로그인 성공 + 상태 유지
			req.setAttribute("lp", "member/welcome.jsp");
			return true;
		} else {
			// 로그인 실패 + 로그인 상태가 아니거나
			req.setAttribute("lp", "member/login.jsp");
			return false;
		}
	}

	//회원가입
	//m_y m_m m_d -> m_birthday로 합치기
	public static void signUp(HttpServletRequest req) {
		//파일업로드부분 일단 먼저시도
		String path = null;
		//사진넣을때 cos.jar
		MultipartRequest mr = null;
		
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path); //확인용
			mr = new MultipartRequest(req, path,
									20*1024*1024,"utf-8",
									new DefaultFileRenamePolicy());
		} catch (Exception e) { //파일업로드 실패하면
			e.printStackTrace();
			req.setAttribute("r", "회원가입실패(사진파일용량)");
			return; //사진업로드에 실패하면 아래 작성할 db작업 ㄴㄴ(강제종료)
		}
		
		//위 catch에 안걸리고 넘어갓다 -> 파일업로드 성공
		//성공시 계속진행
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//jsp model 2 DB연결
			//		meta-inf : context.xml
			//		web-app : ojdbc8.jar kwakdbmanager.jar
			con = KwakDBManager.connect("kwakPool");
			
			//요청파라미터값 받아와서 변수ㅇ 저장
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			
			//날짜 : 231123
			String y = mr.getParameter("m_y");
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String birthday = String.format("%s%02d%02d", y, m, d);
			
			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");
			
			String sql = "insert into nov22_member values(?, ?, ?, ?, "
					+ "	to_date(?, 'YYYYMMDD'), ?)";
			
			pstmt = con.prepareStatement(sql);
			
			//?채우기
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birthday);	//일단 string으로 ? 넣고 그 이후에 date로 바뀌기때문
			pstmt.setString(6, photo);		//db에 사진이름만들어감
			
			if(pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "회원가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//DB쪽 문제로 회원가입은 실패했지만, 사진파일은 업로드가 되어잇는 상태
			//사진파일 지워야댐(파일명은 한글처리x)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete(); //파일지우기
			req.setAttribute("r", "회원가입실패-DB문제");
		}
		KwakDBManager.close(con, pstmt, null);
	}

	//로그인기능 - login ->세션쿠키이용 -> db에서 해당하는 id(PK)찾아서 그 정보에 있는 pw와
	//내가 input에 입력한 pw가 같으면 로그인성공
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			req.setCharacterEncoding("utf-8");
			//member/login.jsp의 input부분에 입력받은 값 가져오기
			String id = req.getParameter("m_id");
			String pw = req.getParameter("m_pw");
			
			//select*from NOV22_MEMBER where m_id; << 모든회원데이터
			//select*from NOV22_MEMBER where m_id = ? and m_pw=?
			//		ㄴ 기초적인 해킹기법 : SQL Injection
			//					보안상 취약점을 이용해서 database가 비정상적 동작을 하게하는 기법
			//select*from NOV22_MEMBER where m_id = ?
			String sql = "select*from NOV22_MEMBER where m_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); //해당하는 모든 정보가 rs에 담김
			
			if(rs.next()) { //rs에 데이터가 있다면
				//db에 담긴 pw를 찾아서 담기
				String dbpw = rs.getString("m_pw"); //"db필드명"
				if(dbpw.equals(pw)) { //입력받은 비번이랑 일치하면
					Member m = new Member(
							rs.getString("m_id"),
							dbpw,rs.getString("m_name"),
							rs.getString("m_phone"),
							rs.getDate("m_birthday"),
							rs.getString("m_photo"));
					//loginmember라는 세션 만들어서 담기
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(600); //10분
					
					Cookie c = new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 3); //3일
					res.addCookie(c);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "로그인실패 - 비번오류");
				}
			} else {
				req.setAttribute("r", "로그인실패 - 미가입ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패 - db문제");
		}
		KwakDBManager.close(con, pstmt, rs);
	}

	//로그아웃
	public static void logout(HttpServletRequest req) {
		//세션끊기 : 다른 세션도 같이끊김(비추)
//		req.getSession().setMaxInactiveInterval(-1);
		
		//loginMember에 대한 session만 null처리
		req.getSession().setAttribute("loginMember", null);
		req.setAttribute("r", "로그아웃성공");
	}

	//회원탈퇴 >> DB에 데이터지우기 + 프사지우기
	//session에는 여전히 정보가 있음 >> 컨트롤러가서 처리
	public static void delete(HttpServletRequest req) {
		Connection con= null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			//loginMember 세션의 정보 받아서 자바빈에 담기
			Member m = (Member) req.getSession().getAttribute("loginMember");
			//그중에 id만 << 수정/삭제는 PK만필요
			String m_id = m.getM_id();
			
			String sql = "delete from NOV22_MEMBER where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m_id);
			
			if(pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "탈퇴성공");
				//탈퇴성공하면 프로필 사진도 지워야함
				String m_photo = m.getM_photo();
				m_photo = URLDecoder.decode(m_photo, "utf-8");
				String path = req.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			} else {
				req.setAttribute("r", "탈퇴실패 - 이미 탈퇴처리됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴실패 - DB문제");
		}
		KwakDBManager.close(con, pstmt, null);
	}


	//정보수정
	//update NOV22_MEMBER_ set m_pw = ?, m_name = ?, m_phone = ?,
	//m_birthday = ?, m_photo = ? where m_id = ?
	public static void update(HttpServletRequest req) {
		
	}
}




















