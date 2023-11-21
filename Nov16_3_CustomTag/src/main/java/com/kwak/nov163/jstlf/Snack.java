package com.kwak.nov163.jstlf;

import java.util.Date;

public class Snack {
	private String name;
	private int price;
	private Date exp;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String name, int price, Date exp) {
		super();
		this.name = name;
		this.price = price;
		this.exp = exp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}
	
	
	
}
