<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/apple.css">
<script type="text/javascript" src="JS/KwakValidChecker.js"></script>
<script type="text/javascript" src="JS/appleRegCheck.js"></script>
<script type="text/javascript" src="JS/bananaRegCheck.js"></script>
<script type="text/javascript" src="JS/go.js"></script>
</head>
<body>
	<table id="siteTitle">
		<tr><th id="siteTitleArea">
			<a href="HomeController">Title</a></th></tr>
		<tr>
			<td id="siteContentArea" align="center">
			<jsp:include page="${contentPage }" /></td>
		</tr>
	</table>
	<table id="siteMenuTbl">
		<tr>
			<td align="center"><a href="AppleController">Apple</a><td>
			<td align="center"><a href="BananaController">Banana</a></td>
			<td align="center"><a href="#">Cherry</a></td>
			<td align="center"><a href="DBCController">DB연결</a></td>
		</tr>
	</table>
</body>
</html>