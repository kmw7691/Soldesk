package com.kwak.dec041.Fruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitDAO {
	@Autowired
	private SqlSession ss;
	
	public void getAllFruit(HttpServletRequest req) {
		try {
			req.setAttribute("fruits", ss.getMapper(FruitMapper.class).getAllFruit());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Spring에서 XML 끌어오는 시스템 : XML AJAX Server
	//	현재 ) DB에 있는 과일데이터 하나를 표현하는 JavaBean(Friut.java)를 가지고 잇음
	//	우리가 필요한거 ) 
	//		1. db에 있는 [과일 테이블] 자체를 표현할 또하나의 자바빈이 필요
	//		2.Spring이 XML로 바뀔수 있도록
	//			각각의 자바빈의 클래스명 위에 @XmlRootElement라는 annotation달아주기
	//		3.Setter위에 @XmlElement라는 annotation 달기

	//특정 데이터 -> XML 형태로 바꾸는것 : Mashalling(마샬링)	
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
		
		Fruits fruitss = new Fruits(fruits);
		
		return fruitss;
	}
	
	public Fruits searchXML(Fruit f, HttpServletRequest req) {
//		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
//		
//		Fruits fruitss = new Fruits(fruits);
//		
//		return fruitss;
		
		return new Fruits(ss.getMapper(FruitMapper.class).searchFruit(f));
	}
}























