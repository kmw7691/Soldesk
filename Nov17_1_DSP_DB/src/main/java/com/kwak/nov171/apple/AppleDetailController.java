package com.kwak.nov171.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(appleDAO.getAppleDAO().getAppleDetail(request)) {
			request.setAttribute("contentPage", "apple/detail.jsp");
		} else {
			appleDAO.getAppleDAO().getApples(1, request);
			request.setAttribute("contentPage", "apple/apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(appleDAO.getAppleDAO().update(request)) {
			appleDAO.getAppleDAO().getAppleDetail(request);
			appleDAO.getAppleDAO().getApples(1, request);
			request.setAttribute("contentPage", "apple/apple.jsp");	
		} else {
			appleDAO.getAppleDAO().getApples(1, request);
			request.setAttribute("contentPage", "apple/apple.jsp");	
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
