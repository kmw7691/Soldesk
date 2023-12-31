package com.kwak.nov151.nbmain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("nb1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("count", "게임진행횟수");
			request.setAttribute("s", "스트라이크");
			request.setAttribute("b", "볼");
			request.setAttribute("o", "out");
		} else {
			NBGameEngine.getNB().doNB(request);
		}
		request.getRequestDispatcher("nb.jsp").forward(request, response);
	}

}
