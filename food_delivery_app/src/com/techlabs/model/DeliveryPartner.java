package com.techlabs.model;

import java.util.Random;

public class DeliveryPartner {
	private Cart cart;
	private int id;
	
	private static final int count=2;
	private static int assignedPartners = 0;
	Random random =new Random();

	public DeliveryPartner(Cart cart) {
		super();
		this.cart = cart;
		this.id = random.nextInt(4000)+1000;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void assignDeliveryPartner() {
		assignedPartners = 0;
		if(assignedPartners<count) {
			System.out.println("Delivery Partner with id "+ id +" is assigned for your cart id: "+cart.getId());
			assignedPartners++;
			try {
				Thread.sleep(80000);
				assignedPartners--;
			}catch(InterruptedException e) {
				e.getMessage();
			}
			return;
		}
		System.out.println("Both delivery partners are busy pls try again later");
		return;
	}

}
