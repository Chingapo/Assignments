package com.techlabs.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.techlabs.exception.EmptyCartException;
import com.techlabs.exception.InvalidEmailException;
import com.techlabs.exception.InvalidPhoneNumberException;
import com.techlabs.exception.ItemNotFoundException;
import com.techlabs.model.Admin;
import com.techlabs.model.Cart;
import com.techlabs.model.Cash;
import com.techlabs.model.CreditCard;
import com.techlabs.model.Customer;
import com.techlabs.model.DeliveryPartner;
import com.techlabs.model.Invoice;
import com.techlabs.model.Menu;
import com.techlabs.model.MenuItem;
import com.techlabs.model.MenuManager;
import com.techlabs.model.Order;
import com.techlabs.model.PaymentMethod;
import com.techlabs.model.UPI;

public class DriverCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		Admin admin = new Admin();
		Scanner scanner = new Scanner(System.in);

		// add items in menu (seeded data if required)
		List<MenuItem> list = new ArrayList<>();
		list.add(new MenuItem("shawarma", "paneer and pita bread with garlic sauce", 250));
		list.add(new MenuItem("burger", "grilled beef patty with lettuce and cheese", 199));
		list.add(new MenuItem("veg wrap", "spiced vegetables wrapped in flatbread", 149));
		list.add(new MenuItem("chicken tikka", "roasted chicken chunks with spices", 299));
		list.add(new MenuItem("falafel", "crispy chickpea balls served with tahini", 179));
		list.add(new MenuItem("noodles", "stir-fried noodles with vegetables", 159));
		list.add(new MenuItem("pasta", "creamy Alfredo pasta with herbs", 189));
		list.add(new MenuItem("cold coffee", "iced coffee with cream and sugar", 99));
		list.add(new MenuItem("lemonade", "fresh lemon juice with mint and ice", 89));
		list.add(new MenuItem("samosa", "crispy pastry stuffed with spiced potatoes", 49));
		list.add(new MenuItem("biryani", "fragrant basmati rice with chicken and spices", 249));
		menu.setMenuItems(list);
		

		
		boolean running=true;
		
		while(running) {
			
			
			System.out.println("Who are you ?");
			System.out.println("1. Customer");
			System.out.println("2. Admin");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				userInterface(menu, admin, scanner);
				break;
			case 2:
				adminInterface(admin, scanner);
				break;
			case 3:
				System.out.println("App is exiting..");
				running=false;
				break;
			}
			
			
		}
		scanner.close();

		
	}

	private static void adminInterface(Admin admin, Scanner scanner) {
		// TODO Auto-generated method stub
		MenuManager manager = new MenuManager();

		int choice = 0;
		while (choice != 9) {

			System.out.println("What do u want to do today ?");
			System.out.println("1. Add a new item in menu");
			System.out.println("2. Remove an item from a menu");
			System.out.println("3. Assign delivery partners");
			System.out.println("4. Print existing carts");
			System.out.println("9. Exit");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				manager.addItem();
				break;
			case 2:
				manager.removeItem();
				break;
			case 3:
				try {
					admin.printExistingOrders();
				} catch (EmptyCartException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
					break;
				}
				
				System.out.println("For which order do u want to assign a delivery partner ? ");
				int id = scanner.nextInt();
				scanner.nextLine();
				
				List<Cart> carts = admin.getCarts();
				Iterator<Cart> iterator = carts.iterator();
				
				boolean found = false;
				
				while(iterator.hasNext()) {
					Cart cart = iterator.next();
					if(cart.getId()==id) {
						iterator.remove();
						//add delivery partner id if you want
						DeliveryPartner deliveryPartner = new DeliveryPartner(cart);
						deliveryPartner.assignDeliveryPartner();
						
						found=true;
						break;
					}
				}
				
				if (!found) {
				    System.out.println("Sorry, no such cart ID exists. Please try again.");
				}
				
				admin.setCarts(carts);
				break;
			case 4:
				try {
					admin.printExistingOrders();
				} catch (EmptyCartException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
				
			case 9:
				break;
			}
		}
	}

	private static void userInterface(Menu menu, Admin admin, Scanner scanner) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome Customer");
		Customer customer = new Customer();
		
		System.out.println("Please enter your name: ");
		customer.setName(scanner.nextLine());
		
		System.out.println("Please enter your email id: ");
		try {
			customer.setEmail(scanner.nextLine());
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return;
		}
		
		System.out.println("Please enter your phone number: ");
		try {
			customer.setPhoneNumber(scanner.nextLine());
		} catch (InvalidPhoneNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return;
		}
		
		

		Cart cart = new Cart(customer);

		int choice = 0;
		while (choice != 99) {

			menu.printMenu();

			System.out.println("Enter id of item you want to place order of: (Enter 9 to exit and 1 to go to billing)");

			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 9) {
				return;
			}
			try {
				if(choice == 1) {
					if(cart.getOrders().isEmpty()) throw new EmptyCartException();
					break;
				}
			}catch(EmptyCartException e) {
				System.out.println(e.getMessage());
				continue;
			}
			
			
			MenuItem item = getItem(choice, menu);
			System.out.println("Enter quantity");
			int quantity = scanner.nextInt();
			scanner.nextLine();

			cart.addItem(new Order(item, quantity));

			cart.displayCart();

		}

		while (choice != 1) {
			System.out.println("YOUR FINAL CART IS: ");
			Thread.sleep(4000);
			cart.displayCart();

			System.out.println("Do you want to: ");
			System.out.println("1. Proceed to payment");
			System.out.println("2. edit the cart");
			System.out.println("3. remove items from cart");

			choice = scanner.nextInt();
			scanner.nextLine();

			int id = 0;
			switch (choice) {
			case 1:
				break;
			case 2:
				cart.displayCart();
				System.out.println("Enter ID of the item you wish to modify");
				id = scanner.nextInt();
				scanner.nextLine();
				cart.modifyItem(id);
				break;
			case 3:
				cart.displayCart();
				System.out.println("Enter ID of the item you wish to modify");
				id = scanner.nextInt();
				scanner.nextLine();
				cart.removeItem(id);
				break;
			}
		}
		
		List<Cart> readyForDelivery = admin.getCarts();
		readyForDelivery.add(cart);
		admin.setCarts(readyForDelivery);
		try {
			admin.printExistingOrders();
		} catch (EmptyCartException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		System.out.println("The admin will assign a delivery partner as soon as he is online");
		System.out.println("Thanks for your patience.");
		
		
		
		Invoice invoice = new Invoice(cart);
		double bill = invoice.generateBill();
		
		System.out.println("Following payment options are available: ");
		System.out.println("1. Cash");
		System.out.println("2. Credit Card");
		System.out.println("3. UPI");
		
		choice = scanner.nextInt();
		scanner.nextLine();
		
		PaymentMethod method = null;
		
		switch(choice) {
		case 1:
			method = new Cash(bill);
			break;
		case 2:
			method = new CreditCard(bill);
			break;
		case 3:
			method = new UPI(bill);
			break;
		}
		method.pay();
		
		System.out.println("Keep ordering with us....");
		
		System.out.println("Do you want to place another order ? (type y/n)");
		String restart = scanner.nextLine();
		
		if(restart.equals("y")) userInterface(menu, admin, scanner);
		

	}

	private static MenuItem getItem(int choice, Menu menu) {
		// TODO Auto-generated method stub
		try {
			for (MenuItem item : menu.getMenuItems()) {
				if (item.getId() == choice) {
					return item;
				}
			}
			throw new ItemNotFoundException();
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
