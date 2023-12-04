<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<c:forEach var="f" items="${fruits }">
		${f.f_name } - ${f.f_price } -
		<fmt:formatNumber type="currency" value="${f.f_price }" /><p>
	</c:forEach>
</body>
</html>