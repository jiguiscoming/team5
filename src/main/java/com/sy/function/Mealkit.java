package com.sy.function;

import java.util.Date;

import oracle.sql.DATE;

public class Mealkit {

	private int mealkit_no;
	private String mealkit_name;
	private int mealkit_price;
	private String mealkit_type;
	private String mealkit_img;
	private String mealkit_txt;
	private Date mealkit_date;
	
	public Mealkit() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Mealkit(int mealkit_no, String mealkit_name, int mealkit_price, String mealkit_type, String mealkit_img,
			String mealkit_txt, Date mealkit_date) {
		super();
		this.mealkit_no = mealkit_no;
		this.mealkit_name = mealkit_name;
		this.mealkit_price = mealkit_price;
		this.mealkit_type = mealkit_type;
		this.mealkit_img = mealkit_img;
		this.mealkit_txt = mealkit_txt;
		this.mealkit_date = mealkit_date;
	}
	public int getMealkit_no() {
		return mealkit_no;
	}
	public void setMealkit_no(int mealkit_no) {
		this.mealkit_no = mealkit_no;
	}
	public String getMealkit_name() {
		return mealkit_name;
	}
	public void setMealkit_name(String mealkit_name) {
		this.mealkit_name = mealkit_name;
	}
	public int getMealkit_price() {
		return mealkit_price;
	}
	public void setMealkit_price(int mealkit_price) {
		this.mealkit_price = mealkit_price;
	}
	public String getMealkit_type() {
		return mealkit_type;
	}
	public void setMealkit_type(String mealkit_type) {
		this.mealkit_type = mealkit_type;
	}
	public String getMealkit_img() {
		return mealkit_img;
	}
	public void setMealkit_img(String mealkit_img) {
		this.mealkit_img = mealkit_img;
	}
	public String getMealkit_txt() {
		return mealkit_txt;
	}
	public void setMealkit_txt(String mealkit_txt) {
		this.mealkit_txt = mealkit_txt;
	}
	public Date getMealkit_date() {
		return mealkit_date;
	}
	public void setMealkit_date(Date mealkit_date) {
		this.mealkit_date = mealkit_date;
	}
	
	

}
