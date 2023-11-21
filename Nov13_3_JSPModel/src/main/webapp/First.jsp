<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First.jsp</title>
<script>
	function go(){
		location.href = "Second.jsp?a=100&b=50";
	}
</script>
</head>
<body>
	<!-- 
		a,b에 숫자 넣어서 second.jsp로 이동
		수동ver 3가지 모두사용
	 -->
	 a:<input name="a"><a href="Second.jsp">A</a><p>
	 b:<input name="b"><a href="Second.jsp">B</a><p>
	 <form action="Second.jsp">
	 	a:<input name="a1"><p>
	 	b:<input name="b1"><p>
	 	<button>ㄱㄱ</button>
	 </form>
	 <div onclick="go();">ㄱㄱㄱㄱㄱㄱ</div>
	 
</body>
</html>