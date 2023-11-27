package com.kwak.nov223.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov223.main.TokenManager;
import com.kwak.nov223.member.MemberDAO;

@WebServlet("/BoardPageController")
public class BoardPageController extends HttpServlet {
	
	//페이지처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		TokenManager.make(request);
		int p = Integer.parseInt(request.getParameter("p"));
		BoardDAO.getBDAO().getBoardMsg(p, request);
		request.setAttribute("cp", "board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
