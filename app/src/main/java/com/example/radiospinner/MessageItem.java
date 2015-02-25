package com.example.radiospinner;

public class MessageItem {

	String message;
	Boolean person;
	
	public MessageItem(String message, Boolean person) {
		super();
		this.message = message;
		this.person = person;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getPerson() {
		return person;
	}

	public void setPerson(Boolean person) {
		this.person = person;
	}
	
	
}
