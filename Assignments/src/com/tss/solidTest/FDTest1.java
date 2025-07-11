package com.tss.solidTest;

import java.util.Scanner;

import com.tss.solid.*;

public class FDTest1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of Fixed Deposits: ");
		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("\nEnter details for Fixed Deposit " + i + ":");

			System.out.print("Enter Customer ID: ");
			int id = scanner.nextInt();

			scanner.nextLine();

			System.out.print("Enter Customer Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Deposit Amount: ");
			double amount = scanner.nextDouble();

			System.out.print("Enter Duration (in years): ");
			int years = scanner.nextInt();

			System.out.print("Enter Festival Type (NEWYEAR/DIWALI/HOLI/OTHER): ");
			String festivalInput = scanner.next().toUpperCase();

			InterestRate interestRate;

			switch (festivalInput) {
			case "NEWYEAR":
				interestRate = new NewYearInterestRate();
				break;
			case "DIWALI":
				interestRate = new DiwaliInterestRate();
				break;
			case "HOLI":
				interestRate = new HoliInterestRate();
				break;
			default:
				System.out.println("Invalid festival type. Defaulting to OTHER.");
				interestRate = new OtherInterestRate();
				break;
			}

			FixDeposit fd = new FixDeposit(id, name, amount, years, interestRate);
			System.out.println("Interest for FD" + i + ": " + fd.calculateSimpleInterest());
		}

		scanner.close();
	}
}
