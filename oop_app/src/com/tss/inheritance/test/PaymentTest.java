package com.tss.inheritance.test;

import java.util.Scanner;

import com.tss.inheritance.model.CreditCard;
import com.tss.inheritance.model.DebitCard;
import com.tss.inheritance.model.Paypal;
import com.tss.inheritance.model.UPI;

public class PaymentTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int amount = 0;
		while (true) {
			System.out.print("Enter Amount to Pay : ");
			amount = scanner.nextInt();

			if (amount <= 0) {
				System.out.println("Enter Valid Amount");
			} else {
				break;
			}
		}

		System.out.print(
				"Which way to make Payment: \n1. Credit Card \n2. Debit Card \n3. UPI \n4. Paypal\nEnter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			CreditCard creditCard = new CreditCard(amount);
			break;

		case 2:
			DebitCard debitCard = new DebitCard(amount);
			break;

		case 3:
			UPI upi = new UPI(amount);
			break;

		case 4:
			Paypal paypal = new Paypal(amount);
			break;

		default:
			System.out.println("Invalid Choice. ");
		}

	}
}
