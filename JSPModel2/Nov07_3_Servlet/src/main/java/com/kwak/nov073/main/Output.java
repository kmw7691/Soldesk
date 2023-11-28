package com.kwak.nov073.main;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");
		String[] habbit = request.getParameterValues("habbit");
		String myself = request.getParameter("myself");
		
		
		PrintWriter pw = response.getWriter();	
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'>");
		pw.print("<title>회원가입페이지</title></head>");
		pw.print("<body>");
		pw.print("<h1>회원가입결과</h2>");
		pw.printf("<h2>ID : %s</h2>", id);
		pw.printf("<h2>PASSWORD : %s</h2>", password);
		pw.printf("<h2>성별 : %s</h2>", gender);
		pw.printf("<h2>지역 : %s</h2>", location);
		if(habbit != null) {
			pw.print("<h2>취미 : ");
			for (String s : habbit) {
				pw.print(s + "");
			}
			pw.print("</h2>");
		} else {
			pw.print("취미 선택 안함");
		}
		pw.printf("<h2>자기소개 : %s</h2>", myself);
		
		pw.print("</body>");
		pw.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");
		String habbit = request.getParameter("habbit");
		String myself = request.getParameter("myself");
		
		
		PrintWriter pw = response.getWriter();	
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'>");
		pw.print("<title>회원가입페이지</title></head>");
		pw.print("<body>");
		
		pw.printf("<h1>%s</h1>", id);
		pw.printf("<h1>%s</h1>", password);
		pw.printf("<h1>%s</h1>", gender);
		pw.printf("<h1>%s</h1>", location);
		pw.printf("<h1>%s</h1>", habbit);
		pw.printf("<h1>%s</h1>", myself);
		
		pw.print("</body>");
		pw.print("</html>");
	}

}
