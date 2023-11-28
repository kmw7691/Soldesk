package com.kwak.nov072.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	//사칙연산
	//주소 파라미터로 x,y값 받아서
	//가장 큰글씨를 만드는 태그 이용 - 사칙연산
	//주소에서 받은 x y값으로 덧 뺄 곱 나 ㄱㄱ

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String x = request.getParameter("x");
		
		double xx = Double.parseDouble(x);
		double yy = Double.parseDouble(request.getParameter("y"));
		
		PrintWriter pw = response.getWriter();	
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'>");
		pw.print("<title>사칙연산</title></head>");
		pw.print("<body>");
			
		pw.print("<h1>사칙연산</h1>");
		pw.print("<table border=\"1\">");
		pw.printf("<tr><th><h1>덧셈 : %.0f + %.0f = %.0f</h1></th></tr>", xx, yy, xx+yy);
		pw.printf("<tr><th><h1>뺄셈 : %.0f - %.0f = %.0f</h1></th></tr>", xx, yy, xx-yy);
		pw.printf("<tr><th><h1>곱셈 : %.0f x %.0f = %.0f</h1></th></tr>", xx, yy, xx*yy);
		pw.printf("<tr><th><h1>나눗셈 : %.0f / %.0f = %.1f</h1></th></tr>", xx, yy, xx/yy);
		
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
