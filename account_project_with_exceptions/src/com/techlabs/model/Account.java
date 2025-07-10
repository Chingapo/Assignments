package com.techlabs.model;

public abstract class Account {
	private String accountNumber;
	private String name;
	private double balance;

	public Account() {
		super();
	}

	public Account(String accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract boolean deposit(double amount);
	public abstract boolean withdraw(double amount);
	
	
}
