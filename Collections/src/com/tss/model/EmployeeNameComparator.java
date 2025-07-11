package com.tss.model;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
