package com.techlabs.exception;

public class InvalidUpiIdException extends Throwable{
	public String getMessage() {
		return "The UPI ID entered is invalid, pls check and try again.";
	}
}
