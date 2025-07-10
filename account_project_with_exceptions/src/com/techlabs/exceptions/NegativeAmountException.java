package com.techlabs.exceptions;

public class NegativeAmountException extends RuntimeException{
	
	private double amount;

	public NegativeAmountException(double amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage() {
		return "You have entered a negative amount: " + amount+" , please provide a positive amount";
	}
}
