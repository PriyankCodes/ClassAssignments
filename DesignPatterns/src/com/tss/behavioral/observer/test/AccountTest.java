package com.tss.behavioral.observer.test;

import java.util.List;
import java.util.Scanner;

import com.tss.behavioral.exception.InsufficientBalanceException;
import com.tss.behavioral.observer.model.Account;
import com.tss.behavioral.observer.model.INotifiers;

public class AccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Account account = null;

		while (true) {
			System.out.println("\n1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Remove Notifier");
			System.out.println("5. Display Balance");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			try {
				switch (choice) {
				case 1:
					System.out.print("Enter Account Number: ");
					int accNo = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					System.out.print("Enter Initial Balance: ");
					double balance = scanner.nextDouble();
					System.out.print("Enter Minimum Balance: ");
					double minBal = scanner.nextDouble();

					List<INotifiers> notifierList = Account.addNotifiers(scanner);

					account = new Account(accNo, name, balance, minBal, notifierList);
					System.out.println("Account created successfully.");
					break;

				case 2:
					if (account != null) {
						System.out.print("Enter deposit amount: ");
						account.deposit(scanner.nextDouble());
					} else {
						System.out.println("Create an account first.");
					}
					break;

				case 3:
					if (account != null) {
						System.out.print("Enter withdraw amount: ");
						double amount = scanner.nextDouble();
						try {
							account.withdraw(amount);
						} catch (InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						}
					} else {
						System.out.println("Create an account first.");
					}
					break;

				case 4:
					if (account != null)
						account.removeNotifier(scanner);
					else
						System.out.println("Create Account First...");
					break;

				case 5:
					if (account != null) {
						System.out.println("Balance: ₹" + account.getBalance());
					} else {
						System.out.println("Create an account first.");
					}
					break;

				case 6:
					scanner.close();
					return;

				default:
					System.out.println("Invalid choice!");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}
}
