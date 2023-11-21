<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMIOutput.jsp</title>
</head>
<body>
	<!-- 
		Servlet : Java로도 안에서 html을 구현
		jsp : html에서 java로도 작성 가능
	 -->
	 <%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String path = request.getServletContext().getRealPath("img");
		MultipartRequest mr = new MultipartRequest(
				request, path,
				30*1024*1024,	//허용할 파일의 최대크기(byte)
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		height /= 100;
		double weight = Double.parseDouble(mr.getParameter("weight"));
		
		
		double bmi = weight / (height * height);
		String result = "저체중";
		
		if(bmi >= 40) {
			result = "고도비만";
		}else if(bmi >= 35) {
			result = "중등도비만";
		}else if(bmi >= 30) {
			result = "경도비만";
		} else if(bmi >= 25) {
			result = "과체중";
		} else if(bmi >= 18.5) {
			result = "정상";
		}
		
		//소수점 둘째자리까지(**아래 html태그 안에서는 불가능)
		String bmi2 = String.format("%.2f", bmi);
		
		String image = mr.getFilesystemName("photo");
		image = URLEncoder.encode(image, "utf-8");
		image = image.replace(" ", "+");
	 %>
	 <table>
	 	<tr><th colspan="2">BMI Result</th></tr>
	 	<tr>
	 		<td align="center">이름</td>
	 		<td><%=name %></td> <!-- 위 자바변수에 담은것을 가져오는 거라 변수명 그대로 사용 -->
	 	</tr>
	 	<tr>
	 		<td align="center">키</td>
	 		<td><%=height * 100 %>cm</td>
	 	</tr>
	 	<tr>
	 		<td align="center">몸무게</td>
	 		<td><%=weight %>kg</td>
	 	</tr>
	 	<tr>
	 		<td align="center">BMI</td>
	 		<td><%=bmi2 %></td>
	 	</tr>
	 	<tr>
			<td colspan="2" algin="center"><marquee>당신은 <%=result %>입니다</marquee></td>	 	
	 	</tr>
	 	<tr>
	 		<td colspan="2" algin="center"><img src="img<%=image %>" style="max-width:60%;"></td>
	 	</tr>
	 </table>
</body>
</html>





















