package com.techlabs.model;

import java.util.Random;

public class MenuItem {
	private int id;
	private String name;
	private String description;
	private double price;
	
	Random random = new Random();

	public MenuItem(String name, String description, double price) {
		super();
		this.id = random.nextInt(90)+10;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public MenuItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
