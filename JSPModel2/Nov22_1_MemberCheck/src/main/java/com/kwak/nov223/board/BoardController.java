package com.kwak.nov223.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov223.main.TokenManager;
import com.kwak.nov223.member.MemberDAO;

@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	// 게시판으로 이동하는 용도
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request); // login여부 확인 + lp부분에 어떤 jsp가 나올지 판단
		TokenManager.make(request);
		BoardDAO.getBDAO().clearSearch(request);
		BoardDAO.getBDAO().getBoardMsg(1, request);
		request.setAttribute("cp", "board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
