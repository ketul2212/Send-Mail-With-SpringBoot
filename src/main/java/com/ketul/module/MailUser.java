package com.ketul.module;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class MailUser {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long id;
	
	@Field
	private String toMail;
	
	@Field
	private String message;
	
	@Field
	private String subject;

	public MailUser() {
		super();
	}

	public MailUser(String toMail, String message, String subject) {
		super();
		this.toMail = toMail;
		this.message = message;
		this.subject = subject;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "MailUser [id=" + id + ", toMail=" + toMail + ", message=" + message + ", subject=" + subject + "]";
	}
}
