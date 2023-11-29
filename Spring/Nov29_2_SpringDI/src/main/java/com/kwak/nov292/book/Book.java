package com.kwak.nov292.book;

public class Book {
	private String name;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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


	
}
