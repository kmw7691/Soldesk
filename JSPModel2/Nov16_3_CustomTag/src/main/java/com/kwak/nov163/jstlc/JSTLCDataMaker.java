package com.kwak.nov163.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

//Model / DAO

public class JSTLCDataMaker {
	public static void make(HttpServletRequest request) {
		int[] ar = {123, 465, 78, 90, 2345};
		request.setAttribute("ar", ar); 
	}
	
	//ArrayList이용
	//[사람] 이름 나이 키 몸무게 한세트를 4~5개넣고
	//jstl 반복 사용해서 정보 뽑기
	
	
	public static void info(HttpServletRequest request) {
		ArrayList<Human> human = new ArrayList<Human>(); 
		
		human.add(new Human("김길동", 23, 171.1, 71.1));
		human.add(new Human("박길동", 13, 168.1, 61.1));
		human.add(new Human("최길동", 32, 184.1, 51.1));
		human.add(new Human("이길동", 28, 167.1, 41.1));
		
		request.setAttribute("human", human);
	}
}
