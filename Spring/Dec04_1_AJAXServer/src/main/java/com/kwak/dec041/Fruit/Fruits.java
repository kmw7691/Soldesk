package com.kwak.dec041.Fruit;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//db테이블 자체를 표현하는 자바빈
@XmlRootElement
public class Fruits {
	private List<Fruit> fruit; //단수로
	
	public Fruits() {
		// TODO Auto-generated constructor stub
	}

	public Fruits(List<Fruit> fruit) {
		super();
		this.fruit = fruit;
	}

	public List<Fruit> getFruit() {
		return fruit;
	}

	@XmlElement
	public void setFruit(List<Fruit> fruit) {
		this.fruit = fruit;
	}
	
}
