package com.tss.inheritance.model;

public class CreditCard implements IPayment {

	long creditNumber;
	int pin;
	int amount;

	public CreditCard(int amount) {
		this.amount = amount;
		payment();
	}

	@Override
	public void payment() {
		boolean valid = false;

		while (!valid) {
			System.out.println("Enter Credit Card Number : ");
			creditNumber = scanner.nextLong();
			System.out.println("Enter PIN : ");
			pin = scanner.nextInt();

			valid = validateData(creditNumber, pin);

			if (!valid) {
				System.out.println("Invalid Credit Card Details. Please try again.\n");
			}
		}

		System.out.println("\n"+amount + " Transferred Successfully");
		System.out.println("Transaction Details ---------------- \nCredit Card Number : " + creditNumber + " \nAmount : " + amount);
	}

	public boolean validateData(long creditNumber, int creditPin) {
		int count = 0;
		long tempNumber = creditNumber;

		while (tempNumber > 0) {
			tempNumber /= 10;
			count++;
		}

		if (count != 16) {
			System.out.println("Invalid Credit Card Number. It should have 16 digits.");
			return false;
		}

		if (creditPin < 1000 || creditPin > 9999) {
			System.out.println("Invalid PIN. It should be a 4-digit number.");
			return false;
		}

		return true;
	}
}
