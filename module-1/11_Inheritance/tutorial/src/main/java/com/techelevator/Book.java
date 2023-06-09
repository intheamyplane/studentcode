package com.techelevator;

/**
 * Book
 */
public class Book extends MediaItem {

    private String title;
    private String author;
    private double price;

	public Book(String title, String author, double price) {
	    this.title = title;
	    this.author = author;
	    this.price = price;
	}
	
	public Book() {
	}
	@Override
	public String toString() {
	    return "Title: " + title + ", Author: " + author + ", Price: $" + price;
	}
}
