package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class RideGameCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int charge = 0;

		System.out.print("Enter Your Height(cm) : ");
		int height = scanner.nextInt();

		if (height > 120) {
			System.out.println("You can Ride...");

			System.out.print("Enter Your Age : ");
			int age = scanner.nextInt();

			if (age < 12) {
				charge = 5;
				wantPhotos(charge);
			} else if (age >= 12 && age < 18) {
				charge = 7;
				wantPhotos(charge);
			} else if (age >= 45 && age <= 55) {
				charge = 0;
				wantPhotos(charge);
			} else if (age >= 18 && age < 45) {
				charge = 12;
				wantPhotos(charge);
			}

			else {
				charge = 12;
				wantPhotos(charge);
			}
		} else {
			System.out.println("You can't Ride...");
		}

	}

	private static void wantPhotos(int charge) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Do you Want Photos ? (YES/NO) : ");
		String photo = scanner.nextLine();
		int totalBill = 0;

		if (photo.equalsIgnoreCase("YES")) {
			totalBill = charge + 3;
			System.out.println("Your Total Bill is : $" + totalBill);
		} else if (photo.equalsIgnoreCase("NO")) {
			totalBill = charge;
			System.out.println("Your Total Bill is : $" + totalBill);
		} else {
			System.out.println("Invalid Choice...");
		}
	}

}
