package com.techlabs.exception;

public class EmptyCartException extends Throwable{
	
	public String getMessage() {
		return "Your cart is empty, Kindly have items in cart to proceed.";
	}
}
