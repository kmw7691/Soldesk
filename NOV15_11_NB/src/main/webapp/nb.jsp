<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nb.jsp</title>
<link rel="stylesheet" href="css/nb.css">
<script type="text/javascript" src="JS/KwakValidChecker.js"></script>
<script type="text/javascript" src="JS/nov15_check.js"></script>
<script type="text/javascript">
	function goHome(){
		//JS페이지 이동
		location.href = "HomeController"; //첫접속과 같은 효과
	}
</script>
</head>
<body>
	<form action="HomeController" name="nbForm" onsubmit="return check();">
		<table id="nbTbl">
			<tr>
				<th class="title">숫자야구</th>
			</tr>
			<tr>
				<td align="center"><input id="ip" name="userAns"
				 maxlength="3" autocomplete="off"></td>
			</tr>
			<tr><th class="th1">숫자만 3자리, 중복숫자X</th></tr>
			<tr><th class="th1"><button>확인</button></th></tr>
			<tr><th class="th1">${ua }</th></tr>
			<tr><th class="th1">${s }</th></tr>
			<tr><th class="th1">${b }</th></tr>
			<tr><th class="th1">${t }</th></tr>
			<tr><th class="th1">${r }</th></tr>
		</table>
	</form>
	<table id="finTbl">
		<tr><td align="center"><div align="center">${btn }</div></td></tr>
		<tr><td align="center"><div align="center">${cmt }</div></td></tr>
	</table>
</body>
</html>