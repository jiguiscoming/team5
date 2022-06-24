package com.oh.group;

import java.util.Date;

public class Group {
	
	private int no;
	private String id;
	private String title;
	private String txt;
	private Date date;
	private String area;
	private int like;
	private int hits;
	private String nickname;
	private String img;
	
public Group() {
	// TODO Auto-generated constructor stub
}

public Group(int no, String id, String title, String txt, Date date, String area, int like, int hits, String nickname,
		String img) {
	super();
	this.no = no;
	this.id = id;
	this.title = title;
	this.txt = txt;
	this.date = date;
	this.area = area;
	this.like = like;
	this.hits = hits;
	this.nickname = nickname;
	this.img = img;
}

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
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

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}




	
	
}
