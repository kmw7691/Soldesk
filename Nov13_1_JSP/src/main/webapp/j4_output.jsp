<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>j4_output.jsp</title>
</head>
<body>
	<%
		//GET / POST
		//원래) 요청파라미터 -> 한글처리
		//		GET방식 - 안함
		//		POST방식 - 해야댐
		//		일단 요청하고 ㄱ
		request.setCharacterEncoding("utf-8");
		
		//원래)응답 한글처럼(필요햇엇음)
		//ex) jsp파일 기준 1,2,6번줄에서 해주고있어서 필요x
		//request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x + y;
	%>
 	이름 : <%= name %>
 	<h1><%=x %> + <%=y %> = <% %></h1>
</body>
</html>