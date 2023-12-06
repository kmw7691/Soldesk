<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table>
		<tr>
			<td><img id="loginMemberImg"
				src="resources/img/${sessionScope.loginMember.c_photo }"></td>
			<td id="loginMemberID" valign="top">${sessionScope.loginMember.c_id }(${sessionScope.loginMember.c_name })</td>
			<td align="right"><button
					onclick="memberInfoGo();" class="loginMemberBtn">회원정보</button>
				<button onclick="logout();" class="loginMemberBtn">로그아웃</button></td>
		</tr>
	</table>
</body>
</html>