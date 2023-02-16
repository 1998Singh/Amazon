package com.evoke.amazon.entity;

public class EmailDetails {

	private String to;
	private String msgBody;
	private String subject;
	private String file;

	public EmailDetails() {

		super();
	}

	public EmailDetails(String to, String msgBody, String subject, String file) {
		super();
		this.to = to;
		this.msgBody = msgBody;
		this.subject = subject;
		this.file = file;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailDetails [to=" + to + ", msgBody=" + msgBody + ", subject=" + subject + "]";
	}

}
