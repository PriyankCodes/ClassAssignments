package com.tss.test;

import java.util.Random;
import java.util.Scanner;

import com.tss.model.Account;
import com.tss.model.AccountType;

public class AccountTest {
	static Scanner scanner = new Scanner(System.in);
	static int accountId = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Priyank's Bank\n");

		System.out.print("How many Accounts Record You want : ");
		int records = scanner.nextInt();

		Account account[] = new Account[records];

		bankMenu(account, records);

	}

	private static void bankMenu(Account[] account, int records) {
		int j = 0;
		int i = 0;
		while (true) {
			System.out.println("-----------------------------------");
			System.out.println("1. Create Account");
			System.out.println("2. Display Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Tranfer Amount");
			System.out.println("6. Exit");
			System.out.print("\nEnter Your Choice : ");
			int choice = scanner.nextInt();
			int from = 0;
			int to = 0;
			switch (choice) {
			case 1:
				if (j == records) {
					System.out.println("Can't Create new Accounts Further");
					break;
				}
				account[i] = new Account();

				System.out.print("Enter Your Name : ");
				account[i].setName(scanner.next());

				while (true) {
					System.out.print("Enter Account Type \n1. SAVINGS \n2. CURRENT \n3. FD  ");
					int accountType = scanner.nextInt();
					if (accountType == 1) {
						account[i].setAccountType(AccountType.SAVING);
						break;
					} else if (accountType == 2) {
						account[i].setAccountType(AccountType.CURRENT);
						break;

					} else if (accountType == 3) {
						account[i].setAccountType(AccountType.FD);
						break;

					} else {
						System.out.println("Invalid choice");
					}
				}

				System.out.print("Enter Initial Balance to Deposit : ");
				account[i].setBalance(scanner.nextLong());

				account[i].setAccountId(generateAccountId());

				account[i].setAccountNumber(generateAccountNumber(account, i));

				System.out.println(account[i].toString());
				j++;
				i++;

				break;

			case 2:
				System.out.print("Enter AccountId to proceed further : ");
				accountId = scanner.nextInt();
				accountId -= 1;
				if (account[accountId] == null) {
					System.out.println("Please create an account first.");
					break;
				}
				System.out.println("Your Balance is ₹" + account[accountId].getBalance());
				break;

			case 3:

				System.out.print("Enter AccountId to proceed further : ");
				accountId = scanner.nextInt();
				accountId -= 1;

				if (account[accountId] == null) {
					System.out.println("Please create an account first.");
					break;
				}
				System.out.print("Enter Amount to Deposit : ");
				account[accountId].deposit(scanner.nextLong());
				break;

			case 4:

				System.out.print("Enter AccountId to proceed further : ");
				accountId = scanner.nextInt();
				accountId -= 1;

				if (account[accountId] == null) {
					System.out.println("Please create an account first.");
					break;
				}
				System.out.print("Enter Amount to Withdraw : ");
				account[accountId].withdraw(scanner.nextLong());

				break;

			case 5:
				try {
					System.out.print("Enter AccountId to Transfer from  : ");
					from = scanner.nextInt();
					from -= 1;

					if (account[from] == null) {
						System.out.println("Please create an account first.");
						break;
					}

					System.out.print("Enter AccountId to Transfer To : ");
					to = scanner.nextInt();
					to -= 1;

					if (account[to] == null) {
						System.out.println("No Account Exists ");
						break;
					}
				} catch (Exception e) {
					System.out.println("No such Account Exists..... ");
					break;
				}
				System.out.print("Enter Amount to Transfer : ");
				int amount = scanner.nextInt();
				account[from].transfer(from, to, amount, account);
				break;

			case 6:
				System.out.println();
				for (int k = 0; k < i; k++) {
					System.out.println(account[k].toString());

				}
				System.out.println("\nThank you for visiting..!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice... Try Again");
			}
		}
	}

	private static String generateAccountNumber(Account[] account, int records) {

		Random random = new Random();
		String accountCode = "AXIS1000";
		String accountNumber;
		while (true) {
			int randomNumber = 100000 + random.nextInt(900000);
			accountNumber = accountCode + randomNumber;

			boolean isUnique = true;
			for (int i = 0; i < records; i++) {
				if (account[i] != null && account[i].getAccountNumber().equals(accountNumber)) {
					isUnique = false;
					break;
				}
			}
			if (isUnique) {
				return accountNumber;
			}
		}
	}

	private static int generateAccountId() {

		accountId += 1;
		return (accountId);
	}

}
