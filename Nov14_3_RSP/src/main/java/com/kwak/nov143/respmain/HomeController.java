package com.kwak.nov143.respmain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//겟요청할때마다 새로운 엔진을 만들면서 새롭게생성 -> 숫자가 안늘어남
		//해결책 : 엔진을 하나로 -> singleton pattern
		//		**JSP Model2 할때 Model이 singleton pattern일때가 많음
		
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("uh", "gogo.gif");
			request.setAttribute("ch", "gogo.gif");
		}else {
//			RSPGameEngine rge = new RSPGameEngine();
			RSPGameEngine rge = RSPGameEngine.getRge();
			rge.doRSP(request);
		}
		
		request.getRequestDispatcher("rsp.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
