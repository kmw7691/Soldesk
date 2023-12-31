package com.kwak.nov141.bmi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//MVC패턴을 사용한 JSP Model2로 BMI프로그램 만들기
//JSP Model2를 하는동안 >> 첫접속은 컨트롤러

//0.servlet에서 실행 -> GET방식 접속
//1.table + form 활용해서 BMI검사(이름 키 몸무게 사진 -> 유효성검사&css)
//		ㄴ BMIInput.html
//2.M에서 bmi계산 -> jsp(BMIOutput.jsp)에서 표현
//3.POST방식으로 BMI결과 .jsp페이지에 나오도록

@WebServlet("/HomeConroller")
public class HomeConroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("BMIV1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BMIM1.calculate(request);
		request.getRequestDispatcher("BMIOutput2.jsp").forward(request, response);
	}
}
