<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
	<form action="member.join" method="post" enctype="multipart/form-data"
		onsubmit="return joinCheck();" name="joinForm">
		<table id="joinTbl">
			<tr>
				<td align="center" colspan="2"><input id="join_c_id"
					name="id" placeholder="ID" class="i1" autocomplete="off"
					autofocus="autofocus" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password"
					name="pw" placeholder="PW(숫자만 하나 이상)" class="i1"
					autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password"
					name="pwChk" placeholder="PW확인" class="i1" autocomplete="off"
					maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="name"
					placeholder="이름" class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input id="join_c_addr1"
					name="addr1" placeholder="우편번호" class="i1" autocomplete="off"><br>
					<input id="join_c_addr2" name="addr2" placeholder="주소" class="i1"
					autocomplete="off"><br> <input name="addr3"
					maxlength="50" placeholder="상세주소" class="i1" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center" style="width: 100px;">&nbsp;프사</td>
				<td><input name="photo" type="file"
					style="font-family: 'b'; font-size: 13pt; font-weight: 900;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>