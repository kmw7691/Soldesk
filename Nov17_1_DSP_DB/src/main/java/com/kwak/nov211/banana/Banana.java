package com.kwak.nov211.banana;

public class Banana {
	private String maker;
	private String location;
	private int howmany;
	private String flavor;
	private String color;
	private int price;
	private String introduce;
	
	public Banana() {
		// TODO Auto-generated constructor stub
	}

	public Banana(String maker, String location, int howmany, String flavor, String color, int price,
			String introduce) {
		super();
		this.maker = maker;
		this.location = location;
		this.howmany = howmany;
		this.flavor = flavor;
		this.color = color;
		this.price = price;
		this.introduce = introduce;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getHowmany() {
		return howmany;
	}

	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
