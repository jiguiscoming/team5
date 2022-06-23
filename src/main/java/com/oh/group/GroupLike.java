package com.oh.group;

public class GroupLike {
	private String id;
	private int posting_num;
	private int like;
	
	public GroupLike() {
		// TODO Auto-generated constructor stub
	}

	public GroupLike(String id, int posting_num, int like) {
		super();
		this.id = id;
		this.posting_num = posting_num;
		this.like = like;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPosting_num() {
		return posting_num;
	}

	public void setPosting_num(int posting_num) {
		this.posting_num = posting_num;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
	
}
