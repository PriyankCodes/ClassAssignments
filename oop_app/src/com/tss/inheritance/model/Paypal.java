package com.tss.inheritance.model;

public class Paypal implements IPayment {

	String paypalId;
	int pin;
	int amount;

	public Paypal(int amount) {
		this.amount = amount;
		payment();
	}

	@Override
	public void payment() {
		boolean valid = false;

		while (!valid) {
			System.out.println("Enter PayPal ID: ");
			paypalId = scanner.next();

			System.out.println("Enter PIN: ");
			pin = scanner.nextInt();

			valid = validateData(paypalId, pin);

			if (!valid) {
				System.out.println("Invalid PayPal Details. Please try again.\n");
			}
		}

		System.out.println("\n"+amount + " Transferred Successfully");
		System.out.println("Transaction Details ------------------------\nPayPal ID: " + paypalId + "\nAmount: " + amount);
	}

	public boolean validateData(String paypalId, int pin) {
		if (!paypalId.contains("@")) {
			System.out.println("Invalid PayPal ID. Try Again..");
			return false;
		}

		if (pin < 1000 || pin > 9999) {
			System.out.println("Invalid PIN. It should be a 4-digit number.");
			return false;
		}

		return true;
	}
}
