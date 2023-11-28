package com.kwak.nov223.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov223.board.BoardDAO;
import com.kwak.nov223.member.MemberDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	
	public HomeController() {
		BoardDAO.getBDAO().countAllBoard();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request); // lp부분 채우기
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
