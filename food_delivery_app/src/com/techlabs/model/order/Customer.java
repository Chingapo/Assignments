package com.techlabs.model.order;

import java.util.Random;

import com.techlabs.exception.InvalidEmailException;
import com.techlabs.exception.InvalidPhoneNumberException;

public class Customer {

	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	
	Random random = new Random();

	public Customer(String name, String phoneNumber, String email) {
		super();
		this.id = random.nextInt(9)+1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	

	public Customer() {
		super();
		this.id = random.nextInt(9)+1;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if(phoneNumber.length()==10) {
			this.phoneNumber = phoneNumber;
			return;
		}
		throw new InvalidPhoneNumberException();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidEmailException {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if(email.matches(emailRegex)) {
			this.email = email;
			return;
		}
		throw new InvalidEmailException();
		
	}

}
