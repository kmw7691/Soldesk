package com.kwak.nov141.bmi;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BMIM1 {
	public static void calculate(HttpServletRequest request) {
		try {
			String path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			
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
			
			height *= 100;
			
			//소수점 둘째자리까지(**아래 html태그 안에서는 불가능)
			String height3 = String.format("%.2f", height);
			double height2 = Double.parseDouble(height3);
			
			String weight3 = String.format("%.2f", weight);
			double weight2 = Double.parseDouble(weight3);
			
			String bmi3 = String.format("%.2f", bmi);
			double bmi2 = Double.parseDouble(bmi3);
		
			String image = mr.getFilesystemName("photo");
			image = URLEncoder.encode(image, "utf-8");
			image = image.replace("+", " ");
			
			//BMIM에서 만든 값은 setAttribute
			request.setAttribute("name", name);
			request.setAttribute("height", height2);
			request.setAttribute("weight", weight2);
			request.setAttribute("bmi", bmi2);
			request.setAttribute("result", result);
			request.setAttribute("image", image);
			
//			Guest g = new Guest(name, height2, weight2, bmi2, result, image);
//			request.setAttribute("g", g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
