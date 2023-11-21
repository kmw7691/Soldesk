<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nb.jsp</title>
<link rel="stylesheet" href="nb.css">
<script type="text/javascript" src="KwakValidChecker.js"></script>
<script type="text/javascript" src="nbCheck.js"></script>
</head>
<body>
<form name="nbForm" method="post"
	enctype="multipart/form-data" onsubmit="return checkValid();">
	<table id="nbTbl">
		<tr>
			<th colspan="2">숫자야구</th>
		</tr>
		<tr>
			<td class="td1" align="center">첫번째 숫자</td> 
			<td class="td2"><input name="first" maxlength="1"
				autofocus="autofocus" autocomplete="off"></td>
		</tr>
		<tr>	
			<td class="td1" align="center">두번째 숫자</td> 
			<td class="td2"><input name="second" maxlength="1"
				autofocus="autofocus" autocomplete="off"></td>
		</tr>
		<tr>	
			<td class="td1" align="center">세번째 숫자</td> 
			<td class="td2"><input name="third" maxlength="1"
				autofocus="autofocus" autocomplete="off"></td>
		</tr>
		<tr><td></td><td align="center"><button>입력</button><br><br></td></tr>
		
				
		<tr>
			<th colspan="2">숫자야구결과</th>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">진행횟수 : ${count }회</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">진행 : ${s }strike ${b }ball ${o }out</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">정답 : ${answer1 } ${answer2 } ${answer3 }</td>
		</tr>
	</table>
</form>
</body>
</html>