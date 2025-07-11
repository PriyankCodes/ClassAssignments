package com.tss.inheritance.model;


public class DebitCard implements IPayment {

	long debitNumber;
	int pin;
	int amount;

	public DebitCard(int amount) {
		this.amount = amount;
		payment();
	}

	@Override
	public void payment() {
		boolean valid = false;

		while (!valid) {
			System.out.println("Enter Debit Card Number: ");
			debitNumber = scanner.nextLong();
			System.out.println("Enter PIN: ");
			pin = scanner.nextInt();

			valid = validateData(debitNumber, pin);

			if (!valid) {
				System.out.println("Invalid Debit Card Details. Please try again.\n");
			}
		}

		System.out.println("\n"+amount + " Transferred Successfully");
		System.out.println("Transaction Details ------------------------------ \nDebit Card Number: " + debitNumber + " \nAmount: " + amount);
	}

	public boolean validateData(long debitNumber, int debitPin) {
		int count = 0;
		long tempNumber = debitNumber;

		while (tempNumber > 0) {
			tempNumber /= 10;
			count++;
		}

		if (count != 12) {
			System.out.println("Invalid Debit Card Number. It should have 12 digits.");
			return false;
		}

		if (debitPin < 1000 || debitPin > 9999) {
			System.out.println("Invalid PIN. It should be a 4-digit number.");
			return false;
		}

		return true;
	}
}
