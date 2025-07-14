package com.techlabs.model;

import java.time.LocalDate;
import java.util.Scanner;

import com.techlabs.exception.InvalidCardException;

public class CreditCard implements PaymentMethod {

	private double bill;
	private String cardNumber;
	private String cardHolder;
	private LocalDate expiry;
	private int cvv;
	

	public CreditCard(double bill) {
		super();
		this.bill = bill;
	}

	public void pay() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter card number");
		cardNumber = scanner.nextLine();
		
		System.out.println("Enter card holders name");
		cardHolder = scanner.nextLine();
		
		System.out.println("Enter expiry (format=(yyyy-mm-dd))");
		String dateString = scanner.nextLine();
		expiry = LocalDate.parse(dateString);
		
		System.out.println("Enter your CVV: ");
		cvv = scanner.nextInt();

		try {
			if (isValidCard()) {
				System.out.println("Paid " + bill +" using credit card number: "+ cardNumber);
				return;
			}
			throw new InvalidCardException();
		}catch(InvalidCardException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private boolean isValidCard() {
		if (cardNumber == null || cardNumber.isEmpty()) return false;
		LocalDate date = LocalDate.now();
		int sum=0;
		int temp=0;
		int size = cardNumber.length();
		for(int i=size-1; i>=0; i--) {
			if((size-i)%2==0) {
				temp=2*(cardNumber.charAt(i)-'0');
				if(temp>9) temp-=9;
				sum+=temp;
				continue;
			}
			sum+=(cardNumber.charAt(i)-'0');
		}
		if(sum%10==0 && expiry != null && expiry.isAfter(LocalDate.now())) return true;
		return false;
	}

}
