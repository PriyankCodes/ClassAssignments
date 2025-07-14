package com.tss.behavioral.observer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tss.behavioral.exception.InsufficientBalanceException;

public class Account {
	private int accNo;
	private String name;
	private double balance;
	private double minBalance;
	private List<INotifiers> notifiers;

	public Account(int accNo, String name, double balance, double minBalance, List<INotifiers> notifiers) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		this.minBalance = minBalance;
		this.notifiers = notifiers;
	}

	public int getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public List<INotifiers> getNotifiers() {
		return notifiers;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public void setNotifiers(List<INotifiers> notifiers) {
		this.notifiers = notifiers;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			System.out.println("Deposited ₹" + amount);
			notifyObservers();
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount!");
			return;
		}
		if (balance - amount >= minBalance) {
			this.balance -= amount;
			System.out.println("Withdrawn ₹" + amount);
			notifyObservers();
		} else {
			notifyObservers();
			throw new InsufficientBalanceException(balance - minBalance);
		}
	}

	public static List<INotifiers> addNotifiers(Scanner scanner) {
		List<INotifiers> notifierList = new ArrayList<>();
		while (true) {
			System.out.println("Select Notifier (0 to finish):");
			System.out.println("1. WhatsApp");
			System.out.println("2. SMS");
			System.out.println("3. Email");
			int notiChoice = scanner.nextInt();

			if (notiChoice == 0)
				break;

			switch (notiChoice) {
			case 1:
				notifierList.add(new WhatsappNotifier());
				break;
			case 2:
				notifierList.add(new SMSNotifier());
				break;
			case 3:
				notifierList.add(new EmailNotifier());
				break;
			default:
				System.out.println("Invalid notifier.");
			}

		}
		return notifierList;

	}

	public void removeNotifier(Scanner scanner) {
		List<INotifiers> list = getNotifiers();
		if (list.isEmpty()) {
			System.out.println("No notifiers to remove.");
			return;
		}
		System.out.println("Select a notifier to remove:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " " + list.get(i).getClass().getSimpleName());
		}
		int removeIndex = scanner.nextInt();
		removeIndex--;

		if (removeIndex >= 0 && removeIndex < list.size()) {
			list.remove(removeIndex);
			System.out.println("Notifier removed.");
		} else {
			System.out.println("Invalid selection.");
		}
	}

	private void notifyObservers() {
		for (INotifiers notifier : notifiers) {
			notifier.sendNotification(this);
		}
	}
}
