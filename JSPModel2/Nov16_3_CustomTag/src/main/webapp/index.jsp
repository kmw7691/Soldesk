<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%--가장 메인이되는 jsp파일에 모든 링크 몰아넣기 --%>
<%--css : id먹인거는 무조건하나만, 여러개 동시에 같은효과 주고싶을때는 class --%>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="JS/KwakValidChecker.js"></script>
<script type="text/javascript" src="JS/nov16_Check.js"></script>

</head>
<body>
	<table id="siteTbl">
		<tr><th align="right">2023년 11월 16일 목요일</th></tr>
		<tr>
			<td id="siteMenu">
				<hr>
				<a href="HomeController">Home</a>
				<a href="CalcController">사칙연산</a>
				<a href="JSTLCController">JSTL-CORE</a>
				<a href="JSTLFController">JSTL-Formatting</a>
				<hr>
			</td>
		</tr>
		<tr><!-- jsp:include로 구멍뚫어놓은곳을 el처리 했을때 모든 컨트롤러에서 다 채워줘야댐 -->
			<td id="siteContent"><jsp:include page="${contentPage }" /></td>
		</tr>
		<tr>
			<td>
				<img src="css/aa.png" id="img1">
				<img src="css/bb.png" id="img2">
			</td>
		</tr>
	</table>
</body>
</html>