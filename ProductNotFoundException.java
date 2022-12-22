package com.spring.boot.data.jpa.demo.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -4583980764832604979L;
	
	public ProductNotFoundException(String Exception) {
		super(Exception);
	}

}
