package com.tss.structural.facade.model;

public class ItalianHotel implements IHotel {

	@Override
	public IMenu getMenu() {

		return new ItalianHotel();

	}

	@Override
	public void display() {
		System.out.println("Italian Menu:");
		System.out.println("- Margherita Pizza");
		System.out.println("- Veg Lasagna");
		System.out.println("- Italian Pasta");
		System.out.println("- Garlic Bread");
	}

}
