package com.kwak.miniproject.gall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwak.miniproject.member.MemberDAO;

@Controller
public class GallController {
	@Autowired
	private GallDAO gDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/photo.upload", method = RequestMethod.GET)
	public String uploadPhoto(Gall g, HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			gDAO.upload(g, req);
			req.setAttribute("cp", "gall/gall.jsp");
		} else {
			req.setAttribute("cp", "gall/gall.jsp");
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/photo.delete", method = RequestMethod.GET)
	public String deletePhoto(Gall g, HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			gDAO.delete(g, req);
			req.setAttribute("cp", "gall/gall.jsp");
		} else {
			req.setAttribute("cp", "gall/gall.jsp");
		}
		
		return "index";
	}
	
}
