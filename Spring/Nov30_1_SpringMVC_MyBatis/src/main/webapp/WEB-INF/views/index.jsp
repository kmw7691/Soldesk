<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<%--form 버튼 방식 이름 별명 입력받고
		버튼누르면 student.reg로 이동하게--%>
	<form action="student.reg">
		이름 : <input name="s_name"><p>
		별명 : <input name="s_nickname"><p>
		<button onclick="">입력</button>
	</form>	
</body>
</html>