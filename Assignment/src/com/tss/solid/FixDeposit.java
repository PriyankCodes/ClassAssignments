package com.tss.solid;

public class FixDeposit {
    private int accountNumber;
    private String name;
    private double principal;
    private int duration;
    private InterestRate interestRate;

    public FixDeposit(int accountNumber, String name, double principal, int duration, InterestRate interestRate) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.principal = principal;
        this.duration = duration;
        this.interestRate = interestRate;
    }

    public double calculateSimpleInterest() {
        return (principal * duration * interestRate.getRate()) / 100;
    }
}
