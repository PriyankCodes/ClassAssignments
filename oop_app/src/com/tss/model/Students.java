package com.tss.model;

public class Students {

	private int rollNumber;
	private String name;
	private int age;
	private int subject1;
	private int subject2;
	private int subject3;

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSubjectMarks(int subject1, int subject2, int subject3) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int calculateAverage() {
		return (subject1 + subject2 + subject3) / 3;
	}
	
	public void displayData() {
		System.out.println();
		System.out.println("Students Information : ");
		System.out.println("Roll Number : " + getRollNumber());
		System.out.println("Name : " + getName());
		System.out.println("Age : " + getAge());
		System.out.println("Average Marks : " + calculateAverage());
	}

}
