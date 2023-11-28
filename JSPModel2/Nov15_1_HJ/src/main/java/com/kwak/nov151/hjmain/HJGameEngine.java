package com.kwak.nov151.hjmain;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

//Model

//필요한 메소드 만들때 팁
//		멤버변수가 필요없으면(멤버변수 안만들어도 되면) : static기반
//		멤버변수가 필요하면(멤버변수 만들어야 하면)  : Singleton기반

public class HJGameEngine {
	private int t;
	private int w;
	private int l;

	private static final HJGameEngine hge = new HJGameEngine();
	
	private HJGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static HJGameEngine getHG() {
		return hge;
	}
	
	public void doHJ(HttpServletRequest request) {
		int userAnswer = Integer.parseInt(request.getParameter("userAnswer"));

		// 동전 몇개가지고 할건지
		int coin = new Random().nextInt(Integer.MAX_VALUE) + 2;
		request.setAttribute("c", coin);

		// 홀짝여부 판단하기
		String gameAnswer = (coin % 2 == 0) ? "짝" : "홀";
		request.setAttribute("r", gameAnswer);

		// coin%2 >> 값이 0이면 짝, 1이면 홀
		// int끼리 비교
		if (userAnswer == (coin % 2)) {
			t++;
			w++;
		} else {
			t++;
			l++;
		}
		
		request.setAttribute("t", t);
		request.setAttribute("w", w);
		request.setAttribute("l", l);
	}
}
