package com.tss.solidTest;

import java.util.Scanner;
import com.tss.solid.InvoiceSolid;
import com.tss.solid.PrintSolid;

public class InvoiceSoliodTest {
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

		InvoiceSolid invoice = new InvoiceSolid(id, description, cost, discountPercent);

		PrintSolid print = new PrintSolid();
		print.print(invoice);

		scanner.close();

	}
}
