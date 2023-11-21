<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>j2_basic.jsp</title>
</head>
<body>
	<!-- 
		랜덤한 숫자를 넣었을때 짝/홀 알려주는 기능
	 -->
	 <%!
	 	public String getOE(int x){
		 return (x % 2 == 0) ? "짝" : "홀"; 
	 }
	 %>
	 
	 <%
	 	Random r = new Random();
	 	int x = r.nextInt(100) + 1;
	 %>
	 <h1>뽑은 숫자 <%=x %></h1>
	 <h1>홀짝 :  <%=getOE(x) %></h1>
</body>
</html>