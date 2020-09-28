package com.moviesurl.springboot.controller;

public class MovieListException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8551235160822631154L;
	private String exceptionMsg;

	public MovieListException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
