package com.tss.dipTest;

import com.tss.dip.ShoppingCart;

public class TestWithoutDIP {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.checkOut();
	}
}