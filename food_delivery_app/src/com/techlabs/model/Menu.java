package com.techlabs.model;

import java.util.List;

public class Menu {

	List<MenuItem> menuItems;

	public Menu(List<MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	public Menu() {
		super();
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------MENU-------------------------------");
		System.out.printf("%-6s |%-16s | %-64s | %6s%n", "ID", "Name", "Description", "Price");
		for (MenuItem item : menuItems) {
			System.out.printf("%-6s |%-16s | %-64s | Rs.%5.2f%n", item.getId(), item.getName(), item.getDescription(), item.getPrice());
		}

	}
}
