<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg.jsp</title>
</head>
<body>
	<h1>Banana</h1>
	<form action="" name="bananaForm"
	onsubmit="return check();" method ="post">
		상표 : <input name="maker" autocomplete="off"
				autofocus="autofocus" placeholder="상표"><hr>
		지역 : <input name="location" autocomplete="off" 
				autofocus="autofocus" placeholder="지역"><hr>
		개수 : <input name="howmany" autocomplete="off"
				autofocus="autofocus" placeholder="개수"><hr>
		맛 : <select name="flavor">
				<option>단맛</option>
				<option>쓴맛</option>
				<option>매운맛</option>
				<option>짠맛</option>
				<option>신맛</option>
			</select><hr>
		색 : <select name="color">
				<option>노랑</option>
				<option>초록</option>
				<option>빨강</option>
				<option>검정</option>
				<option>파랑</option>
			</select><hr>
		가격 : <input name="price" autocomplete="off" placeholder="숫자만입력"><hr>
		설명 : <textarea name="introduce" maxlength="100"
				autocomplete="off" placeholder="5자 이상"></textarea>
		
		<button>등록</button>
	</form>
</body>
</html>