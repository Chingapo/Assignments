package com.techlabs.model.admin;

import java.util.Random;

import com.techlabs.model.order.Cart;
import com.techlabs.exception.NoDeliveryPartnersAvailableException;


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
	
	public void assignDeliveryPartner() throws NoDeliveryPartnersAvailableException {
		assignedPartners = 0;
		if(assignedPartners<count) {
			int currentPartnerId = id;
	        int currentCartId = cart.getId();

	        // background thread mxde using new keyword, later put to sleep since delivery is in progress
	        new Thread(() -> {
	            System.out.println("Delivery Partner with id " + currentPartnerId + 
	                               " is delivering the cart with id: " + currentCartId);
	            assignedPartners++;
	            try {
	                Thread.sleep(80000);//80 seconds
	                System.out.println("Order delivered by partner id " + currentPartnerId);
	            } catch (InterruptedException e) {
	                System.err.println("Delivery interrupted: " + e.getMessage());
	            } finally {
	                assignedPartners--;
	            }
	        }).start();
	        return;
		}
		throw new NoDeliveryPartnersAvailableException();
	}

}
