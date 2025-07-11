package com.tss.structural.adapter.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.tss.structural.adapter.model.Biscuit;
import com.tss.structural.adapter.model.Chocolate;
import com.tss.structural.adapter.model.Hat;
import com.tss.structural.adapter.model.HatAdapter;
import com.tss.structural.adapter.model.IItems;
import com.tss.structural.adapter.model.ShoppingCart;

public class ShoppingCartTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ShoppingCart cart = new ShoppingCart();

		ArrayList<IItems> selectedItems = new ArrayList<>();

		int choice;
		do {
			System.out.println("\n1. Add Biscuit (₹50)");
			System.out.println("2. Add Chocolate (₹120)");
			System.out.println("3. Add Hat");
			System.out.println("4. Get Bill & Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				selectedItems.add(new Biscuit("Parle-G", 50.0));
				System.out.println("Biscuit added to cart.");
				break;
			case 2:
				selectedItems.add(new Chocolate("Cadbury", 120.0));
				System.out.println("Chocolate added to cart.");
				break;
			case 3:
				Hat hat = new Hat("RHat", " Red Stylish Hat", 1000.0, 15.0);
				selectedItems.add(new HatAdapter(hat));
				System.out.println("Hat added to cart.");
				break;
			case 4:
				cart.addItemsToCart(selectedItems);
				System.out.println("\n--- Your Bill ---");
				cart.displayCart();
				break;
			default:
				System.out.println("Invalid choice! Try again.");
			}

		} while (choice != 4);

		scanner.close();
	}
}
