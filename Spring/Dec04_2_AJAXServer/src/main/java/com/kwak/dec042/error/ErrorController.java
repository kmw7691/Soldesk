package com.kwak.dec042.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
	@Autowired
	private ErrorDAO eDAO;

	@RequestMapping(value = "/error.get", method = RequestMethod.GET)
	public String getAllError(HttpServletRequest req) {
		eDAO.getAllError(req);

		return "index";
	}

	@RequestMapping(value = "/error.getJSON", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors getErrorJson(HttpServletRequest req, HttpServletResponse res) {
		//해당사이트 외부에서 AJAX가능하게 하려면
		//응답 파라미터(HttpServletResponse)를 추가하고
		//헤더코드를 추가
		res.addHeader("Access-Control-Allow-Origin", "*");
		
		return eDAO.getJson(req);
	}

	@RequestMapping(value = "/error.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors searchErrorJson(Error e, HttpServletRequest req) {

		return eDAO.searchError(e, req);
	}
}
