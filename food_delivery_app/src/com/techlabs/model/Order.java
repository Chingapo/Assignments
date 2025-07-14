package com.techlabs.model;


public class Order {
	MenuItem menuItem;
	int quantity;
	double lineTotal;

	public Order(MenuItem menuItem, int quantity) {
		super();
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.lineTotal = menuItem.getPrice()*quantity;
	}

	public Order() {
		super();
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

}
