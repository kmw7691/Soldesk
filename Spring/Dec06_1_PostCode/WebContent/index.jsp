<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" src="test.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>id : <input><p></td>
		</tr>
		<tr>
			<td>pw : <input type="password"><p></td>
		</tr>
		<tr>
			<td>pwChk : <input type="password"><p></td>
		</tr>
		<tr>	
			<td>name : <input><p></td>
		</tr>
		<tr>
			<td>
			addr : <input id="addr1" readonly="readonly"><br>
			 <input id="addr2" readonly="readonly"><br>
			 <input>
			</td>
		</tr>
			<tr><td><button>입력</button></td></tr>
	</table>
</body>
</html>