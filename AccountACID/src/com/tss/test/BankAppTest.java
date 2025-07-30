package com.tss.test;

import com.tss.controller.BankController;

import java.util.Scanner;

public class BankAppTest {
	public static void main(String[] args) throws Exception {
		BankController controller = new BankController();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n1. Transfer Funds");
			System.out.println("2. View All Account Balances");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				controller.startTransferFlow();
				break;
			case 2:
				controller.viewAllAccounts();
				break;
			case 3:
				System.out.println(" Exiting the application. Thank you!");
				break;
			default:
				System.out.println(" Invalid choice. Please select again.");
			}
		} while (choice != 3);

		sc.close();
	}
}
