package com.tss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.tss.model.Loan;

public class LoanTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<Loan> loanList = new ArrayList<Loan>();

		Supplier<Loan> loanSupplier = () -> {
			System.out.print("\nEnter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Age: ");
			int age = scanner.nextInt();

			System.out.print("Enter Credit Score: ");
			int creditScore = scanner.nextInt();

			System.out.print("Enter Income: ");
			int income = scanner.nextInt();
			scanner.nextLine();

			return new Loan(name, age, creditScore, income);
		};

		while (true) {
			loanList.add(loanSupplier.get());

			System.out.print("Want to add more record (Y/N)? ");
			String choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("N")) {
				break;
			}
		}

		Predicate<Loan> eligible = (loanlist) -> {

			if (loanlist.getAge() < 21)
				return false;

			if (loanlist.getIncome() < 25000)
				return false;

			if (loanlist.getCreditScore() < 650)
				return false;

			return true;

		};

		Function<Loan, Double> loanAmount = (loanlist) -> {
			return loanlist.getIncome() * ((double) loanlist.getCreditScore() / 1000);
		};

		Consumer<Loan> customer = (loan) -> {

			if (eligible.test(loan)) {
				System.out.println("---------------------");
				System.out.println("Loan Approved for " + loan.getName());
				System.out.println("Eligible Amount: ₹" + loanAmount.apply(loan));
			}

		};

		for (Loan loan : loanList) {
			customer.accept(loan);
		}

		scanner.close();
	}

}
