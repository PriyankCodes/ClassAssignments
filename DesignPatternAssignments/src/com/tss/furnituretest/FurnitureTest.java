package com.tss.furnituretest;

import java.util.Scanner;

import com.tss.furnituremodel.IChair;
import com.tss.furnituremodel.IFurnitureFactory;
import com.tss.furnituremodel.ISofa;
import com.tss.furnituremodel.ITable;
import com.tss.furnituremodel.ModernFurnitureFactory;
import com.tss.furnituremodel.VictorianFurnitureFactory;

public class FurnitureTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Style: ");
		System.out.println("1. Modern");
		System.out.println("2. Victorian");
		System.out.print("Choice => ");
		int style = scanner.nextInt();

		IFurnitureFactory factory;

		if (style == 1) {
			factory = new ModernFurnitureFactory();
		} else if (style == 2) {
			factory = new VictorianFurnitureFactory();
		} else {
			System.out.println("Invalid input.");
			scanner.close();
			return;
		}

		IChair chair = factory.createChair();
		ISofa sofa = factory.createSofa();
		ITable table = factory.createTable();

		System.out.println("\nFurniture Set Description:");
		chair.describe();
		sofa.describe();
		table.describe();

		scanner.close();
	}
}
