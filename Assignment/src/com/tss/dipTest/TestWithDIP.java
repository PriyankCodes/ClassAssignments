package com.tss.dipTest;

import com.tss.dip.CreditCardPayment;
import com.tss.dip.IPayment;
import com.tss.dip.ShoppingCartDIP;
import com.tss.dip.UPIPayment;

public class TestWithDIP {
	public static void main(String[] args) {

		IPayment paymentMethod1 = new CreditCardPayment();
		IPayment paymentMethod2 = new UPIPayment();

		ShoppingCartDIP cart1 = new ShoppingCartDIP(paymentMethod1);
		ShoppingCartDIP cart2 = new ShoppingCartDIP(paymentMethod2);

		cart1.checkout(400);
		cart2.checkout(800);

	}
}