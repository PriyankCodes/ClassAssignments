package com.tss.test;

import java.util.Scanner;
import com.tss.model.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book book = new Book();
		readData(book);
		book.displayData();
	}

	private static void readData(Book book) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Book Deatils : ");

		System.out.print("Enter Book ID : ");
		book.setBookId(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter Book Name : ");
		book.setBookName(scanner.nextLine());

		System.out.print("Enter Author Name : ");
		book.setAuthor(scanner.nextLine());

		System.out.print("Enter Publication : ");
		book.setPublication(scanner.nextLine());

		System.out.print("Enter Price : ");
		book.setPrice(scanner.nextDouble());
		scanner.nextLine();

	}

}
