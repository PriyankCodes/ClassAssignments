package com.tss.test;

import java.util.Scanner;

import com.tss.model.ElectricityBill;

public class ElectricityBillTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("How Many Apartments in complex : ");
		int apartments = scanner.nextInt();

		ElectricityBill electricityBill[] = new ElectricityBill[apartments];

		electricityBillMenu(electricityBill, apartments);

	}

	private static void electricityBillMenu(ElectricityBill[] electricityBill, int apartments) {
		int i = 0;
		int j = 0;
		while (true) {

			System.out.println("\n1. Enter Apartment Units Consumed : ");
			System.out.println("2. Calculate Bill");
			System.out.println("3. Display Current Rate");
			System.out.println("4. Change current Price Per Unit");
			System.out.println("5. Exit");

			System.out.print("\nEnter Your Choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:

				if (j == apartments) {
					System.out.println("There are no more Apartments in complex");
					break;
				}

				electricityBill[i] = new ElectricityBill();

				System.out.print("\nEnter Apartment Number : ");
				electricityBill[i].setApartmentNumber(scanner.nextInt());

				System.out.print("Enter Units Consumed : ");
				electricityBill[i].setUnitsConsumed(scanner.nextDouble());
				
				electricityBill[i].calculateBill();
				i++;
				j++;

				break;

			case 2:

				System.out.print("\nEnter Your Apartment Number : ");
				int apartmentNumber = scanner.nextInt();
				apartmentNumber -= 1;
				electricityBill[apartmentNumber].calculateBill();
				break;

			case 3:
				ElectricityBill.displayCurrentRate();
				break;

			case 4:
				System.out.println("Enter new Cost Per Unit : ");
				double newCost = scanner.nextDouble();
				ElectricityBill.changeCostPerUnit(newCost);
				break;

			case 5:
				System.out.println();
				for (int k = 0; k < i; k++) {
					System.out.println(electricityBill[k].toString());

				}
				System.exit(0);

			default:
				System.out.println("Invalid Choice : ");

			}

		}
	}

}
