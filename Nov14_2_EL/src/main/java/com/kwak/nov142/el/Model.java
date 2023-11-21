package com.kwak.nov142.el;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Model {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x * y;
		request.setAttribute("z", z);
		
		/////////////
		
		Kwak k = new Kwak("kwak", 100, 1.0, "010-2934-7691");
		request.setAttribute("kk", k);
		
		//////////////
		
		ArrayList<Kwak> kwaks = new ArrayList<Kwak>();
		kwaks.add(k);
		kwaks.add(new Kwak("김", 24, 2.1, "010"));
		kwaks.add(new Kwak("박", 12, 1.4, "010"));
		kwaks.add(new Kwak("이", 34, 1.3, "010"));
		kwaks.add(new Kwak("나", 45, 2.0, "010"));
		kwaks.add(new Kwak("최", 21, 1.5, "010"));
		
		request.setAttribute("ks", kwaks);
	}
}
