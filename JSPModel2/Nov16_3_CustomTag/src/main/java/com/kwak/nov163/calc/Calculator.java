package com.kwak.nov163.calc;

import javax.servlet.http.HttpServletRequest;

//Model / DAO

public class Calculator {
	//멤버변수가 필요 없음
	public static void calculate(HttpServletRequest request) {
		double x = Double.parseDouble(request.getParameter("x")); 
		double y = Double.parseDouble(request.getParameter("y"));
		
		double add = x+y;
		double sub = x-y;
		double mul = x*y;
		double div = x/y;
		
		request.setAttribute("a", add);
		request.setAttribute("s", sub);
		request.setAttribute("m", mul);
		request.setAttribute("d", div);
	}
}
