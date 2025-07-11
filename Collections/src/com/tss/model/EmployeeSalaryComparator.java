package com.tss.model;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if (o1.getSalary() > o2.getSalary())
			return 1;

		if (o1.getSalary() < o2.getSalary())
			return 1;

		return 0;
	}

}
