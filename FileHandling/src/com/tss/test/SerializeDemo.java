package com.tss.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.tss.model.Employee;

public class SerializeDemo {
	public static void main(String[] args) {
		Employee employee = new Employee("Priyank", 101, "CE");
		
		try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

			out.writeObject(employee);
			System.out.println("Serialization successful. Object is saved to employee.ser");
			
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
	}
}
