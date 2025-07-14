package com.tss.behavioral.exception;

public class InsufficientBalanceException extends RuntimeException {

	double balance;

	public InsufficientBalanceException(double balance) {
		this.balance = balance;
	}

	public String getMessage() {
		return "Insufficient Balance in Account: You can only withdraw => " + balance;
	}
}
