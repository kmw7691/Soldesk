<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hj.jsp</title>
<link rel="stylesheet" href="css/hj.css">
</head>
<body>
	<table id="hjTbl">
		<tr>
			<th colspan="2">홀짝</th>
		</tr>
		<tr>
			<td align="center"><a href="HomeController?userAnswer=1"><img src="1.png"></a></td>
			<td align="center"><a href="HomeController?userAnswer=0"><img src="2.png"></a></td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">동전 : ${c }개</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">답 : ${r }</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">답 : ${t }전 ${w }승 ${l }패</td>
		</tr>
	</table>
</body>
</html>