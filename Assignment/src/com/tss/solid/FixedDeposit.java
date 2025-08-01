package com.tss.solid;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;

	public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festival) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
	}

	public double getInterestRate() {
		switch (festival) {
		case NEWYEAR:
			return 8.0;
		case DIWALI:
			return 8.5;
		case HOLI:
			return 7.5;
		default:
			return 6.5;
		}
	}

	public double calculateSimpleInterest() {
		return (principal * duration * getInterestRate()) / 100;
	}
}
