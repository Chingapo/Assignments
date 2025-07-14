package com.techlabs.exception;

public class InvalidPhoneNumberException extends Throwable{
	
	public String getMessage() {
		return "Enter a valid number please.";
	}
}
