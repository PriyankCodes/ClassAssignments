package com.tss.test;

import java.util.Scanner;

import com.tss.model.IVehicle;
import com.tss.model.VehicleFactory;
import com.tss.model.vehicleType;

public class VehicleTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Vehicle Type : ");
		System.out.print("1. TwoWheeler \n2. FourWheeler \n3. HeavyVehicle => ");

		int vehicle = scanner.nextInt();

		if (vehicle == 1) {
			IVehicle plate = VehicleFactory.getVehicle(vehicleType.TwoWheel);
			System.out.println("\nYour Licence Plate number => " + plate.generateLicencePlate());
		}

		if (vehicle == 2) {
			IVehicle plate = VehicleFactory.getVehicle(vehicleType.FourWheel);
			System.out.println("\nYour Licence Plate number => " + plate.generateLicencePlate());
		}

		if (vehicle == 3) {
			IVehicle plate = VehicleFactory.getVehicle(vehicleType.HeavyVehicle);
			System.out.println("\nYour Licence Plate number => " + plate.generateLicencePlate());
		}

		if (vehicle != 1 && vehicle != 2 && vehicle != 3) {
			System.out.println("Enter valid vehicle");
		}

	}

}
