package com.kwak.miniproject.member;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw, String name, String addr, String photo) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
}
