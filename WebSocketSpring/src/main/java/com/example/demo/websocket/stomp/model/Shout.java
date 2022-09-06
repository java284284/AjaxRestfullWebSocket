package com.example.demo.websocket.stomp.model;

public class Shout {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Shout(String message) {
		super();
		this.message = message;
	}

	public Shout() {
		super();
	}
	
	
}
