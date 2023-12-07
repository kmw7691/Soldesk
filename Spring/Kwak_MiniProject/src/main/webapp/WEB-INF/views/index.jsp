<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/board.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/kwakCheck.js"></script>
<script type="text/javascript" src="resources/js/kwak_jQuery.js"></script>
<script type="text/javascript" src="resources/js/KwakValidChecker.js"></script>
</head>
<body>
	<table id="siteMenuArea">
		<tr>
			<td align="right">
				<table id="siteMenuArea2">
					<tr>
						<td align="center"><a href="board.go"><img src="resources/img/sns.png"></a></td>
						<td align="center"><a href="#"><img src="resources/img/gallery.png"></a></td>
						<td align="center"><a href="#"><img src="resources/img/brush.png"></a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	<table id="siteLoginArea">
		<tr>
			<td><jsp:include page="${lp}" /></td>
			<td><div id="r">${r }</div></td>
		</tr>
	</table>
	 
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id=siteTitleArea2>
					<tr>
						<td id="siteTitle" valign="bottom">
						<a href="index.go">Spring Mini Project</a></td>
					</tr>
					<tr>
						<td id="siteSubTitle">
							점점어렵당
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	
	<table id="siteContentArea">
		<tr>
			<td><td align="center"><jsp:include page="${cp}" /></td>
		</tr>
	</table>
	
</body>
</html>