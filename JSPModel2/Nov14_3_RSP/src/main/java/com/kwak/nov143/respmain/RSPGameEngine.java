package com.kwak.nov143.respmain;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

//model

public class RSPGameEngine {
	//게임수, 승, 무, 패
	private int t;
	private int w;
	private int d;
	private int l;
	
	//상수화
	//private : class내부에서만 가능 / 외부로 못가져감
	private static final RSPGameEngine rge = new RSPGameEngine();
	
	private RSPGameEngine() {
		
	}
	
	//getter하나만 처리 -> Singleton Pattern
	//		ㄴ 컨트롤러에서 사용하려고
	public static RSPGameEngine getRge() {
		return rge;
	}
	
	//staic아님
	public void doRSP(HttpServletRequest request) {
		//parameter로 받은 userhand가 
		//1이면 가위 -> 1.png
		//2면 바위
		//3이면보
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", userHand + ".png");
		
		int comHand = new Random().nextInt(3) + 1;
		request.setAttribute("ch", comHand + ".png");
		
		//판정
		int result = userHand - comHand;
		if(result == 0) {
			request.setAttribute("r", "무");
			d++;
			t++;
		}else if(result == -1) {
			request.setAttribute("r", "패");
			l++;
			t++;
		}else {
			request.setAttribute("r", "승");
			w++;
			t++;
		}
		
		request.setAttribute("t", t);
		request.setAttribute("w", w);
		request.setAttribute("l", l);
		request.setAttribute("d", d);
	}
}
