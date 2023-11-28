<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMIOutput2.jsp</title>
</head>
<body>
<%
	String name = (String) request.getAttribute("name");
	double height = (Double) request.getAttribute("height");
	double weight = (Double) request.getAttribute("weight");
	double bmi = (Double) request.getAttribute("bmi");
	String result = (String) request.getAttribute("result");
%>
	<table border="1">
		<tr><th colspan="2">BMI결과</th></tr>
		<tr>
			<td align="center">이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td align="center">키</td> 
			<td><%=height %></td>
		</tr>
		<tr>
			<td align="center">몸무게</td> 
			<td><%=weight %></td>
		</tr>
		<tr>
			<td align="center">bmi</td>
			<td><%=bmi %></td>
		</tr>
		<tr>
			<td align="center">결과보고</td>
			<td><%=result %></td>
		</tr>
		</table>
</body>
</html>