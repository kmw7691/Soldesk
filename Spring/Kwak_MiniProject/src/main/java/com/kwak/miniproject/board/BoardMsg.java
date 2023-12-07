package com.kwak.miniproject.board;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BoardMsg {
	//member
	private String id;
	private String photo;
	
	//board
	private BigDecimal s_no;
	private String s_text;
	private Date s_when;
	
	private List<BoardReply> s_replys; //댓글들

	
	public BoardMsg() {
		// TODO Auto-generated constructor stub
	}


	public BoardMsg(String id, String photo, BigDecimal s_no, String s_text, Date s_when, List<BoardReply> s_replys) {
		super();
		this.id = id;
		this.photo = photo;
		this.s_no = s_no;
		this.s_text = s_text;
		this.s_when = s_when;
		this.s_replys = s_replys;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public BigDecimal getS_no() {
		return s_no;
	}


	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
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


	public List<BoardReply> getS_replys() {
		return s_replys;
	}


	public void setS_replys(List<BoardReply> s_replys) {
		this.s_replys = s_replys;
	}
	
	
}
