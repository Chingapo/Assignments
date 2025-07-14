package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager {

	List<MenuItem> items = new ArrayList<>();

	Menu menu = new Menu(items);

	public void addItem() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name of item: ");
		String name = scanner.nextLine();

		System.out.println("Enter description of item: ");
		String description = scanner.nextLine();

		System.out.println("Enter price of item: ");
		double price = scanner.nextDouble();

		items.add(new MenuItem(name, description, price));

		System.out.println("Item added successfully");
		scanner.close();

	}

	public void removeItem() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name of item to be removed: ");
		String itemName = scanner.nextLine();
		scanner.close();

		for (MenuItem item : items) {
			if (item.getName().equals(itemName)) {
				items.remove(item);
				System.out.println("item removed successfully");
				return;
			}
		}
		System.out.println("Could not find item");

		return;
	}

	public void modifyItem() {

	}

}
