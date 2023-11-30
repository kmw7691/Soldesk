package com.kwak.nov301.student;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SqlSessionTemplate
//		SqlSession의 하위클래스
//		(public class SqlsessionTemplete implements SqlSession)의 구조
//		->SqlSession의 기능은 다 들어 있고, 뭔가 더 추가댐
//		자동연결/자동해제
//		자동 commit

@Service
public class StudentDAO {
	@Autowired
	private SqlSession ss;
	
	public void regStudent(Student s, HttpServletRequest req) {
		try {
			
			//연결-자동(SqlsessionTemplate이 자동으로 해줌) : connect, close 필요X
			
			//값 받아오기, 객체로 만들기 - Spring이 자동으로 해결해줌
			System.out.println(s.getS_name());
			System.out.println(s.getS_nickname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
