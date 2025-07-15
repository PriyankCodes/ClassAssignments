package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.tss.model.Account;

public class AccountTest {
	public static void main(String[] args) {
		List<Account> accounts = Arrays.asList(
				new Account(101, "Vivek", 12000), 
				new Account(102, "Dev", 18000),
				new Account(103, "Priyank", 25000), 
				new Account(104, "Devang", 9000),
				new Account(105, "Abcdefghi", 30000));
		

		System.out.println("Account with Minimum Balance:");
		accounts.stream()
				.min(Comparator.comparing(account -> account.getBalance()))
				.ifPresent(account -> System.out.println(account));

		System.out.println("\nAccount with Maximum Balance:");
		accounts.stream()
				.max(Comparator.comparing(account -> account.getBalance()))
				.ifPresent(account -> System.out.println(account));

		System.out.println("\nNames with more than 6 characters:");
		accounts.stream()
				.filter(account -> account.getName().length() > 6)
				.forEach(account -> System.out.println(account.getName()));

		System.out.println("\nTotal Balance of All Accounts:");
		double total = accounts.stream()
				.map(account -> account.getBalance())
				.reduce(0.0, (a, b) -> a + b);
		System.out.println(total);
	}
}
