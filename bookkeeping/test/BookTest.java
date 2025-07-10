package com.techlabs.bookkeeping.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.techlabs.bookkeeping.model.AuthorComparator;
import com.techlabs.bookkeeping.model.Book;

public class BookTest {

	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		
		while(choice!=8) {
			System.out.println("Menu: ");
			System.out.println("1. Add a new book");
			System.out.println("2. Issue a book");
			System.out.println("3. Display available books");
			System.out.println("4. Display issued books");
			System.out.println("5. Return a book");
			System.out.println("6. Sort books in ascending order of title");
			System.out.println("7. Sort books in descending order of author");
			System.out.println("8. Exit");
			
			choice = scanner.nextInt();
			scanner.nextLine();
			int id;
			switch(choice) {
			
			case 1:
				books.add(createBook(scanner));
				break;
			case 2:
				System.out.println("Enter ID of book you want to issue");
				id = scanner.nextInt();
				issueBook(id, books);
				break;
			case 3:
				System.out.println("Available books: ");
				displayAvailableBooks(books);
				break;
			case 4:
				System.out.println("Issued books: ");
				displayIssuedBooks(books);
				break;
			case 5:
				System.out.println("Enter ID of book you want to return");
				id = scanner.nextInt();
				returnBook(id, books);
				break;
			case 6:
				Collections.sort(books);
				System.out.println("Sorted according to Title name");
				for(Book book:books) {
					System.out.println(book.toString());
				}
				break;
			case 7:
				Collections.sort(books,new AuthorComparator());
				System.out.println("Sorted according to Author name");
				for(Book book:books) {
					System.out.println(book.toString());
				}
				break;
			case 8:
				return;
			}
		}
		scanner.close();

	}

	private static void returnBook(int id, List<Book> books) {
		for(Book book:books) {
			if(book.getId()==id && !book.isAvailable()) {
				book.setAvailable(true);
				System.out.println("You have returned book with title: "+book.getTitle()+" and id: "+ book.getId());
				return;
			}
		}
		System.out.println("Book not issued yet or does not exist");
		
	}

	private static void displayIssuedBooks(List<Book> books) {
		for(Book book:books) {
			if(!book.isAvailable()) {
				System.out.println(book.toString());
			}
		}
		
	}

	private static void displayAvailableBooks(List<Book> books) {
		for(Book book:books) {
			if(book.isAvailable()) {
				System.out.println(book.toString());
			}
		}
		
	}

	private static void issueBook(int id, List<Book> books) {
		for(Book book:books) {
			if(book.getId()==id && book.isAvailable()) {
				book.setAvailable(false);
				System.out.println("You have issued book with title: "+book.getTitle()+" and id: "+ book.getId());
				return;
			}
		}
		System.out.println("Book not found, either unavailable or never existed");
	}

	private static Book createBook(Scanner scanner) {
		
		System.out.println("Enter name of the book: ");
		String title = scanner.nextLine();
		
		System.out.println("Enter author of the book: ");
		String author = scanner.nextLine();
		
		Book book = new Book(title, author);
		System.out.println("Book created with id: "+ book.getId());
		
		return book;
		
	}

}
