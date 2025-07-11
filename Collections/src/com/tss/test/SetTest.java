package com.tss.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> numbers1 = new HashSet<>();

		numbers1.add(20);
		numbers1.add(10);
		numbers1.add(5);
		numbers1.add(30);
		numbers1.add(40);
		System.out.println(numbers1);

		Set<Integer> numbers2 = new LinkedHashSet<>();

		numbers2.add(20);
		numbers2.add(5);
		numbers2.add(10);
		numbers2.add(30);
		numbers2.add(40);

		System.out.println(numbers2);
		Set<Integer> numbers3 = new TreeSet<>();

		numbers3.add(20);
		numbers3.add(5);
		numbers3.add(10);
		numbers3.add(30);
		numbers3.add(40);

		System.out.println(numbers3);

	}

}
