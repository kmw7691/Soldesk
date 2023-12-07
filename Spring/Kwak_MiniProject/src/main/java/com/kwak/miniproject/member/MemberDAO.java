package com.kwak.miniproject.member;

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
	
	//id존재여부
	public Members mIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}
	
	//로그아웃
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	//주소나누기 - @로 구분
	public void divAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getAddr();
		String[] addr2 = addr.split("@");
		req.setAttribute("addr", addr2);
	}
	
	//회원 탈퇴
	public void delete(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			if(ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("r", "탈퇴성공");
				
				String photo = m.getPhoto();
				photo = URLDecoder.decode(photo, "utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				
				new File(path + "/" + photo).delete();
			} else {
				req.setAttribute("r", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴실패");
		}
	}
	
	//회원가입
	public void join(Member m, HttpServletRequest req) {
		try {
			//사진경로
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			
			//용량 20메가까지
			MultipartRequest mr = new MultipartRequest(req, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			m.setId(mr.getParameter("id"));
			m.setPw(mr.getParameter("pw"));
			m.setName(mr.getParameter("name"));
			
			//주소
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "@" + addr3 + "@" + addr1;
			m.setAddr(addr);
			
			String photo = mr.getFilesystemName("photo");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");
			m.setPhoto(photo);
			
			if(ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "가입성공");
			} else {
				req.setAttribute("r", "가입실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패");
		}
	}
	
	//로그인
	public void login(Member m, HttpServletRequest req) {
		try {
			List<Member> lm = ss.getMapper(MemberMapper.class).getMemberById(m);
			if(lm.size() != 0) {
				Member lmM = lm.get(0);
				if(lmM.getPw().equals(m.getPw())) {//비번같나확인
					req.getSession().setAttribute("loginMember", lmM);
					req.getSession().setMaxInactiveInterval(600);//10분동안
					req.setAttribute("r", "로그인성공");
				}else {
					req.setAttribute("r", "로그인실패(비번오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(아이디없음)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(db서버문제)");
		}
	}
	
	//로그인확인
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("lp", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("lp", "member/login.jsp");
			return false;
		}
	}
	
	//정보수정
	public void update(Member m, HttpServletRequest req) {
		//사진경로
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			//용량 20메가
			mr = new MultipartRequest(req, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정실패(파일용량초과)");
			return;
		}
		
		//현재 로그인중인 회원정보
		Member lm = (Member) req.getSession().getAttribute("loginMember");
		
		//원래프사
		String oPhoto = lm.getPhoto();
		
		//새프사
		String nPhoto = mr.getFilesystemName("photo");
		
		try {
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			
			if(nPhoto == null) {//새프사안하면
				nPhoto = oPhoto;
			} else { //새프사하면
				nPhoto = URLEncoder.encode(nPhoto, "utf-8");
				nPhoto = nPhoto.replace("+", " ");
			}
			m.setId(id);
			m.setPw(pw);
			m.setName(name);
			m.setAddr(addr2 + "@" + addr3 + "@" + addr1);
			m.setPhoto(nPhoto);
			
			//DB수정
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("r", "수정성공");

				// 사이트에 반영
				req.getSession().setAttribute("loginMember", m);
				loginCheck(req);

				// 프사바꿈 - 원래프사제거
				if (!oPhoto.equals(nPhoto)) {
					oPhoto = URLDecoder.decode(oPhoto, "utf-8");
					new File(path + "/" + oPhoto).delete();
				}
			} else {
				req.setAttribute("r", "수정실패");

				// 수정실패했으니 새프사제거
				if (!oPhoto.equals(nPhoto)) {
					nPhoto = URLDecoder.decode(nPhoto, "utf-8");
					new File(path + "/" + nPhoto).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패");

			// 수정실패했으니 새프사제거
			if (!oPhoto.equals(nPhoto)) {
				try {
					nPhoto = URLDecoder.decode(nPhoto, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + nPhoto).delete();
			}
		}
	}
}
























