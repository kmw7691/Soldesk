package com.kwak.nov132.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller : Servlet
//			상황 판단해서 M/V소환
//			-> 어떤 요청이 들어왔을때 상황 판단을 통해 M or V소환
//			해당 프로젝트(사이트)의 진입점(ctrl + f11실행을 여기서)

//Back-end개발자 : PL급(Project Leader)
@WebServlet("/C")
public class C extends HttpServlet {
	
	//어떤 사이트에 접속을 할때
	//		주소를 직접 입력
	//		검색-><a>눌러서
	//		둘다 GET방식 요청(어떤 사이트에 POST로 첫접속 -x)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("V1.html");
//		rd.forward(request, response);
		request.getRequestDispatcher("V1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.add(request); // 계산을 먼저하고 결과를 봐야
		request.getRequestDispatcher("V2.jsp").forward(request, response);
	}

}
