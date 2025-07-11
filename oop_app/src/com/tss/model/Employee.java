package com.tss.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
	

	private int employeeId;
	private String name;
	private LocalDate joiningDate;
	private double salary;
	
	public Employee() {
		employeeId = 0;
		name = "";
		joiningDate = LocalDate.now();
		salary = 0;
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate joinDate = LocalDate.parse(joiningDate, formatter);
			this.joiningDate = joinDate;
		} catch (Exception e) {
			System.out.println("Inalid Date..!");
			System.exit(0);
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String calculateExperience() {

		LocalDate today = LocalDate.now();
		Period period = Period.between(joiningDate, today);
		return period.getYears() + "y ";

	}

	public double calculateBonus(double salary) {
		double bonus = salary + (salary * 0.50);
		return bonus;
	}

	public void displayData() {
		System.out.println("Employee Data : ");
		System.out.println("\nId\tName\tJoiningDate\tSalary\tBonus\tExperience");
		System.out.println(getEmployeeId() + "\t" + getName() + "\t" + getJoiningDate() + "\t" + getSalary() + "\t"
				+ calculateBonus(getSalary()) + "\t" + calculateExperience());
	}

}
