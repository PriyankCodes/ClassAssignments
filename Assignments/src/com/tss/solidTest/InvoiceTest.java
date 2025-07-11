package com.tss.solidTest;

import java.util.Scanner;

import com.tss.solid.Invoice;

public class InvoiceTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Invoice ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter Description: ");
		String description = scanner.nextLine();

		System.out.print("Enter Cost: ");
		double cost = scanner.nextDouble();

		System.out.print("Enter Discount Percentage: ");
		double discountPercent = scanner.nextDouble();

		Invoice invoice = new Invoice(id, description, cost, discountPercent);

		invoice.print();

		scanner.close();
	}
}
