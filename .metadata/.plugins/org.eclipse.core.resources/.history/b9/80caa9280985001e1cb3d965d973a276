<%@page import="com.kwak.db.manager.KwakDBManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbc.jsp</title>
</head>
<body>
<%
	Connection con = null;
	String result = "실패";
try{
	//1.
	//Class.forName("oracle.jdbc.OracleDriver");
	//String addr = "jdbc:oracle:thin:@localhost:1521:xe";
	//con = DriverManager.getConnection(addr, "minwoo", "951753");
	
	con = KwakDBManager.connect("kwakPool"); // context.xml의 name부분
	
	result = "성공";
} catch (Exception e){
	e.printStackTrace();
}
%>
<table>
	<tr><td>
		<h1>dbc</h1>
		<h1><%=result %></h1>
	</td></tr>
</table>
</body>
</html>