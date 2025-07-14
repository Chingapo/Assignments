package com.techlabs.exception;

public class InvalidQuantityException extends Throwable{
	
	public String getMessage() {
		return "The Quantity you have entered is not valid";
	}

}
