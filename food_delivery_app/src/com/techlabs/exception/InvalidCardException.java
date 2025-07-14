package com.techlabs.exception;

public class InvalidCardException extends Throwable {
	public String getMessage() {
		return "The card details entered are invalid, kindly recheck and add card again";
	}
}
