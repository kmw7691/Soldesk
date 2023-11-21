package com.kwak.nov071.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String gugu = request.getParameter("gugu");
		
		int dd = Integer.parseInt(gugu);
		int ttt = Integer.parseInt(request.getParameter("to"));
		//url에 원하는 단을 입력하면 해당 단이 출력되게
		PrintWriter pw = response.getWriter();	
		pw.print("<html>");
		pw.print("<head><meta charset=\"UTF-8\"></head>");
		pw.print("<body>");
		pw.print("<table border='1'>");
		
		pw.print("<tr><th>구구단</th></tr>");
		pw.printf("<tr><th>%d단</th></tr>", dd);
		for (int i = 1; i <= ttt; i++) {
			pw.printf("<tr><td>%d x %d = %d</td></tr>", dd, i , dd*i);
		}
		
		
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
