package com.kwak.nov171.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwak.nov171.apple.appleDAO;
import com.kwak.nov211.banana.BananaDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	//HomeController 생성자 : 톰캣이 이 프로젝트를 처음 실행시킬때 동작
	public HomeController() {
		//사과데이터 총 갯수 가져오기
		appleDAO.getAppleDAO().countApples();
		BananaDAO.getBananaDAO().countBananas();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "home.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
