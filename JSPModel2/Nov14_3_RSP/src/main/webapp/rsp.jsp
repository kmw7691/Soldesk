<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rsp.jsp</title>
<link rel="stylesheet" href="rsp.css">
</head>
<body>
	<table id="rspTbl">
		<tr>
			<th colspan="3">가위바위보 게임</th>
		</tr>
		<tr>
			<td align="center"><a href="HomeController?userHand=1"><img src="1.png"></a></td>
			<td align="center"><a href="HomeController?userHand=2"><img src="2.png"></a></td>
			<td align="center"><a href="HomeController?userHand=3"><img src="3.png"></a></td>
		</tr>
		<tr>
			<td align="center" class="td2">유저</td>
			<td align="center" class="td2">VS</td>
			<td align="center" class="td2">컴퓨터</td>
		</tr>
		<tr>
			<td align="center" align="center"><img src="${uh }"></td>
			<td align="center" align="center">vs</td>
			<td align="center" align="center"><img src="${ch }"></td>
		</tr>
		<tr><td align="center" class="td1" colspan="3" align="center">판정 : ${r }</td></tr>
		<tr><td align="center" class="td1" colspan="3" align="center">${t }전 ${w }승 ${d }무 ${l }패</td></tr>
		
	</table>
</body>
</html>