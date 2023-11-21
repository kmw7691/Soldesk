<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>V2.jsp</title>
</head>
<body>
	<%--
		EL (Expression Language)
			값을 받을때 Java대신 사용가능
			-jsp에서만 사용가능(.jsp를 톰캣이 servlet으로 바꿀때 el을 java코드로 번역해줌)
			
			문법 : ${xxx}
				-연산자 사용가능
				-형변환자동
				-값이 없을때 그냥 넘어감(error)
				-import 없어도됨
				
			파라미터값 읽기 : ${param.파라미터명}
			어트리뷰트값 읽기 : 
					주소값 : ${어트리뷰트명}
					속성값 : ${어트리뷰트명.멤버변수명}
			
			어트리뷰트값읽기(List, [])
					AL, []자체 : ${어트리뷰트명}
					index위치의 객체 : ${어트리뷰트명[인덱스]}
					index의치의 객체 속성 : ${어트리뷰트명[인덱스].멤벼변수명}
	 --%>
	<h1>ㄷㄷ</h1>
	${param.x }<br><!-- input의 name을 붙임 -> param.input의 name -->
	${param.y }<br>
	${param.x * param.y }<br><!-- 연산가능 -->
	${z }<br><!-- java에서 만든 attribute는 request.setAttribute("어트리뷰트명" 자바의변수명) -->
	<hr>
	${kk }<br>
	${kk.name } - ${kk.age }<br>
	${param.afqwrfadsfafqfq }<!-- 없는값쓰면 그냥 넘어감 -->
	<hr> 
	${ks }<br>
	${ks[2] }<br>
</body>
</html>