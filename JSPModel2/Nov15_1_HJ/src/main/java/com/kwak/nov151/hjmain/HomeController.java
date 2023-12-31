package com.kwak.nov151.hjmain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("c", "동전의 갯수가 나올자리");
			request.setAttribute("r", "결과가 나올자리");
			request.setAttribute("t", "게임의 전적이 나올자리");
		}else {
			HJGameEngine.getHG().doHJ(request);
		}
		
		request.getRequestDispatcher("hj.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
