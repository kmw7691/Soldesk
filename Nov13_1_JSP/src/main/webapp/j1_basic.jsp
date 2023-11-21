<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>j1_basic.jsp</title>
</head>
<body>
	<h1>오전 09시14분</h1>
	<h1>JSP시작</h1>
	HTML : 웹사이트제작가능
	-------------------디자인 / 이벤트 부주고 : 못생기고 정적인 이벤트만 가능
	HTML : 뼈대를만들고
	CSS : 디자인
	JavaScript : 이벤트 처리
	--------------------- 파라미터 읽기, 계산, 조건문, 반복문 : 프로그래밍언어쪽 기능 부재
	Servlet : 클라이언트가 요청
			-> HTML + CSS + JavaScript를 만들어서 응답하는 자바프로그램
	---------------------어렵고, 작업이 불편
	JSP(Java Servlet/Server Page)
		작업 형태 : HTML + CSS + JavaScript에 필요한 부분마다 Java코드를 살짝 추가
		실제 정체 : Tomcat이 Java코드 부분을 Servlet으로 바꿔서 실행
		
		Servlet : 자바코드 안에서 HTML을 구현
		JSP : HTML안에서 자바코드를 추가
	<!-- 
		이것도 주석 가능
	 -->
	 
	<%-- 
		1.JSP주석(지금 필기 감싼 형태가 주석)
		2.스크립트릿(Scriptlet)
			JSP에서 Java코드를 실행할 때 사용하는 블록
			<% 자바코드는 여기 %>
		3.지시자
			특별한 지시를 내릴수 있도록 하는 블록
			<%@ page include taglib ... %>
		4.표현식
			어떤 값을 (웹페이지에) 출력 결과로 포함시키고 싶을때 사용하는 블록
			<%= Value %>
			숫자, 문자열 변수등 값 사용가능
			Servlet의 out.print()와 비슷한 기능
			
		5.선언문
			표현식에서 사용할 수 있는 Java의 Method를 작성할 때 사용하는 블록
			<%!멤버변수, method%>	
			Java의 Method와 동일함
	 --%>
</body>
</html>