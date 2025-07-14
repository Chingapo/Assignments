package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.techlabs.exception.InvalidQuantityException;

public class Cart {

	Random random = new Random();

	private int id;
	List<Order> orders = new ArrayList<>();
	Customer customer;

	public Cart(Customer customer) {
		super();
		this.id = random.nextInt(900) + 100;
		this.customer = customer;
	}

	public Cart(List<Order> orders) {
		super();
		this.orders = orders;
		this.id = random.nextInt(900) + 100;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addItem(Order order) {
		orders.add(order);
		System.out.println("Order added successfully in cart.");
	}

	public void removeItem(int id) {
		for (Order order : orders) {
			MenuItem item = order.getMenuItem();
			if (item.getId() == id) {
				orders.remove(order);
				System.out.println("Order removed successfully");
				return;
			}
		}
	}

	public void modifyItem(int id) {
		MenuItem item;
		Scanner scanner = new Scanner(System.in);
		for (Order order : orders) {
			item = order.getMenuItem();
			if (item.getId() == id) {

				try {
					System.out.println("Enter new Quantity you want of " + item.getName());
					int quantity = scanner.nextInt();
					scanner.nextLine();
					if (quantity <= 0)
						throw new InvalidQuantityException();
					order.setQuantity(quantity);
					order.setLineTotal(quantity * item.getPrice());
					System.out.println("Item modified successfully");
				} catch (InvalidQuantityException e) {
					System.out.println(e.getMessage());
				}

			}
		}
		scanner.close();
	}

	public void displayCart() {
		System.out.println("CART of "+ customer.getName() +" (ID: "+customer.getId());
		System.out.println(
				"=========================================================================================================================");
		System.out.println("Your current cart (ID: " + id + ") contains:");
		System.out.println("---------------------------------CART---------------------------------");
		System.out.printf("%-6s |%-16s |%-6s |%-6s |%-10s", "ID", "Name", "Price", "Quantity", "Total Price");
		for (Order order : orders) {
			MenuItem item = order.getMenuItem();
			System.out.println();
			System.out.printf("%-6s |%-16s |%-6s |%-6s |%-10s", item.getId(), item.getName(), item.getPrice(),
					order.getQuantity(), order.getLineTotal());
			System.out.println();
		}

		System.out.println(
				"=========================================================================================================================");
	}
}
