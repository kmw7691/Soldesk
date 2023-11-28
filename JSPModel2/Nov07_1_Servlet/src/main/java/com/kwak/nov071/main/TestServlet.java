package com.kwak.nov071.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//내컴퓨터 : localhost => 127.0.0.1
//http://localhost/Nov07_1_Servlet/KwakServlet

//Internet주소체계
//		http,https://		-프로토콜(통신방식)
//		IP주소 or Domain주소	-컴퓨터주소
//		:port				-80은 생략가능
//		/폴더명/폴더명/.../파일명	-이쪽에다가 client가 request(요청)
//		?					-parameter넣기위한 연결고리
//		변수명=값&변수명=값&...	-요청parameter(client가 server에 request하는것)

//값이 korean이면 한국어로 네 라는 말이뜨게
//값이 english면 영어로 yes라고 나오게

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		//변수명을 만드는 작업 : url요청 파라미터 중에 변수명이 lang인 부분의 값을 가져와서
		//					String language라는 java변수에 담아라
		String language = request.getParameter("lang");
		//ctrl + f11로 실행한후
		//	?lang=korean
		//	?lang=english 써줘야 답이나옴
		//		http://localhost/Nov07_1_Servlet/TestServlet?lang=korean
		
		PrintWriter pw = response.getWriter();	
		pw.print("<html>");
		pw.print("<head><meta charset=\"UTF-8\"></head>");
		pw.print("<body>");
		
		pw.print("<h1>");
		if(language.equals("korean")) {
			pw.print("네");
		} else if(language.equals("english")) {
			pw.print("yes");
		} else {
			pw.print("??");
		}
		pw.print("</h1>");
		
		pw.print("</body>");
		pw.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
