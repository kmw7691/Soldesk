<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberinfo.jsp</title>
</head>
<body>
<table id="signupTbl">
	<tr>
		<td align="center">
			<input name="m_id" readonly="readonly" value="${sessionScope.loginMember.m_id }">
		</td>
	</tr>
	<tr>	
		<td align="center">
			<input name="m_pw" value="${sessionScope.loginMember.m_pw }"
			 placeholder="PW" maxlength="10" type="password" autocomplete="off">
		</td>
	</tr>
	<tr>
		<td align="center">
			<input name="m_pwChk" value="${sessionScope.loginMember.m_pw }"
			placeholder="PW확인" maxlength="10" type="password" autocomplete="off">
		</td>
	</tr>
	<tr>
		<td align="center">
			<input name="m_name" value="${sessionScope.loginMember.m_name }"
			placeholder="이름" maxlength="10" autocomplete="off">
		</td>
	</tr>
	<tr>
		<td align="center">
			<input name="m_phone" value="${sessionScope.loginMember.m_phone }"
			placeholder="전화번호" maxlength="10" autocomplete="off">
		</td>
	</tr>
	<tr>
		<td align="center"> 생년월일<br>
			<select name="m_y">
			<option>
				<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="yyyy" />
			</option>
				<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
					<option>${y }</option>
				</c:forEach>
			</select> &nbsp;년&nbsp;&nbsp;
			<select name="m_m">
			<option>
				<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="M" />
			</option>
				<c:forEach var="m" begin="1" end="12">
					<option>${m }</option>
				</c:forEach>
			</select> &nbsp;월&nbsp;&nbsp;
			<select name="m_d">
			<option>
				<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" pattern="d" />
			</option>
				<c:forEach var="d" begin="1" end="31">
					<option>${d }</option>
				</c:forEach>
			</select> &nbsp;일&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td align="center">사진<br>
			<img src="img/${sessionScope.loginMember.m_photo }"><p>
			<input name="m_photo" type="file">
		</td>
	</tr>
	<tr>
		<td align="center">
			<button>정보수정</button>
			<button onclick="return memberDelete();">회원탈퇴</button>
		</td>
	</tr>
</table>
</body>
</html>