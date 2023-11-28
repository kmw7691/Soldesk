package com.kwak.nov072.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내 이름을 출력
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		PrintWriter pw = response.getWriter();	
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'>");
		pw.print("<title>이름</title></head>");
		pw.print("<body>");
		
		pw.printf("%s", name);
		
		pw.print("</body>");
		pw.print("</html>");
	}

	
	//GET방식 vs POST방식
	//		GET : 요청파라미터가 주소에 있어서 우리가 눈으로 볼수있음
	//		POST : 요청 파라미터가 주소에 없어서 우리가 눈으로 볼수없음
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		PrintWriter pw = response.getWriter();	
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'></head>");
		pw.print("<body>");
		pw.print("<h1>OUTPUT-POST</h1>");
		
		pw.printf("%s", name);
		
		pw.print("</body>");
		pw.print("</html>");
		
	}

}
