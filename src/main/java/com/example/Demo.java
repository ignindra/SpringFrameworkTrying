package com.example;

import org.springframework.stereotype.Component;

@Component
public class Demo {
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void printMessage() {
		System.out.println("Your message: "+message);
	}
}