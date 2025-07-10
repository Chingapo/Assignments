package com.techlabs.test;

import java.util.Random;

import java.util.Scanner;

import com.techlabs.exceptions.MinimumBalanceException;
import com.techlabs.exceptions.NegativeAmountException;
import com.techlabs.exceptions.OverdraftLimitReachedException;
import com.techlabs.model.CurrentAccount;
import com.techlabs.model.SavingsAccount;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Welcome to IDBI bank");
		System.out.println("Onboarding facilities require you to create 2 new accounts: ");
		System.out.println("Please provide us with necessary details: ");
		
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		
		
		SavingsAccount savingsAccount = createSavingsAccount(name, scanner, random);
		CurrentAccount currentAccount = createCurrentAccount(name, scanner, random);
		
		int choice=-1;
		while(choice!=7) {
			System.out.println("Menu:");
			
			System.out.println("1. View Balance of Savings Account");
			System.out.println("2. View Balance of Current Account");
			System.out.println("3. Withdraw from Savings Account");
			System.out.println("4. Withdraw from Current Account");
			System.out.println("5. Deposit in Savings Account");
			System.out.println("6. Deposit in Current Account");
			System.out.println("7. Exit");

			System.out.println();
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			scanner.nextLine();
			try {
			switch (choice) {
			case 1:
				System.out.println("Balance of savings account: " + savingsAccount.getBalance());
				break;
			case 2:
				System.out.println("Balance of current account: " + currentAccount.getBalance());
				break;
			case 3:
				System.out.println("How much do u wish to withdraw from savings account ?? ");
				double withdrawFromSavings = scanner.nextDouble();
				try {
					savingsAccount.withdraw(withdrawFromSavings);						
				}catch(MinimumBalanceException e1) {
					System.out.println(e1.getMessage());
				}				
				break;
			case 4:
				System.out.println("How much do u wish to withdraw from current account ?? ");
				double withdrawFromCurrent = scanner.nextDouble();
				try{
					currentAccount.withdraw(withdrawFromCurrent);
				}catch(OverdraftLimitReachedException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 5:
				System.out.println("How much do u wish to deposit in savings account ?? ");
				double depositInSavings = scanner.nextDouble();
				savingsAccount.deposit(depositInSavings);
				break;
			case 6:
				System.out.println("How much do u wish to deposit in current account ?? ");
				double depositInCurrent = scanner.nextDouble();
				currentAccount.deposit(depositInCurrent);
				break;
			case 7:
				return;
			}
			}catch(NegativeAmountException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	
	private static CurrentAccount createCurrentAccount(String name, Scanner scanner, Random random) {
		System.out.println("Details for Current Account: ");

		String accountNumber = "IDBIC1000"+(random.nextInt(900000)+100000);
		
		
		
		
		System.out.println("Please enter the balance you wish to deposit for the intialization, (cannot be lesser than 500)");
		double balance = scanner.nextDouble();
		
		
		CurrentAccount currentAccount = new CurrentAccount(accountNumber, name, balance, (double) 50000);
		
		System.out.println("Your current account has been created !!");
		System.out.println("Your bank account number is: " + currentAccount.getAccountNumber());
		System.out.println("And your current balance is: "+ currentAccount.getBalance());
		System.out.println("--------------------------------------");
		
		return currentAccount;
		
		
	}

	private static SavingsAccount createSavingsAccount(String name, Scanner scanner, Random random) {
		
		System.out.println("Details for Savings Account: ");
		
		String accountNumber = "IDBIS1000"+(random.nextInt(900000)+100000);
		
		System.out.println(
				"Please enter the balance you wish to deposit for the intialization, (cannot be lesser than 500)");
		double balance = scanner.nextDouble();
		while (balance < 500) {
			System.out.println("Please deposit a minimum of 500 for initialization.");
			balance = scanner.nextDouble();
		}
		
		SavingsAccount savingsAccount = new SavingsAccount(accountNumber, name, balance, 500);
		
		System.out.println("Your savings accpount has been created !!");
		System.out.println("Your bank account number is: " + savingsAccount.getAccountNumber());
		System.out.println("And your current balance is: "+ savingsAccount.getBalance());
		System.out.println("--------------------------------------");
		
		return savingsAccount;
	}


}
