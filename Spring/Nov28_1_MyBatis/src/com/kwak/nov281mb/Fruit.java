package com.kwak.nov281mb;

import java.math.BigDecimal;

//Framework : 시키는대로 하면 자동으로 처리해줌

//MyBatis ORM Framework 발동조건(자동처리조건)
//		-자바빈 멤버변수명 = DB필드명
//		-oracle한정 - number타입 : 정수/실수 공용
//		-java) 정수 /실수 공용자료형 : BigDecimal

//JavaBean, DTO, POJO
public class Fruit {
	private String f_name;
	private BigDecimal f_price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String f_name, BigDecimal f_price) {
		super();
		this.f_name = f_name;
		this.f_price = f_price;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public BigDecimal getF_price() {
		return f_price;
	}

	public void setF_price(BigDecimal f_price) {
		this.f_price = f_price;
	}
	
	
}
