package com.chung.chungminip.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal cr_no;
	private BigDecimal cr_c_no;
	private String cr_owner;
	private String cr_txt;
	private Date cr_when;

	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(BigDecimal cr_no, BigDecimal cr_c_no, String cr_owner, String cr_txt, Date cr_when) {
		super();
		this.cr_no = cr_no;
		this.cr_c_no = cr_c_no;
		this.cr_owner = cr_owner;
		this.cr_txt = cr_txt;
		this.cr_when = cr_when;
	}

	public BigDecimal getcr_no() {
		return cr_no;
	}

	public void setcr_no(BigDecimal cr_no) {
		this.cr_no = cr_no;
	}

	public BigDecimal getcr_c_no() {
		return cr_c_no;
	}

	public void setcr_c_no(BigDecimal cr_c_no) {
		this.cr_c_no = cr_c_no;
	}

	public String getcr_owner() {
		return cr_owner;
	}

	public void setcr_owner(String cr_owner) {
		this.cr_owner = cr_owner;
	}

	public String getcr_txt() {
		return cr_txt;
	}

	public void setcr_txt(String cr_txt) {
		this.cr_txt = cr_txt;
	}

	public Date getcr_when() {
		return cr_when;
	}

	public void setcr_when(Date cr_when) {
		this.cr_when = cr_when;
	}

}
