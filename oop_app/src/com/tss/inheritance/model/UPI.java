package com.tss.inheritance.model;
public class UPI implements IPayment {

	String upiId;
	int pin;
	int amount;

	public UPI(int amount) {
		this.amount = amount;
		payment();
	}

	@Override
	public void payment() {
		boolean valid = false;

		while (!valid) {
			System.out.println("Enter UPI ID: ");
			upiId = scanner.next();

			System.out.println("Enter PIN: ");
			pin = scanner.nextInt();

			valid = validateData(upiId, pin);

			if (!valid) {
				System.out.println("Invalid UPI Details. Please try again.\n");
			}
		}

		System.out.println("\n"+amount + " Transferred Successfully");
		System.out.println("Transaction Details ----------------------- \nUPI ID: " + upiId + "\nAmount: " + amount);
	}

	public boolean validateData(String upiId, int pin) {
		if (!upiId.contains("@")) {
			System.out.println("Invalid UPI ID. Try Again.");
			return false;
		}

		if (pin < 1000 || pin > 9999) {
			System.out.println("Invalid PIN. It should be a 4-digit number.");
			return false;
		}

		return true;
	}
}
