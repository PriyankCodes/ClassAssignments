package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentStreamTest {
	public static void main(String[] args) {
		String[] namesArray = { "Jay", "Nimesh", "Mark", "Mahesh", "Ramesh" };
		List<String> names = Arrays.asList(namesArray);

		System.out.println("a. First 3 names sorted ascending:");
		names.stream().sorted().limit(3).forEach(name -> System.out.println(name));

		System.out.println("\nb. First 3 names with 'a' sorted ascending:");
		names.stream().filter(name -> name.toLowerCase().contains("a")).sorted().limit(3)
				.forEach(name -> System.out.println(name));

		System.out.println("\nc. All names sorted descending:");
		names.stream().sorted(Comparator.reverseOrder()).forEach(name -> System.out.println(name));

		System.out.println("\nd. First 3 characters of each name:");
		names.stream().map(name -> name.length() >= 3 ? name.substring(0, 3) : name)
				.forEach(name -> System.out.println(name));

		System.out.println("\ne. Names with <= 4 characters:");
		names.stream().filter(name -> name.length() <= 4).forEach(name -> System.out.println(name));
	}
}
