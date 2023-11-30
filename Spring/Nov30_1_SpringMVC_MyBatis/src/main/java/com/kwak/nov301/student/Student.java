package com.kwak.nov301.student;

public class Student {
	private int s_no;
	private String s_name;
	private String s_nickname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int s_no, String s_name, String s_nickname) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_nickname = s_nickname;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_nickname() {
		return s_nickname;
	}

	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}
	
	
}
