package com.techlabs.model;

import com.techlabs.exceptions.MinimumBalanceException;
import com.techlabs.exceptions.NegativeAmountException;

public class SavingsAccount extends Account{
	private double minBalance;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String accountNumber, String name, double balance, double minBalance) {
		super(accountNumber, name, balance);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public boolean withdraw(double amount) {
		if(amount<0) {
			throw new NegativeAmountException(amount);
		}
		if(this.getBalance() - amount < minBalance) {
			throw new MinimumBalanceException(super.getBalance());
		}
		this.setBalance(this.getBalance()-amount);
		System.out.println("Amount " + amount + "has been deducted from account "+ this.getAccountNumber());
		System.out.println("Your new balance is "+ this.getBalance());
		return false;
	}
	
	public boolean deposit(double amount) {
		if(amount<0) {
			throw new NegativeAmountException(amount);
		}
		this.setBalance(this.getBalance()+amount);
		System.out.println("You have deposited "+ amount + "in account "+this.getAccountNumber());
		System.out.println("your new balance is: " + this.getBalance());
		return false;
	}
}
