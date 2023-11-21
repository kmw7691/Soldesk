package com.kwak.nov10.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/Output")
public class Output extends HttpServlet {
	//bmi = weight/heigt(m) * height
	//18.5미만 저체중
	//18.5이상 정상
	//25이상 과체중
	//30이상 경도비만
	//35이상 중등도비만
	//40이상 고도비만
	
	//계산해서 html형식으로 결과 뽑힐수 있도록
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String image = mr.getFilesystemName("photo");
		image = URLEncoder.encode(image, "utf-8");
		image = image.replace(" ", "+");

		PrintWriter pw = response.getWriter();
		
		pw.print("<html>");
		pw.print("<head><meta charset='UTF-8'>");
		pw.print("<title>BMI 결과</title></head>");
		pw.print("<body>");
		pw.print("<h1>BMI 결과</h1>");
		
		pw.printf("<h2>이름 : %s</h2>", name);
		pw.printf("<h2>키 : %.1f</h2>", height);
		pw.printf("<h2>몸무게 : %.1f</h2>", weight);
		pw.printf("<h2>BMI : %.1f</h2>", bmi);
		pw.printf("<h2>결과 : %s</h2>", result);
		
		pw.printf("<img src='img/%s'>", image);
		
		pw.print("</body>");
		pw.print("</html>");
	}

}
