package com.tss.model;

public class Students {

	private String name;
	private int rollno;
	private int marks;

	public Students(String name, int rollno, int marks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getRollno() {
		return rollno;
	}

	public int getMarks() {
		return marks;
	}

}
