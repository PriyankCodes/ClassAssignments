package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tss.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(1, "Priyank", "Development", 50000),
				new Employee(2, "Devang", "QA", 40000), new Employee(3, "Dev", "Support", 35000),
				new Employee(4, "Vivek", "Security", 30000), new Employee(5, "Dharmik", "DevOps", 35000),
				new Employee(6, "Amit", "Development", 45000), new Employee(7, "Ravi", "QA", 37000),
				new Employee(8, "Nikhil", "Support", 33000), new Employee(9, "Manav", "DevOps", 42000),
				new Employee(10, "Kunal", "Security", 38000));

		List<Employee> sortedList = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
				.collect(Collectors.toList());

		for (Employee employee : sortedList) {
			System.out.println(employee.getId() + " - " + employee.getName() + " - " + employee.getDepartment() + " - "
					+ employee.getSalary());

		}

	}
}
