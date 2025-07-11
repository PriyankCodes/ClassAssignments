package com.tss.model;

public class Account {

	private int accountId;
	private String accountNumber;
	private String name;
	private long balance;
	private AccountType accountType;

	public Account() {
		accountId = 0;
		accountNumber = "";
		name = "";
		balance = 0;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String string) {
		this.accountNumber = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType string) {
		this.accountType = string;
	}

	public void deposit(long amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Amount Deposited Successfully to accountId " + accountId);
			System.out.println("Balance = ₹"+balance);

		} else {
			System.out.println("Cannot Deposit this Amount");
		}
	}

	public void withdraw(long amount) {
		if (((balance - amount) < 500)&&(amount > 0)) {
			System.out.println("Insufficiet Balance...You cannot withdraw");
		} else {
			balance -= amount;
			System.out.println("Withdrawn Amount = ₹" + amount + " from accountId : " + accountId);
			System.out.println("Balance = ₹"+balance);
		}
	}

	public void transfer(int from, int to, int amount, Account[] account) {

		if (((balance - amount) >= 500)) {
			account[from].withdraw(amount);
			account[to].deposit(amount);
		} else {
			System.out.println("Cannot Transfer Money Due to Insuffiecient Balance");
		}

	}

	@Override
	public String toString() {
		return "[accountId = " + accountId + ", accountNumber = " + accountNumber + ", name = " + name + ", balance = "
				+ balance + ", accountType = " + accountType + "]";
	}

}
