package com.learnSpringBoot.rest.webservices.restfulwebservices.helloWorld;

public class beanClass {

	private String message;

	beanClass(String message) {
		this.message=message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}

