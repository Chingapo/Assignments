package com.techlabs.model.payment;

public class Cash implements IPaymentMethod {

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
