package com.techlabs.model;

public class Invoice {
	Cart cart;

	public Invoice(Cart cart) {
		super();
		this.cart = cart;
	}

	public Invoice() {
		super();
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public double calculateTotalBill() {
		double bill=0;
		for(Order order: cart.getOrders()) {
			bill+=order.getLineTotal();
		}
		return bill;
	}
	
	public double getDiscount(){
		double bill=calculateTotalBill();
		if(bill>800) {
			return (10*calculateTotalBill())/100;
		}
		return 0;
	}
	
	public double generateBill(){
		double discount = getDiscount();
		double bill = calculateTotalBill();
		double finalBill = bill - discount;
		
		System.out.println("\n---------------------------- INVOICE ----------------------------");
	    System.out.printf("%-5s %-20s %10s %10s %10s%n", "ID", "Name", "Price", "Qty", "Total");
	    System.out.println("----------------------------------------------------------------");

	    for (Order order : cart.getOrders()) {
	        MenuItem item = order.getMenuItem();
	        int quantity = order.getQuantity();
	        double price = item.getPrice();
	        double total = order.getLineTotal();

	        System.out.printf("%-5d %-20s %10.2f %10d %10.2f%n",item.getId(), item.getName(), price, quantity, total);
	    }

	    System.out.println("----------------------------------------------------------------");
	    System.out.printf("%-47s: %10.2f%n", "Subtotal", bill);
	    System.out.printf("%-47s: %10.2f%n", "Discount", discount);
	    System.out.printf("%-47s: %10.2f%n", "Final Total", finalBill);
	    System.out.println("----------------------------------------------------------------\n");
	    
	    return finalBill;
	}
	
	double getFinalBillAmount() {
		double discount = getDiscount();
		double bill = calculateTotalBill();
		double finalBill = bill - discount;
		
		return finalBill;
	}
}
