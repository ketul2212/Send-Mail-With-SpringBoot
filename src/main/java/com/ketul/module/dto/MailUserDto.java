package com.ketul.module.dto;


public class MailUserDto {

	private String toMail;
	private String message;
	private String subject;
	
	public MailUserDto() {
		super();
	}

	public MailUserDto(String toMail, String message, String subject) {
		super();
		this.toMail = toMail;
		this.message = message;
		this.subject = subject;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MailUserDto [toMail=" + toMail + ", message=" + message + ", subject=" + subject + "]";
	}
}
