package com.kwak.nov223.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov223.main.DateManager;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	// 회원가입 버튼 눌러서 회원가입 창으로 이동하는 용도
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request); // lp부분 채우기
		DateManager.getCurYear(request); // 현재 년도 뽑고 나서 signup.jsp 틀기
		request.setAttribute("cp", "member/signup.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.signUp(request);
		MemberDAO.loginCheck(request);
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
