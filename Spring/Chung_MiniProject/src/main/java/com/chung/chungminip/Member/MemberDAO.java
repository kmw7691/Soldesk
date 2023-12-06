package com.chung.chungminip.Member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	
	public Members memberIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public void divideAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getC_addr();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr", addr2);
	}
	
	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");

				
				//필요없음
				
//				String dm_photo = m.getC_photo();
//				dm_photo = URLDecoder.decode(dm_photo, "utf-8");

//				String path = req.getSession().getServletContext().getRealPath("resources/img");

//				new File(path + "/" + dm_photo).delete();

			} else {
				req.setAttribute("r", "탈퇴 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "탈퇴 실패");
		}
	}
	
	public void join(Member m, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");

			MultipartRequest mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			m.setC_id(mr.getParameter("c_id"));
			m.setC_pw(mr.getParameter("c_pw"));
			m.setC_name(mr.getParameter("c_name"));
			m.setC_role(mr.getParameter("c_role"));

			String c_addr1 = mr.getParameter("c_addr1"); // 12312
			String c_addr2 = mr.getParameter("c_addr2"); // 서울시 서초구 서초대로
			String c_addr3 = mr.getParameter("c_addr3"); // 서초@ 101/201
			String c_addr = c_addr2 + "!" + c_addr3 + "!" + c_addr1; // 서울시 서초구 서초대로!서초@ 101/201!12312
			m.setC_addr(c_addr);

			String c_photo = mr.getFilesystemName("c_photo");
			String c_photo_kor = URLEncoder.encode(c_photo, "utf-8").replace("+", " ");
			m.setC_photo(c_photo_kor);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "가입성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "가입실패");
		}
	}
	
	public void login(Member inputM, HttpServletRequest req) {
		try {
			List<Member> dbms = ss.getMapper(MemberMapper.class).getMemberById(inputM);
			if (dbms.size() != 0) {
				Member dbM = dbms.get(0); // list에 있는 m_id
				if (dbM.getC_pw().equals(inputM.getC_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(10 * 60);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(DB서버문제)");
		}
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	
	// 파일 필수 - x
		// 기존 사진 그냥 쓸거면 선택 안하기
		// 사진을 바꿀거면 선택 하기
		public void update(Member m, HttpServletRequest req) {
			// 사진 파일은 최대 10MB
			// 수정시도 : 파일을 10MB넘게 -> 무조건 실패
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr = null;
			try {
				mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			} catch (Exception e) {
				req.setAttribute("r", "수정실패(파일용량초과)");
				return;
			}

			// 현재 로그인 된 회원 정보(수정되기 전)
			Member lm = (Member) req.getSession().getAttribute("loginMember");

			// 기존 사진 파일명
			String oldFile = lm.getC_photo(); 

			// 새 파일명
			String newFile = mr.getFilesystemName("c_photo"); 
			try {
				String dm_id = mr.getParameter("c_id");
				String dm_pw = mr.getParameter("c_pw");
				String dm_name = mr.getParameter("c_name");
				String dm_addr1 = mr.getParameter("c_addr1");
				String dm_addr2 = mr.getParameter("c_addr2");
				String dm_addr3 = mr.getParameter("c_addr3");

				if (newFile == null) { // 사진은 수정 안하는
					newFile = oldFile;
				} else { // 사진 수정
					newFile = URLEncoder.encode(newFile, "utf-8");
					newFile = newFile.replace("+", " ");
				}
				m.setC_id(dm_id);
				m.setC_pw(dm_pw);
				m.setC_name(dm_name);
				m.setC_addr(dm_addr2 + "!" + dm_addr3 + "!" + dm_addr1);
				m.setC_photo(newFile);

				// DB수정
				if (ss.getMapper(MemberMapper.class).update(m) == 1) {
					req.setAttribute("r", "수정성공");

					// 사이트에 반영
					req.getSession().setAttribute("loginMember", m);
					loginCheck(req);

					// 프사 바꾸는 상황 : 옛날 프사 지우기
					if (!oldFile.equals(newFile)) {
						oldFile = URLDecoder.decode(oldFile, "utf-8");
						new File(path + "/" + oldFile).delete();
					}
				} else {
					req.setAttribute("r", "수정실패");

					// 프사 바꾸는 상황 : 새 프사 지우기
					if (!oldFile.equals(newFile)) {
						newFile = URLDecoder.decode(newFile, "utf-8");
						new File(path + "/" + newFile).delete();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("r", "수정실패");

				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					try {
						newFile = URLDecoder.decode(newFile, "utf-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new File(path + "/" + newFile).delete();
				}
			}

		}
	
}
