package com.sy.function;

import java.util.Date;

import oracle.sql.DATE;

public class MealkitReview {

	private int mealkit_review_no;
	private String mealkit_review_id;
	private String mealkit_review_title;
	private String mealkit_review_img;
	private String mealkit_review_txt;
	private int mealkit_review_star;
	private Date mealkit_review_date;
	
	
	public MealkitReview() {
		// TODO Auto-generated constructor stub
	}
	
	public MealkitReview(int mealkit_review_no, String mealkit_review_id, String mealkit_review_title,
			String mealkit_review_img, String mealkit_review_txt, int mealkit_review_star, Date mealkit_review_date) {
		super();
		this.mealkit_review_no = mealkit_review_no;
		this.mealkit_review_id = mealkit_review_id;
		this.mealkit_review_title = mealkit_review_title;
		this.mealkit_review_img = mealkit_review_img;
		this.mealkit_review_txt = mealkit_review_txt;
		this.mealkit_review_star = mealkit_review_star;
		this.mealkit_review_date = mealkit_review_date;
	}

	

	public int getMealkit_review_no() {
		return mealkit_review_no;
	}

	public void setMealkit_review_no(int mealkit_review_no) {
		this.mealkit_review_no = mealkit_review_no;
	}

	public String getMealkit_review_id() {
		return mealkit_review_id;
	}

	public void setMealkit_review_id(String mealkit_review_id) {
		this.mealkit_review_id = mealkit_review_id;
	}

	public String getMealkit_review_title() {
		return mealkit_review_title;
	}

	public void setMealkit_review_title(String mealkit_review_title) {
		this.mealkit_review_title = mealkit_review_title;
	}

	public String getMealkit_review_img() {
		return mealkit_review_img;
	}

	public void setMealkit_review_img(String mealkit_review_img) {
		this.mealkit_review_img = mealkit_review_img;
	}

	public String getMealkit_review_txt() {
		return mealkit_review_txt;
	}

	public void setMealkit_review_txt(String mealkit_review_txt) {
		this.mealkit_review_txt = mealkit_review_txt;
	}

	public int getMealkit_review_star() {
		return mealkit_review_star;
	}

	public void setMealkit_review_star(int mealkit_review_star) {
		this.mealkit_review_star = mealkit_review_star;
	}

	public Date getMealkit_review_date() {
		return mealkit_review_date;
	}

	public void setMealkit_review_date(Date mealkit_review_date) {
		this.mealkit_review_date = mealkit_review_date;
	}
	
	
	
	
	
	
	
}
