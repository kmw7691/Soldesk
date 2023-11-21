package com.kwak.nov063.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//main이 없다? 0> tomcat내부에 존재
//Servlet = Server + Application

//Server
//		Web Server : HTML + CSS 요청하면 HTML + CSS 줌
//		WAS		   : Web Application Server(웹서버보다 한급 높다)
//						프로그램 실행이 가능한 웹서버
//						웹서버+프로그래밍언어
//						웹서버+JDK
//						웹서버+C언어
//						...

//@XXX : Annotation
//		원래는 다 직접 구현했어야됫는데 -> 자동구현됨
//LearnServlet을 Tomcat에 등록해라~(지우면 실행x, 바로아래 class명과 동일)

/**
 * Servlet implementation class LearnServlet
 */
@WebServlet("/LearnServlet")
public class LearnServlet extends HttpServlet {
									//HttpServlet 클래스에 있는(요청받으면 응답하기)를 상속받음
									//뭔가 필요하면 더 추가할수가 있다
	
	//작업하면서 버전표시, 지워도 무방함
	//private static final long serialVersionUID = 1L;

	//constructor(생성자) - 별로 쓸일이 없음, 지워도 무방함
	//		이 LearnServlet객체를 만드는건 Tomcat
//    public LearnServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	//event-driven-programming(이벤트기반 프로그래밍)
	//		Tomcat이 실행중 -> LearnServlet을 실행
	//		->Tomcat이 LearnServlet객체를 만들어서 무한루프
	//		->어떤 이벤트가 발생하면 그걸 처리하고 루프로 복귀
	
	//***핵심부분
	//		루프를 돌다가 client가 Servlet으로 GET하는 방식 요청하면
	//		Tomcat이 doGet메소드를 자동으로 호충
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	//		루프를 돌다가 client가 Servlet으로 POST하는 방식 요청하면
	//		Tomcat이 doPost메소드를 자동으로 호충
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
