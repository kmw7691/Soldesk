package com.chung.chungminip.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSMsg {
	// member
	private String c_id; // 글쓴이 id
	private String c_photo; // 글쓴이 프사

	// sns
	private BigDecimal c_no; // 글 번호
	private String c_txt; // 글 내용
	private Date c_when; // 날짜
	private String c_color; // 색깔

	private List<SNSReply> c_replys; // 댓글들

	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(String c_id, String c_photo, BigDecimal c_no, String c_txt, Date c_when, String c_color,
			List<SNSReply> c_replys) {
		super();
		this.c_id = c_id;
		this.c_photo = c_photo;
		this.c_no = c_no;
		this.c_txt = c_txt;
		this.c_when = c_when;
		this.c_color = c_color;
		this.c_replys = c_replys;
	}

	public String getc_id() {
		return c_id;
	}

	public void setc_id(String c_id) {
		this.c_id = c_id;
	}

	public String getc_photo() {
		return c_photo;
	}

	public void setc_photo(String c_photo) {
		this.c_photo = c_photo;
	}

	public BigDecimal getc_no() {
		return c_no;
	}

	public void setc_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getc_txt() {
		return c_txt;
	}

	public void setc_txt(String c_txt) {
		this.c_txt = c_txt;
	}

	public Date getc_when() {
		return c_when;
	}

	public void setc_when(Date c_when) {
		this.c_when = c_when;
	}

	public String getc_color() {
		return c_color;
	}

	public void setc_color(String c_color) {
		this.c_color = c_color;
	}

	public List<SNSReply> getc_replys() {
		return c_replys;
	}

	public void setc_replys(List<SNSReply> c_replys) {
		this.c_replys = c_replys;
	}

}
