package com.techlabs.model;

public class Cash implements PaymentMethod {

	private double bill;

	public Cash(double bill) {
		super();
		this.bill = bill;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Paid " + bill +" using cash");
	}

}
