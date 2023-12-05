package com.kwak1.dec052.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	//기상청 xml다운(파싱)받아서 -> String 한덩어리로 뭉쳐서 그대로 리턴
	//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000
	
	public String getKoreanWeather(HttpServletRequest req) {
		try {
			String url="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000";
			URL u = new URL(url);
			
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			//나오는 하나하나를 한 덩어리로 뭉치기
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line.replace("\r\n", ""));
				//받아온 데이터들을 엔터없애고 한덩어리로 뭉치는 작업
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
