package com.sy.function;

import java.util.Date;

public class MealkitAnswer {
	
	private int	mealkit_Answer_no; 
	private int mealkit_Answer_QnA_no;
	private String mealkit_Answer_title;
	private String mealkit_Answer_txt;
    private Date mealkit_Answer_date;
    
    
    public MealkitAnswer() {
		// TODO Auto-generated constructor stub
	}
    
	public MealkitAnswer(int mealkit_Answer_no, int mealkit_Answer_QnA_no, String mealkit_Answer_title,
			String mealkit_Answer_txt, Date mealkit_Answer_date) {
		super();
		this.mealkit_Answer_no = mealkit_Answer_no;
		this.mealkit_Answer_QnA_no = mealkit_Answer_QnA_no;
		this.mealkit_Answer_title = mealkit_Answer_title;
		this.mealkit_Answer_txt = mealkit_Answer_txt;
		this.mealkit_Answer_date = mealkit_Answer_date;
	}
	public int getMealkit_Answer_no() {
		return mealkit_Answer_no;
	}
	public void setMealkit_Answer_no(int mealkit_Answer_no) {
		this.mealkit_Answer_no = mealkit_Answer_no;
	}
	public int getMealkit_Answer_QnA_no() {
		return mealkit_Answer_QnA_no;
	}
	public void setMealkit_Answer_QnA_no(int mealkit_Answer_QnA_no) {
		this.mealkit_Answer_QnA_no = mealkit_Answer_QnA_no;
	}
	public String getMealkit_Answer_title() {
		return mealkit_Answer_title;
	}
	public void setMealkit_Answer_title(String mealkit_Answer_title) {
		this.mealkit_Answer_title = mealkit_Answer_title;
	}
	public String getMealkit_Answer_txt() {
		return mealkit_Answer_txt;
	}
	public void setMealkit_Answer_txt(String mealkit_Answer_txt) {
		this.mealkit_Answer_txt = mealkit_Answer_txt;
	}
	public Date getMealkit_Answer_date() {
		return mealkit_Answer_date;
	}
	public void setMealkit_Answer_date(Date mealkit_Answer_date) {
		this.mealkit_Answer_date = mealkit_Answer_date;
	}
    
    
    
    
    
    

}
