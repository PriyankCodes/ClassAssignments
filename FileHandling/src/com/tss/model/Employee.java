package com.tss.model;

import java.io.Serializable;

public class Employee implements Serializable {

	String name;
	int id;
	String department;

	public Employee(String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + name + ", ID=" + id + ", Department=" + department + "]";
	}
}
