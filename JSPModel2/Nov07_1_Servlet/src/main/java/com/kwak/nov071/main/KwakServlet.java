package com.kwak.nov071.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet : WAS에서만 실행가능 -> Tomcat환경에서만 실행가능
//	ㄴServlet에서 Ctrl+f11로실행

//html + CSS + javascript : 프로그램 안에 기능이 부족

@WebServlet("/KwakServlet")
public class KwakServlet extends HttpServlet {
       
	//현재 : HTTP
	//		돈주고 인증서 사와서 톰캣에 세팅 : https
	
	//Internet 
	//		http, https 통신하는거

	
	//GET방식 요청(기본) 받을 때 : 어떤 사이트에 [처음] 접속하는건 무조건 GET방식
	//		주소를 알고 있어서 직접 타이핑해서 접속
	//		포털사이트에서 검색 -> 클릭
	//		사이트 내부에서 클릭
	//**URL창에 client의 요청 정보를 쓸 수 있으면 GET방식이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리방식
		response.setCharacterEncoding("utf-8");
		//랜선에 붙어있을 응답용 빨대
		PrintWriter pw = response.getWriter();	//console>>Scanner같은것
		pw.print("<html>");
		pw.print("<head><meta charset=\"UTF-8\"></head>");
		pw.print("<body>");
		for (int i = 0; i < 5; i++) {
			pw.print("<marquee><h1 style='color:red';>today</h1></marquee>");
		}
		pw.print("</body>");
		pw.print("</html>");
	}

	//POST방식 요청 받을 때
	//		프로그램 내부적으로 프로그램을 통해서만 가능
	//**URL창에 client의 요청 정보를 쓸 수 없으면 POST방식으로만
	//		ㄴ 회원가입, 블로그 사진 포스팅, 음악 업로드 등등..
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
