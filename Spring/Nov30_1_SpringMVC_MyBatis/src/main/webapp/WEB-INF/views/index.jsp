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
	<%--form 버튼 방식 이름 별명 입력받고
		버튼누르면 student.reg로 이동하게--%>
	<form action="student.reg">
		이름 : <input name="s_name"><p>
		별명 : <input name="s_nickname"><p>
		<button>입력</button>
	</form>	
	<hr>
	<c:forEach var="s" items="${students }">
		<h2>${s.s_name } - ${s.s_nickname }</h2>
	</c:forEach>
	
	<%--버튼누르면 test.reg주소로 이동
		과목명은 그냥 입력받고, 시험날짜는 select option으로 (년도 : 2023~2024) --%>
	<form action="test.reg">
		과목명 : <input name="t_title"><p>
		시험날짜 : 
			<select name="t_y">
				<c:forEach var="y" begin="2023" end="2024">
					<option>${y }</option>
				</c:forEach>			
			</select>년
			<select name="t_m">
				<c:forEach var="m" begin="1" end="12">
					<option>${m }</option>
				</c:forEach>
			</select>월
			<select name="t_d">
				<c:forEach var="d" begin="1" end="31">
					<option>${d }</option>
				</c:forEach>
			</select>일<p>
			<button>등록</button>
	</form>
	<hr>
	<c:forEach var="t" items="${tests }">
		<h2>${t.t_title } - 
			<fmt:formatDate value="${t.t_when }" type="date"
				dateStyle="long" /></h2>
	</c:forEach>
	<h1>${r }</h1>
</body>
</html>