	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 2~9단 구구단 -->
	<%
		int z;
		for(int x=1; x<10; x++){
	%>
		<table border="1">
			<tr>
				<td><%=x %>단</td>
	<%
			for(int y=1; y<10; y++){
				z = x * y;
	%>
		<td><%=x %> x <%=y %> = <%=z %></td>					
	<%
			}
	%>
	<%
		}
	%>
			</tr>
		</table>
	<%-- 
	<%
	for(int x=1; x<10; x++){
	%>
	<table border="1">
		<tr>
			<th><%=x %>단</th>
		</tr>
		<%
			for(int y=1; y<10; y++){
		%>
		<tr>
			<td><%=x %> x <%=y %> = <%= x*y %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
	}
	%>
	--%>
</body>
</html>