<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>첫번째스프륑</h1>
	[JSP Model 2] -> http://Ip:PORT/ProjectName/FileName
	[Spring]	  -> http://Ip:PORT/Top-Level Package의 마지막 자리/FileName
	
	Package명이 같으면 프로젝트가 달라도 주소가 같아질 수 있어서
	에러 발생확률이 높으니 top-level package는 이름이 중복되지 않도록 주의
	
	Spring 프로젝트 실행 -> 프로젝트 자체를 선택후 ctrl + f11 -> Run on Server
	
	Spring 구조
		- Java Resources
			자바의 영역(src/main/java)		: Java코드 작성
			자원의 영역(src/main/resources)	: MyBatis(XML)파일, DB파일, ...
			src/test : main쪽 파일 테스트용
			
		- src - main - webapp - resources
			js, css, img,...
		
		- src - main - webapp - WEB-INF
			(웹의 중요한 파일들이 노출되지 않도록 만든 폴더)
			cf) META-INF 폴더 : 자바에서 설정 관련된 파일을 저장하는 폴더
		
			Spring이라는 폴더 안에 root-context.xml
					:워크스페이스 전체에 대한 설정
					appServlet - servlet-context.xml
						:현재 프로젝트에 대한 설정
			
			views폴더 : View를 작성하는곳(jsp)
			web.xml : 프로그램실행시 함께 따라가는 설정들을 모아둔 파일
			pom.xml : 필요한 라이브러리들을 maven의 중앙저장소에서 가져와서 관리해주는 파일(.jar 파일을 maven으로 저장)
</html>