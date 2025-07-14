package com.tss.solidTest;

import java.util.Scanner;

import com.tss.solid.FestivalType;
import com.tss.solid.FixedDeposit;

public class FDTest {
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

			System.out.print("Enter Festival Type (NEWYEAR/DIWALI/HOLI): ");
			String festivalInput = scanner.next().toUpperCase();

			FestivalType festivalType;
			try {
				festivalType = FestivalType.valueOf(festivalInput);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid festival type. Defaulting to NEWYEAR.");
				festivalType = FestivalType.NEWYEAR;
			}

			FixedDeposit fd = new FixedDeposit(id, name, amount, years, festivalType);
			System.out.println("Interest for FD" + i + ": " + fd.calculateSimpleInterest());
		}

		scanner.close();
	}
}
