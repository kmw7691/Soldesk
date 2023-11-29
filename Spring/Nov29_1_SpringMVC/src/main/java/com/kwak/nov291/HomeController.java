package com.kwak.nov291;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
		//servlet-context.xml의 beans에서
		//prefix인 "WEB_INF/views/"와 중간경로인 return부분의 index와
		//suffix인 ".jsp"가 합쳐져서
		//"WEB_INF/views/index.jsp"라는 view파일 경로로 이동해서
		//클라이언트에게 응답을 해주는 형태
	}
	
}

//@ : annotation
//		사전적의미 : 주석
//		코드 사이에 주석처럼 쓰이며 기능을 수행하도록 하는 기술
//		-코드 작성 문법 에러를 체크하도록 정보를 제공
//		-이 개발 툴이 코드를 자동으로 생성할 수 있게 도와줌
//		-실행시에 특정 기능을 수행하도록 도와줌

//종류:
//		1. @Controller 		: Spring의 Controller
//		2. @Autowired 		: 속성, setter, 생성자에서 사용
//		3. @RequestMapping 	: 요청에 따라 어떤 Controller, 어떤 Method가 처리될지 매핑하기 위해 사용
//					value	: 요청받을 주소(URL)를 설정
//					method	: 어떤 요청으로 받을지 설정(GET / POST / PUT / DELETE / FETCH /...)
//							  W3C(표준 개발 기구, World Wide Web Consortium)에서
//							  PUT, DELETE, FETCH들이 과연 유용한가?
//		4. @RequestParam	: 요청 파라미터 설정
//		5. @RestController	: Controller중에서 view쪽으로 응답하지 않는 Controller
//					data(xml, json)등을 return해주는게 목적(Spring 4.x 버전부터 제공)
//		6. @ResponseBody	: Java 객체를 HTTP 요청의 body 내용으로 매핑을 해주는 역할
//					RestController : Controller + ResponseBody
//		7. @Service			: 비즈니스 로직을 수행하는 Class를 나타낼 때 사용
//					 비즈니스 로직(Business Logic) : 사용자의 눈에는 안보이지만, 사용자가 원하는 결과물을 올바르게 도출할 수 있도록 짜여진 코드(eg. DAO(Model))
//		8. @XmlRootElement / @XmlElement
//					OXM(Object XML Mapping)을 하기위해 사용
//					특정 데이터를 XML형태로 만들어주는 것 : 마샬링(mashalling)
//					XML데이터를 특정 데이터로 만들어주는 것 : 언마샬링(unmashalling)
//					XmlRootElement : Javabean의 Class명 위에 명시
//					XmlElement : Javabean의 모든 setter에 명시
