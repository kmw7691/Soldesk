package com.chung.chungminip.Member;

public class Member {
	private String c_id;
	private String c_pw;
	private String c_name;
	private String c_addr;
	private String c_photo;
	private String c_role;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String c_id, String c_pw, String c_name, String c_addr, String c_photo, String c_role) {
		super();
		this.c_id = c_id;
		this.c_pw = c_pw;
		this.c_name = c_name;
		this.c_addr = c_addr;
		this.c_photo = c_photo;
		this.c_role = c_role;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_pw() {
		return c_pw;
	}

	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_addr() {
		return c_addr;
	}

	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}

	public String getC_photo() {
		return c_photo;
	}

	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}

	public String getC_role() {
		return c_role;
	}

	public void setC_role(String c_role) {
		this.c_role = c_role;
	}
	
	
	
}
