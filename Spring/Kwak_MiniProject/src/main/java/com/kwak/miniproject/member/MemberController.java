package com.kwak.miniproject.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Members memberIdCheck(Member m) {
		return mDAO.mIdCheck(m);
	}
	

	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String memberDelete(HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			mDAO.delete(req);
			mDAO.logout(req);
			mDAO.loginCheck(req);
		}
		
		return "index";
	}

	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			mDAO.divAddr(req);
			req.setAttribute("cp", "member/info.jsp");
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest req) {
		mDAO.loginCheck(req);
		req.setAttribute("cp", "member/join.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/member.join", method = RequestMethod.POST)
	public String memberJoin(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.update(m, req);
			mDAO.divAddr(req);
			req.setAttribute("cp", "home.jsp");
		} else {
			req.setAttribute("cp", "home.jsp");
		}
		return "index";
	}
}
