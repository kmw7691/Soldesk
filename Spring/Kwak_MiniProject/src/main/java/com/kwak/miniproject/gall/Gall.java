package com.kwak.miniproject.gall;

import java.math.BigDecimal;
import java.util.Date;

public class Gall {
	private BigDecimal g_no;
	private String g_photo;
	private Date g_when;
	
	public Gall() {
		// TODO Auto-generated constructor stub
	}

	public Gall(BigDecimal g_no, String g_photo, Date g_when) {
		super();
		this.g_no = g_no;
		this.g_photo = g_photo;
		this.g_when = g_when;
	}

	public BigDecimal getG_no() {
		return g_no;
	}

	public void setG_no(BigDecimal g_no) {
		this.g_no = g_no;
	}

	public String getG_photo() {
		return g_photo;
	}

	public void setG_photo(String g_photo) {
		this.g_photo = g_photo;
	}

	public Date getG_when() {
		return g_when;
	}

	public void setG_when(Date g_when) {
		this.g_when = g_when;
	}
	
	
}
