<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/welcome.jsp</title>
</head>
<body>
	<table id="loginSuccessTbl">
		<tr>
			<td><img src="img/${sessionScope.loginMember.m_photo }"></td>
			<td>${sessionScope.loginMember.m_id }</td>
		</tr>
		<tr>
			<td align="center" colspan="2">${sessionScope.loginMember.m_name }</td>
		</tr>
		<tr>
			<td align="center" colspan="2">ㅎㅇ</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button onclick="return memberInfoGo();">내정보</button>
				<button onclick="return logout();">로그아웃</button>
			</td>
		</tr>
	</table>	
</body>
</html>