package com.spring.boot.data.jpa.demo.exception;

public class CategoryNotFoundException extends Exception {

	
	private static final long serialVersionUID = 3616352664653486145L;
	
	public CategoryNotFoundException(String Exception) {
		super(Exception);
	}

}
