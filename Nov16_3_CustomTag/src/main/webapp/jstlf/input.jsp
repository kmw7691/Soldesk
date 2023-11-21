<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
<style type="text/css">
	div{
		font-size:20pt;
		margin-left: auto;
		margin-right: auto;
		font-weight: 700;
		text-shadow: yellow 0px 0px 5px;
	}
	
</style>
</head>
<body>
	<fmt:formatNumber value="${a }" type="number" /><!-- 보통의 숫자표현 -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" /><!-- 통화(돈) -->
	<hr>
	<fmt:formatNumber value="${b}" type="percent" /><!-- 퍼센트(소수점 반올림) --> 
	<hr>
	<fmt:formatNumber value="${c }" pattern="#.00" /><!-- 소수점 둘째자리까지(반올림) -->
	<hr>
	<fmt:formatDate value="${d }" type="date" dateStyle="long" /><br>
	<fmt:formatDate value="${d }" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="long" /><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="short" /><br>
	<fmt:formatDate value="${d }" type="both" dateStyle="short" /><hr>
	
	<c:forEach var="s" items="${snacks }">
		${s.name } - 
		<fmt:formatNumber value="${s.price }" type="currency" />-
		<fmt:formatDate value="${s.exp }" type="date" dateStyle="long" /><br>
	</c:forEach>
</body>
</html>