package com.tss.structural.decorator.test;

import java.util.Scanner;

import com.tss.structural.decorator.model.CarInspection;
import com.tss.structural.decorator.model.ICarService;
import com.tss.structural.decorator.model.OilChange;
import com.tss.structural.decorator.model.WheelAlign;

public class CarServiceTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ICarService service = new CarInspection();

		System.out.println("Base Car Inspection selected (₹1000).");
		System.out.println("Add additional services:");
		System.out.println("1. Oil Change (₹500)");
		System.out.println("2. Wheel Alignment (₹400)");
		System.out.println("3. Both");
		System.out.println("4. Nothing");
		System.out.print("Enter your choice : ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			service = new OilChange(service);
			break;
		case 2:
			service = new WheelAlign(service);
			break;
		case 3:
			service = new OilChange(service);
			service = new WheelAlign(service);
			break;
		case 4:
			System.out.println("Total Service Cost: ₹" + service.getCost());
			return;
		default:
			System.out.println("No additional services selected.");
		}

		System.out.println("Total Service Cost: ₹" + service.getCost());
		scanner.close();

	}
}
