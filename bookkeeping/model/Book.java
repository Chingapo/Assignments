package com.techlabs.bookkeeping.model;

import java.util.Random;

public class Book implements Comparable<Book> {
	private int id;
	private String title;
	private String author;
	private boolean isAvailable;
	
	Random random = new Random();
	
	

	@Override
	public String toString() {
		return "ID: " + id + ", Title: " + title + ", Author: " + author;
	}

	public Book(String title, String author) {
		super();
		this.id = random.nextInt();
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public int compareTo(Book o) {
		
		return this.getTitle().compareTo(o.getTitle());
	}

}
