package com.tss.model;

public class Student {

	private int studentId;
	private int rollno;
	private String name;
	private int age;
	private double percentage;

	public Student() {
		super();
	}

	public Student(int studentId, int rollno, String name, int age, double percentage) {
		super();
		this.studentId = studentId;
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.percentage = percentage;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
