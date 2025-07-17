package com.tss.test;

import java.util.List;

import com.tss.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		List<Product> products = List.of(new Product("Laptop", 50000, 1), new Product("Mouse", 1500, 2),
				new Product("Keyboard", 3000, 1));

		double total = products.stream().map(product -> product.getPrice() * product.getQuantity()).reduce(0.0, Double::sum);

		System.out.println("Total bill: ₹" + total);
	}

}
