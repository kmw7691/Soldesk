<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/chung_jQuery.js"></script>
<script type="text/javascript" src="resources/js/chungCheck.js"></script>
<script type="text/javascript" src="resources/js/chungValidChecker.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<table id="siteMenuArea">
		<tr>
			<td align="right">
				<table id="siteMenuArea2">
					<tr>
						<td align="center"><a href="sns.go"><img src="resources/img/sns.png"></a></td>
						<td align="center"><a href="#"><img src="resources/img/gallery.png"></a></td>
						<td align="center"><a href="#"><img src="resources/img/brush.png"></a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td><jsp:include page="${loginPage }" /></td><td><div id="r">${r }</div></td>
		</tr>
	</table>
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td id="siteTitle" valign="bottom"><a href="index.go">This is
						<span class="small">Chung's</span> Spring <span class="small">
						Mini Project</span><span id="v">&nbsp;까꿍</span>
						</a></td>
					</tr>
					<tr>
						<td id="siteSubTitle" align="right">여러분<span id="but"></span>화이팅!&nbsp;<span
							id="city-aqi-container" style="text-shadow: none;"></span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<table id="siteContentArea">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>