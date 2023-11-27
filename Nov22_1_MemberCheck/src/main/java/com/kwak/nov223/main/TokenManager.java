package com.kwak.nov223.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//TokenManager를 만들어주지 않으면 새로고침때마다 
//같은 요청이 이루어지면서 같은 글이 추가로 계속 생성됨
//내가 쓴글이 새로고침을 해도 그대로 하나만 있을수 있도록 하기위해 만듬

public class TokenManager {
	public static void make(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		req.setAttribute("generatedToken", sdf.format(now));
	}
}
