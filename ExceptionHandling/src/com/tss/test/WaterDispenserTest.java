package com.tss.test;

import java.util.Scanner;

import com.tss.exception.InsufficientWaterException;
import com.tss.exception.OverfillException;
import com.tss.model.WaterDispenser;

public class WaterDispenserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int choice;
		int water;
		int currentWaterLevel = 0;
		WaterDispenser waterDispenser = new WaterDispenser();

		System.out.println("Welcome to Digital Water Dispenser");
		try (scanner) {
			while (true) {
				System.out.println("\n1. Fill Water in Tank \n2. Dispense Water from Tank \n3. Exit");
				choice = scanner.nextInt();

				try {
					switch (choice) {

					case 1:
						try {
							System.out.print("How many liters water you want to fill => ");
							water = scanner.nextInt();
							currentWaterLevel = waterDispenser.fillWater(water);
						} catch (OverfillException exception) {
							System.out.println(exception.getMessage());
						}
						break;

					case 2:
						try {
							System.out.print("How many liters water you want to dispense => ");
							water = scanner.nextInt();
							currentWaterLevel = waterDispenser.dispenseWater(water);
						} catch (InsufficientWaterException exception) {
							System.out.println(exception.getMessage());
						}
						break;

					case 3:
						System.out.println("\nThank you for using Digital Water Dispenser...");
						System.exit(0);

					default:
						System.out.println("Enter Valid Choice...");

					}
				} catch (Exception exception) {
					System.out.println("An error occured !!!");
				} finally {
					System.out.println("Current Water Level is : " + currentWaterLevel + " liters");
				}
			}
		}
	}

}
