<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output.jsp</title>
</head>
<body>
	<h1 align="center">결과</h1>
	<table>
		<tr>
			<td align="center"><h2>${param.x } + ${param.y } = ${a }</h2></td>
		</tr>
		<tr>
			<td align="center"><h2>${param.x } - ${param.y } = ${s }</h2></td>
		</tr>
		<tr>
			<td align="center"><h2>${param.x } x ${param.y } = ${m }</h2></td>
		</tr>
		<tr>
			<td align="center"><h2>${param.x } / ${param.y } = ${d }</h2></td>
		</tr>
	</table>
</body>
</html>