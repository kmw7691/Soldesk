<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
</head>
<body>
	<table id="joinTbl">
		<form action="member.update" method="post"
			enctype="multipart/form-data" onsubmit="return memberUpdateCheck();"
			name="memberUpdateForm">
			<tr>
				<td align="center" colspan="2"><input
					value="${sessionScope.loginMember.id }" name="id"
					placeholder="ID" class="i1" autocomplete="off" readonly="readonly"
					autofocus="autofocus" maxlength="10"
					style="border: none; text-align: center; background-color: transparent;"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password"
					value="${sessionScope.loginMember.pw }" name="pw"
					placeholder="PW(숫자만 하나 이상)" class="i1" autocomplete="off"
					maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password"
					value="${sessionScope.loginMember.pw }" name="pwChk"
					placeholder="PW확인" class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="name"
					value="${sessionScope.loginMember.name }" placeholder="이름"
					class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input id="join_c_addr1"
					value="${addr[2] }" readonly="readonly" name="addr1"
					placeholder="우편번호" class="i1" autocomplete="off"><br>
					<input id="join_c_addr2" value="${addr[0] }" readonly="readonly"
					name="addr2" placeholder="주소" class="i1" autocomplete="off"><br>
					<input name="addr3" value="${addr[1] }" maxlength="50"
					placeholder="상세주소" class="i1" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center" style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프사</td>
				<td><br>
				<img src="resources/img/${sessionScope.loginMember.photo }"
					style="max-width: 30%; box-shadow: 3px 3px 3px black;"> <br>
					<input name="photo" type="file"
					style="font-family: 'b'; font-size: 13pt; font-weight: 900;"></td>
			</tr>
		<tr>
			<th style="padding-top: 10px; padding-bottom: 10px;" colspan="2">
				<button style="width: 80%; height: 50px;">수정</button>
			</th>
		</tr>
		</form>
		<tr>
			<th style="padding-top: 10px; padding-bottom: 10px;" colspan="2">
				<button onclick="bye();" style="width: 80%; height: 50px;">탈퇴</button>
			</th>
		</tr>
	</table>
</body>
</html>