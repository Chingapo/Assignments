package com.techlabs.exceptions;

public class OverdraftLimitReachedException extends RuntimeException{
	
	private double limit;

	public OverdraftLimitReachedException(double limit) {
		super();
		this.limit = limit;
	}
	
	public String getMessage() {
		return "You have reached the limit of your overdraft limit, you want to withdraw more than your current limit which is: "+limit;
	}
}
