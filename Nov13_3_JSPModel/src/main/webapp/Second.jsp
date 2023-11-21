<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Second.jsp</title>
</head>
<body>
	<!-- 
		이동 : 
			fist -> second : 사용자가 뭔가 액션을 해서 수동으로 넘어온
								-request(요청)
			second->Third : 그냥넘어감
						-redirect:단순 자동이동
						response.sendRedirect("Third.jsp");
						
						forward : 자동이동(값이 전달되는)
						RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
						rd.forward(request, response);
						
						include : 포함(second속에 Third가 포함되는)
							위치조절이 불가능(third가 무조건 상단에 들어옴)-비추
							조만간 위치조정이 되는 include 할거임		
							RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
							rd.forward(request, response);
							
		값
			parameter
				html에서 만들어낸 값(a,b)
				request에 저장
				String or String[]
			
			attibute
				Java에서 만들어낸 값(c)
				request에 저장
				Object(객체)
 	-->
 	
	<%
		request.setCharacterEncoding("utf-8");
		int a = Integer.parseInt(request.getParameter("a")); 
		int b = Integer.parseInt(request.getParameter("b"));
		
		//RequestDispatcher : client로부터 들어온 요청(request)을
		//						원하는쪽으로 (요청을) 넘기는 기능
		//호출 된 페이지에서는 request.setAttribute(key, value)메소드를 통해서
		//넘겨받은 데이터 처리가 가능해짐
		//		->Redirect와는 다르게 request와 response 객체를 가지고 넘어가기 때문
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		
		int c = a + b;
		request.setAttribute("c", c);	//c자리에 지금 만든 c값을 넣겠다
		
		String d = "ㅋ";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		//rd.forward(request, response);
		rd.include(request, response);
		
		
	%>
	<h2>Second</h2>
	<hr>
	a : <%=a %><br>
	b : <%=b %><br>
</body>
</html>