package com.kwak.nov294;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//JSP Model 2------------------------
// http://IP:PORT/프로젝트명/컨트롤러명
// C : Servlet
//	상황판단 -> 흐름제어
//	doGet(), doPost() 메소드 활용
//	주소에 컨트롤러 파일명, 컨트롤러 하나당 GET하나, POST하나
//	=>컨트롤러의 수가 많아짐

//Spring-----------------------------
// http://IP:PORT/top-level package의 마지막자리/임의대로 지정한 값
// C : 일반 클래스
//		일반메소드
//		컨트롤러 하나에 여러개의 요청 처리가 가능
//		=> 컨트롤러의 수는 최소한(패키지당 하나쯤)


@Controller
public class HomeController {
	
	//사이트 첫 접속시 메소드 : GET
	//value에는 아무것도 쓰지 않은 상태
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	//hihi.test라는 주소로 GET방식 요청이 들어오면
	//index.jsp로 포워딩 해주는 메소드
	@RequestMapping(value = "/hihi.test", method = RequestMethod.GET)
	public String testHiHi() {
		
		return "index";
	}
	
	//lalala.test라는 주소로 겟방식 요청
	//랄랄라~
	@RequestMapping(value = "/lalala.test", method = RequestMethod.GET)
	public void lalala() {
		
		System.out.println("랄랄라~~");
	}
}
