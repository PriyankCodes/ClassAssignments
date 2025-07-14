package com.tss.behavioral.stratergy.model;

public class Employee {
	private int id;
	private String name;
	private IRole role;

	public Employee(int id, String name, IRole role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public void promote(IRole newRole) {
		this.role = newRole;
	}

	public String getDescription() {
		return role.getDescription();
	}

	public String getResponsibility() {
		return role.getResponsibility();
	}

	public void showDetails() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Role: " + role.getClass().getSimpleName());
		System.out.println("Description: " + getDescription());
		System.out.println("Responsibility: " + getResponsibility());
	}
}
