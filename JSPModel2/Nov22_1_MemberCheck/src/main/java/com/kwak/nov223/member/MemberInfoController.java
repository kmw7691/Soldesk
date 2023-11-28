package com.kwak.nov223.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov223.main.DateManager;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.loginCheck(request)) { //로그인이 되어 있으면
			DateManager.getCurYear(request);
			
			request.setAttribute("cp", "member/memberinfo.jsp");
		} else {
			request.setAttribute("cp", "home.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
