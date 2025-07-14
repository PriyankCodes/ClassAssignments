package com.tss.behavioral.stratergy.test;

import com.tss.behavioral.stratergy.model.Consultant;
import com.tss.behavioral.stratergy.model.Employee;
import com.tss.behavioral.stratergy.model.SeniorConsultant;
import com.tss.behavioral.stratergy.model.TechLead;

;

public class EmployeeTest {
	public static void main(String[] args) {

		Employee employee = new Employee(101, "Abc", new Consultant());
		System.out.println("Initial Role");
		employee.showDetails();

		employee.promote(new SeniorConsultant());
		System.out.println("\nAfter Promotion");
		employee.showDetails();

		employee.promote(new TechLead());
		System.out.println("\nFinal Role");
		employee.showDetails();
	}
}
