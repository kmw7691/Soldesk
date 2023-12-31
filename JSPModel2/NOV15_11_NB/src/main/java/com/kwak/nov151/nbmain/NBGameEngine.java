package com.kwak.nov151.nbmain;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBGameEngine {
	//누적시킬거 : 몇번만에 정답맞추나
	private int t;
	private String answer;//사용자가 정답을 맞출때까지 안바뀌게
	
	private static final NBGameEngine NGE = new NBGameEngine();
	
	public NBGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static NBGameEngine getNGE() {
		return NGE;
	}
	
	public void pickAns() { //처음 접속때, 게임다시 시작때
		int a = new Random().nextInt(976) + 12;
		String ans = String.format("%03d", a);
		if(ans.charAt(0) == ans.charAt(1)
			|| ans.charAt(1) == ans.charAt(2)
			|| ans.charAt(2) == ans.charAt(0)) {
			
			pickAns();
			return;	//기존에 하던 메소드를 빠져나와서 새로운 메소드를 실행하기 위함
		}
		this.answer = ans; //this.answer : 멤버변수 answer에 정답을 담아두기
		System.out.println("정답 : " + ans);
	}
	
	public void doNB(HttpServletRequest request) {
		String userAns = request.getParameter("userAns");
		request.setAttribute("ua", "유저의 답 :" + userAns);
		
		int strike=0;
		int ball=0;
		
		for(int i = 0;i < 3;i++) { 			//userAns용
			for (int j = 0; j < 3; j++) {	//answer용
				if(userAns.charAt(i) == answer.charAt(j)) {
					if(i==j) {	//자릿수까지같으면
						strike++;
					} else {	//숫자는 같고 자릿수만 다르면
						ball++;
					}
				}
			}
		}
		t++;
		request.setAttribute("t", t + "번째 시도");
		request.setAttribute("s", "S : " + strike);
		request.setAttribute("b", "B : " + ball);
		
		if(strike==3) {
			String result="정답!" + answer + "였습니다";
			t = 0;
			request.setAttribute("r", result);
			request.setAttribute("ua", null);
			request.setAttribute("s", null);
			request.setAttribute("b", null);
			request.setAttribute("btn", "<button onclick='goHome()'>다시시작</button>");
			request.setAttribute("cmt", "<h1>굿</h1>");
		}
	}
}















