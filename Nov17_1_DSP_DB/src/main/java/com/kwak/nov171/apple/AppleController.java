package com.kwak.nov171.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleController")
public class AppleController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//appleDAO.getAppleDAO().getAllApples(request);
		appleDAO.getAppleDAO().getApples(1, request); //게시판들어가면 1페이지부터 시작
		request.setAttribute("contentPage", "apple/apple.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
