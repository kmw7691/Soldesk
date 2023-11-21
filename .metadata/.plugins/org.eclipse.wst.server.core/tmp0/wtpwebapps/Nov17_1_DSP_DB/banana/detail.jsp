<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
</head>
<body>
	Banana Information
	<form action="BananaDetailController" method="post">
		<button>수정</button><br>
		상표 : <input readonly="readonly" name="maker" value="${banana.maker }"><p>
		지역 : <input readonly="readonly" name="location" value="${banana.location }"><p>
		개수 : <input autocomplete="off" name="howmany" value="${banana.howmany }"><p>
		맛 : <input autocomplete="off" name="flavor" value="${banana.flavor }"><p>
		색 : <input autocomplete="off" name="color" value="${banana.color }"><p>
		가격 : <input autocomplete="off" name="price" value="${banana.price }"><p>
		설명 : <textarea autocomplete="off" maxlength="100" name="introduce" 
				${banana.introduce }>
		</textarea><p>
	</form>
		<button onclick="deleteBanana('${banana.location}');">삭제</button>
</body>
</html>