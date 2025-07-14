package com.techlabs.exception;

public class NoDeliveryPartnersAvailableException extends Throwable{
	public String getMessage() {
		return "No more delivery partners left, please wait for partners to deliver orders.";
	}
}
