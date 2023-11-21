<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>V2.jsp</title>
</head>
<body>
	<h1>V2</h1>
	<%
		request.setCharacterEncoding("utf-8");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = (Integer)request.getAttribute("zz");
	%>
	<h2><%=x %> + <%=y %> = <%=z %></h2>
</body>
</html>