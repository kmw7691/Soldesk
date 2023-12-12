<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<table id="loginTbl">
		<tr>
			<form action="member.login" method="POST">
			<td><input name="id" placeholder="ID" class="i1" maxlength="10"
				autocomplete="off"></td>
			<td><input name="pw" type="password" placeholder="PW" class="i1"
				maxlength="10"></td>
			<td><button>로그인</button></td>
			</form>
			<td><button onclick="goJoin();">회원가입</button></td>
		</tr>
	</table>
</body>
</html>