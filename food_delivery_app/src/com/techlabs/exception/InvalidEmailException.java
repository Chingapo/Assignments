package com.techlabs.exception;

public class InvalidEmailException extends Throwable{
	public String getMessage() {
		return "Please enter valid email id.";
	}
}
