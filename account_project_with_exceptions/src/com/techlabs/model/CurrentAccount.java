package com.techlabs.model;

import com.techlabs.exceptions.NegativeAmountException;
import com.techlabs.exceptions.OverdraftLimitReachedException;

public class CurrentAccount extends Account {

	private double overDraftLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accountNumber, String name, double balance, double overDraftLimit) {
		super(accountNumber, name, balance);
		this.overDraftLimit = overDraftLimit;
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
	public boolean withdraw(double amount) {
		if(amount<0) {
			throw new NegativeAmountException(amount);
		}
		if(this.getBalance() - amount < -overDraftLimit) {
			throw new OverdraftLimitReachedException(overDraftLimit);
		}
		if(this.getBalance() - amount < 0) {
			double extraMoney = -(this.getBalance() - amount);
			overDraftLimit-=extraMoney;
			this.setBalance(0);
			System.out.println("You have withdrawn " + amount + "out of which "+ extraMoney + "Was from your overdraft balance");
			System.out.println("Your bank balance is: "+this.getBalance());
			System.out.println("Your overdraft balance is: " + overDraftLimit);
			return false;
		}
		this.setBalance(this.getBalance()-amount);
		System.out.println("Amount " + amount + "has been deducted from account "+ this.getAccountNumber());
		System.out.println("Your bank balance is: "+ this.getBalance());
		System.out.println("Your overdraft balance is: " + overDraftLimit);
		return false;
	}
	
	public boolean deposit(double amount) {
		if(amount<0) {
			throw new NegativeAmountException(amount);
		}
		double debt = 50000-overDraftLimit;
		if(amount<debt) {
			overDraftLimit+=amount;
			System.out.println("Successfully deposited "+amount+" in bank account " + this.getAccountNumber());
			System.out.println("Your current bank baalance stands at: "+this.getBalance());
			System.out.println("The funds were only used to recover your overdraft limit. Limit currently stands at: "+ overDraftLimit);
			
			return false;
		}
		if(overDraftLimit < 50000 && amount>=debt) {
			amount-=debt;
			overDraftLimit=50000;
			System.out.println("Your overdraft limit has been restored");
		}
		this.setBalance(this.getBalance()+amount);
		System.out.println("Successfully deposited "+amount+" in bank account " + this.getAccountNumber());
		System.out.println("Your current bank balance is "+ this.getBalance());
		System.out.println("Your overdraft limit is : " + overDraftLimit);
		return false;
	}


}
