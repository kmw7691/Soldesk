<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
</head>
<body>
	<form action="CalcController" name="calcForm" onsubmit="return check();">
		<table>
			<tr>
				<td align="center">
					<label>X : </label>
					<input placeholder="x" autofocus="autofocus" autocomplete="off"
					 name="x"><br>
				</td>
				<td align="center">
					<label>Y : </label>
					<input placeholder="y" autofocus="autofocus" autocomplete="off"
					 name="y">
				</td>
			</tr>
			<tr><td align="center"><button>계산 ㄱㄱ</button></td></tr>
		</table>
	</form>
</body>
</html>