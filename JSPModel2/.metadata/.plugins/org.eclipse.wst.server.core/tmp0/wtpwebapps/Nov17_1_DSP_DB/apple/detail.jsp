<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
</head>
<body>
	<h1>Apple Information</h1>
	<form action="AppleDetailController" method="post">
		지역 : <input readonly="readonly" name="a_location" value="${apple.a_location }"><p>
		색 : <input autocomplete="off" name="a_color" value="${apple.a_color }"><p>
		맛 : <input autocomplete="off" name="a_flavor" value="${apple.a_flavor }"><p>
		가격 : <input autocomplete="off" name="a_price" value="${apple.a_price }"><p>
		설명 : <textarea autocomplete="off" maxlength="80" name="a_introduce">
			  	${apple.a_introduce }
			  </textarea><p>
		  <button>수정</button>
	</form> <!-- form 버튼 여러개있으면 여러개 모두 같은동작 -->
		<button onclick="deleteApple('${apple.a_location}');">삭제</button>
</body>
</html>