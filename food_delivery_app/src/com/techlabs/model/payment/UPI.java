package com.techlabs.model.payment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.techlabs.exception.InvalidUpiIdException;

public class UPI implements IPaymentMethod {
	private double bill;
	private String upiId;

	public UPI(double bill) {
		super();
		this.bill = bill;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your upi ID: ");
		upiId = scanner.nextLine();

		try {
			if (isValidId(upiId)) {
				System.out.println("Paid " + bill + " using UPI ID: " + upiId);
				return;
			}
			throw new InvalidUpiIdException();
		}catch(InvalidUpiIdException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private boolean isValidId(String upiId) {
		String regex = "^[a-zA-Z0-9.\\\\-_]{2,256}@[a-zA-Z]{2,64}$";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(upiId);

		return matcher.matches();
	}

}
