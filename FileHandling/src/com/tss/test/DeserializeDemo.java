package com.tss.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.tss.model.Employee;

 class DeserializeDemo {
	public static void main(String[] args) {
		Employee employee = null;

		try (FileInputStream fileIn = new FileInputStream("employee.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {

			employee = (Employee)in.readObject();
			
			System.out.println("Deserialization successful.");
			System.out.println("Employee Data: " + employee.toString());
			
		} catch (IOException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
}
