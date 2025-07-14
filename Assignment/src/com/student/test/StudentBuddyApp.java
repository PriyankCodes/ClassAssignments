package com.student.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentBuddyApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> name = new LinkedList<>();

		name.add("Devang");
		name.add("Priyank");
		name.add("Dharmik");
		name.add("Vivek");
		name.add("Dev");

		System.out.print("Enter Name : ");
		String buddy = scanner.nextLine();

		Iterator<String> iterator = name.iterator();

		boolean found = false;

		while (iterator.hasNext()) {
			String current = iterator.next();

		
			if (current.equalsIgnoreCase(buddy)) {
				found = true;
			}
			
			if (found) {
				System.out.print(current+" --> ");
			}

		}
	}

}
