package com.kwak.miniproject.board;

import java.math.BigDecimal;
import java.util.Date;

public class BoardReply {
	private BigDecimal sr_no;
	private BigDecimal sr_s_no;
	private String sr_writer;
	private String sr_text;
	private Date sr_when;
	
	public BoardReply() {
		// TODO Auto-generated constructor stub
	}

	public BoardReply(BigDecimal sr_no, BigDecimal sr_s_no, String sr_writer, String sr_text, Date sr_when) {
		super();
		this.sr_no = sr_no;
		this.sr_s_no = sr_s_no;
		this.sr_writer = sr_writer;
		this.sr_text = sr_text;
		this.sr_when = sr_when;
	}

	public BigDecimal getSr_no() {
		return sr_no;
	}

	public void setSr_no(BigDecimal sr_no) {
		this.sr_no = sr_no;
	}

	public BigDecimal getSr_s_no() {
		return sr_s_no;
	}

	public void setSr_s_no(BigDecimal sr_s_no) {
		this.sr_s_no = sr_s_no;
	}

	public String getSr_writer() {
		return sr_writer;
	}

	public void setSr_writer(String sr_writer) {
		this.sr_writer = sr_writer;
	}

	public String getSr_text() {
		return sr_text;
	}

	public void setSr_text(String sr_text) {
		this.sr_text = sr_text;
	}

	public Date getSr_when() {
		return sr_when;
	}

	public void setSr_when(Date sr_when) {
		this.sr_when = sr_when;
	}
	
	
}
