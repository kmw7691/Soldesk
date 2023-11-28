package com.kwak.nov223.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 여기저기서 날짜를 많이 다룰수도 있기 때문에 main패키지 안에 배치
public class DateManager {

	// 올해 날짜의 년도
	// signup.jsp의 <select> 년도 부분에서 해마다 바꾸지 않고 여기서 받아오기
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date(); // 지금 현재 날짜 및 시간
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); // 내가 필요한 부분만
		String curYear = sdf.format(now); // Date -> String : format
		req.setAttribute("cy", curYear);  // 년도만 jsp 등에서 사용 가능
	}
}
