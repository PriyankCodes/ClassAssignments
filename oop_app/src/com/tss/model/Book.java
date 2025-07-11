package com.tss.model;

public class Book {

	private int bookId;
	private String bookName;
	private String author;
	private String publication;
	private double price;
	private double discountPrice;

	public Book() {
		bookId = 0;
		bookName = "";
		author = "";
		publication = "";
		price = 0;
		discountPrice = 0;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public void setPrice(double price) {
		this.price = price;
		setDiscountedPrice(this.price);
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublication() {
		return publication;
	}

	public double getPrice() {
		return price;
	}

	public void setDiscountedPrice(double price) {
		discountPrice = (price - (price / 10));

	}

	public double getDiscountedPrice() {
		return discountPrice;

	}

	public void displayData() {
		System.out.println("\nID\t\tName\t\tAuthor\t\tPublication\t\tPrice\t\tDiscountedPrice");

		System.out.println(getBookId() + "\t\t" + getBookName() + "\t\t" + getAuthor() + "\t\t" + getPublication()
				+ "\t\t" + getPrice() + "\t\t" + getDiscountedPrice());

	}

}
