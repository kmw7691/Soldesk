package com.kwak.nov151.nbmain;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBGameEngine {
	private int count;
	private int s;
	private int b;
	private int o;
	
	private static final NBGameEngine nge = new NBGameEngine();
	
	private NBGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static NBGameEngine getNB() {
		return nge;
	}
	
	public void doNB(HttpServletRequest request){
		int userAnswer1 = Integer.parseInt(request.getParameter("userAnswer1"));
		int userAnswer2 = Integer.parseInt(request.getParameter("userAnswer2"));
		int userAnswer3 = Integer.parseInt(request.getParameter("userAnswer3"));
		
		int answer1 = new Random().nextInt(9)+1;
		int answer2 = new Random().nextInt(9)+1;
		int answer3 = new Random().nextInt(9)+1;
		
		request.setAttribute("answer1", answer1);
		if(answer2 != answer1) {
			request.setAttribute("answer2", answer2);
		} else if(answer3 != answer1 && answer3 != answer2) {
			request.setAttribute("answer3", answer3);
		}
		
		if(userAnswer1 == answer1) {
			count++;
			s++;
		} else if (userAnswer1 == answer2) {
			count++;
			b++;
		} else if (userAnswer1 == answer3) {
			count++;
			b++;
		} else if (userAnswer2 == answer1) {
			count++;
			b++;
		} else if (userAnswer2 == answer2) {
			count++;
			s++;
		} else if (userAnswer2 == answer3) {
			count++;
			b++;
		} else if (userAnswer3 == answer1) {
			count++;
			b++;
		} else if (userAnswer3 == answer2) {
			count++;
			b++;
		} else if (userAnswer3 == answer3) {
			count++;
			s++;
		} else {
			count++;
			o++;
		}
		
		request.setAttribute("count", count);
		request.setAttribute("s", s);
		request.setAttribute("b", b);
		request.setAttribute("o", o);
	}
}
