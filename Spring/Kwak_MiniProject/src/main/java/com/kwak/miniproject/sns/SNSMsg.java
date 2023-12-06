package com.kwak.miniproject.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSMsg {
	private BigDecimal s_no;
	private String s_writer;
	private String s_text;
	private Date s_when;
	
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(BigDecimal s_no, String s_writer, String s_text, Date s_when) {
		super();
		this.s_no = s_no;
		this.s_writer = s_writer;
		this.s_text = s_text;
		this.s_when = s_when;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_writer() {
		return s_writer;
	}

	public void setS_writer(String s_writer) {
		this.s_writer = s_writer;
	}

	public String getS_text() {
		return s_text;
	}

	public void setS_text(String s_text) {
		this.s_text = s_text;
	}

	public Date getS_when() {
		return s_when;
	}

	public void setS_when(Date s_when) {
		this.s_when = s_when;
	}
	
	
}
