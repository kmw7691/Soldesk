<%@page import="com.kwak.nov141.bmi.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMIOutput.jsp</title>
<%
	request.setCharacterEncoding("utf-8");
	Guest g = (Guest) request.getAttribute("g");
%>
</head>
<body>
	<table border="1">
		<tr><th colspan="2">BMI결과</th></tr>
		<tr>
			<td align="center">이름</td>
			<td><%=g.getName() %></td>
		</tr>
		<tr>
			<td align="center">키</td> 
			<td><%=g.getHeight() %></td>
		</tr>
		<tr>
			<td align="center">몸무게</td> 
			<td><%=g.getWeight() %></td>
		</tr>
		<tr>
			<td align="center">bmi</td>
			<td><%=g.getBmi() %></td>
		</tr>
		<tr>
			<td align="center">결과보고</td>
			<td><%=g.getResult() %></td>
		</tr>
		<tr><%--   
			<td colspan="2"><img src="img/<%=g.getImage()%>">
			</td>--%>
		</tr>
		</table>
</body>
</html>