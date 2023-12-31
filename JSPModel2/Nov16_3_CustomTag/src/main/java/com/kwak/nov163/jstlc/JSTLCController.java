package com.kwak.nov163.jstlc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTLCController")
public class JSTLCController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameterNames().hasMoreElements()) {
			JSTLCDataMaker.make(request);
			JSTLCDataMaker.info(request);
			request.setAttribute("contentPage", "jstlc/output.jsp");
		} else {
			request.setAttribute("contentPage", "jstlc/input.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
