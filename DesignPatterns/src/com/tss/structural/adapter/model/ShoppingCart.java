package com.tss.structural.adapter.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<IItems> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItemsToCart(List<IItems> newItems) {
		this.items.addAll(newItems);
	}

	public List<IItems> getCartItems() {
		return items;
	}

	public double getCartPrice() {
		double total = 0.0;
		for (IItems item : items) {
			total += item.getItemPrice();
		}
		return total;
	}

	public void displayCart() {
		System.out.printf("%-20s %s\n", "Item Name", "Price");
		System.out.println("------------------------------");
		for (IItems item : items) {
			System.out.printf("%-20s %.2f\n", item.getItemName(), item.getItemPrice());
		}
		System.out.println("\nTotal:      " + getCartPrice());
	}
}
