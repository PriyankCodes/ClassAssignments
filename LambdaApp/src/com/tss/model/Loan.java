package com.tss.model;

public class Loan {

	private String name;
	private int age, creditScore, income;

	public Loan(String name, int age, int creditScore, int income) {
		super();
		this.name = name;
		this.age = age;
		this.creditScore = creditScore;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public int getIncome() {
		return income;
	}

}
