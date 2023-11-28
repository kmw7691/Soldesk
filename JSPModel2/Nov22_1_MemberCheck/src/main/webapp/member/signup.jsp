<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 생년월일 할 때 option쪽 반복하기 위해 필요(WEB-INF -> lib -> jstl.jar --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/signup.jsp</title>
</head>
<body>
	<%-- Javabean 멤버변수명 = DB 필드명 = JSP 요청 파라미터명 --%>
	<form action="SignUpController" name="signupForm" enctype="multipart/form-data"
		onsubmit="return signUpCheck();" method="post">
		<table id="signupTbl">
			<tr><th>회원가입</th></tr>
			<tr><td align="center">
				<input name="m_id" placeholder="ID" autofocus="autofocus" autocomplete="off"
				maxlength="10"> </td></tr>
			<tr><td align="center">
				<input name="m_pw" placeholder="PW" autocomplete="off" type="password"  
				maxlength="10"> </td></tr>
			<tr><td align="center">
				<input name="m_pwChk" placeholder="PW Check" autocomplete="off" type="password" 
				maxlength="10"> </td></tr>
			<tr><td align="center">
				<input name="m_name" placeholder="NAME" autocomplete="off" maxlength="10"> </td></tr>
			<tr><td align="center">
				<input name="m_phone" placeholder="PHONE" autocomplete="off" maxlength="13"> </td></tr>
			<tr>
				<td align="center"> 생년월일<br>
					<select name="m_y">
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select> &nbsp;년&nbsp;&nbsp;
					<select name="m_m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select> &nbsp;월&nbsp;&nbsp;
					<select name="m_d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select> &nbsp;일&nbsp;&nbsp;
				</td>
			</tr>
			<tr><td align="center">사진<br><input name="m_photo" type="file"></td></tr>
			<tr><td align="center"><button>Sign Up</button></td></tr>
		</table>
	</form>
</body>
</html>





