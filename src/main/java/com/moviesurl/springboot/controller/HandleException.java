package com.moviesurl.springboot.controller;

public class HandleException extends Exception{

	private static final long serialVersionUID = -470180507998010368L;
	
	public HandleException() {
		super();
	}
	
	public HandleException(final String message) {
		super(message);
	}
}