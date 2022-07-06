package com.oh.group;

import java.util.Date;

public class GroupMessage {
	private int message_no;
	private String message_writer;
	private String message_sender; 
	private String message_title;
	private String message_txt;
	private Date message_date;
	
	public GroupMessage() {
		// TODO Auto-generated constructor stub
	}

	public GroupMessage(int message_no, String message_writer, String message_sender, String message_title,
			String message_txt, Date message_date) {
		super();
		this.message_no = message_no;
		this.message_writer = message_writer;
		this.message_sender = message_sender;
		this.message_title = message_title;
		this.message_txt = message_txt;
		this.message_date = message_date;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getMessage_writer() {
		return message_writer;
	}

	public void setMessage_writer(String message_writer) {
		this.message_writer = message_writer;
	}

	public String getMessage_sender() {
		return message_sender;
	}

	public void setMessage_sender(String message_sender) {
		this.message_sender = message_sender;
	}

	public String getMessage_title() {
		return message_title;
	}

	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}

	public String getMessage_txt() {
		return message_txt;
	}

	public void setMessage_txt(String message_txt) {
		this.message_txt = message_txt;
	}

	public Date getMessage_date() {
		return message_date;
	}

	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}
	
	
}
