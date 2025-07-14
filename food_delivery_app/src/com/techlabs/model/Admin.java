package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.exception.EmptyCartException;

public class Admin {
	List<Cart> carts = new ArrayList<>();;

	public Admin(List<Cart> carts) {
		super();
		this.carts = carts;
	}

	public Admin() {
		super();
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	public void printExistingOrders() throws EmptyCartException {
		if(carts.isEmpty()) throw new EmptyCartException();
		
		System.out.println("Following orders are to be assigned: ");
		
		
		for(Cart cart:carts) {
			System.out.println("\nCart ID: " + cart.getId());
	        System.out.println("---------------------------------------------------------------");
	        System.out.printf("%-6s | %-16s | %-7s | %-8s | %-11s%n", "Item ID", "Name", "Price", "Quantity", "Total Price");
	        System.out.println("---------------------------------------------------------------");
	        Invoice invoice = new Invoice(cart);
	        
	        for (Order order : cart.getOrders()) {
	            MenuItem item = order.getMenuItem();
	            
	            System.out.printf("%-6d | %-16s | %-7.2f | %-8d | %-11.2f%n",
	                    item.getId(),
	                    item.getName(),
	                    item.getPrice(),
	                    order.getQuantity(),
	                    invoice.getFinalBillAmount());
	        }

	        System.out.println("---------------------------------------------------------------");
		}
	}
}
