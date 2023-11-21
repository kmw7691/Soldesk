package com.kwak.nov132.main;

import javax.servlet.http.HttpServletRequest;

//Model : 일반적인 Java Class
//		실제업무(계산 DB 가공 등)

public class M {
	//V1.html -> C ->가져온 값 계산 + 가공
	public static void add(HttpServletRequest request) {//요청객체
		//받아온값 = parameter
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		//여기서 만드는값 - Attribute
		int z = x + y;
		request.setAttribute("zz", z);
	}
}
