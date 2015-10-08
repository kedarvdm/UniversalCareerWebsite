package com.me.utils;

public class EmailDetails {
	private String from;
	private String toName;
	private String to;
	private String subject;
	private String body;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
