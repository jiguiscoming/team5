package com.oh.group;

import java.util.Date;

public class Group {
	
	private int no;
	private int posting;
	private String id;
	private String title;
	private String txt;
	private Date date;
	private String area;
	private int like;
	private int hits;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}


	public Group(int no, int posting, String id, String title, String txt, Date date, String area, int like, int hits) {
		super();
		this.no = no;
		this.posting = posting;
		this.id = id;
		this.title = title;
		this.txt = txt;
		this.date = date;
		this.area = area;
		this.like = like;
		this.hits = hits;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	public int getPosting() {
		return posting;
	}

	public void setPosting(int posting) {
		this.posting = posting;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}
