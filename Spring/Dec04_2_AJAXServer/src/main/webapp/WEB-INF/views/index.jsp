<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idnex.jsp</title>
</head>
<body>
	<c:forEach var="e" items="${errors }">
		${e.e_what } - ${e.e_where }<p>
	</c:forEach>
</body>
</html>