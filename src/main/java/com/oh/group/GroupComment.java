package com.oh.group;

import java.util.Date;

public class GroupComment {
	private int comment_no;
	private int list_no;
	private String id;
	private String txt;
	private Date date;
	
	public GroupComment() {
		// TODO Auto-generated constructor stub
	}

	public GroupComment(int comment_no, int list_no, String id, String txt, Date date) {
		super();
		this.comment_no = comment_no;
		this.list_no = list_no;
		this.id = id;
		this.txt = txt;
		this.date = date;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getList_no() {
		return list_no;
	}

	public void setList_no(int list_no) {
		this.list_no = list_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
