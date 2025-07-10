package com.techlabs.exceptions;

public class MinimumBalanceException extends RuntimeException {

	private double balance;

	public MinimumBalanceException(double balance) {
		super();
		this.balance = balance;
	}

	public String getMessage() {
		return "You have to keep minimum balance of at least 500, your current balance is: " + balance;
	}

}
