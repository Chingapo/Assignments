package com.techlabs.exception;

public class ItemNotFoundException extends Throwable {
	public String getMessage() {
		return "The ID you have entered is invalid, No Such Item Exists.";
	}
}
