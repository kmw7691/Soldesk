package com.kwak.dec042.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	@Autowired
	private ErrorDAO eDAO;
	
	@RequestMapping(value = "/error.get", method = RequestMethod.GET)
	public String getAllError(HttpServletRequest req) {
		eDAO.getAllError(req);
		
		return "index";
	}
}
