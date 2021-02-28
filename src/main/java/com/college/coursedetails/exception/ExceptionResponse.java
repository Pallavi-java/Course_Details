package com.college.coursedetails.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date date;
	private String message;
	private String Description;
	
	public ExceptionResponse(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		Description = description;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return Description;
	}
	
	

}
