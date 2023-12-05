package com.kwak1.dec052.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	//기상청 xml다운(파싱)받아서 -> String 한덩어리로 뭉쳐서 그대로 리턴
	//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000
	
	public void getKoreanWeather(HttpServletRequest req) {
		
	}
}
