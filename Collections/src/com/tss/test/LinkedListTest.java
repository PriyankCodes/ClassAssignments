package com.tss.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new LinkedList<String>();

		list.add("Priyank");
		list.add("Devang");
		list.add("Vivek");
		list.add("Priyank");

		System.out.println(list);

		list.remove(3);

		System.out.println(list);

		list.add(2, "Dharmik");
		System.out.println(list);

		list.set(1, "Dev");
		System.out.println(list);

		System.out.println("\nPrinting with for loop : ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("\nPrinting with object for loop :");
		for (String object : list) {
			System.out.println(object);
		}

		System.out.println("\nUsing Iterator : ");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+"\t");
		}
		System.out.println();

		System.out.println("\nUsing list Iterator : ");
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("\nList Iterator reverse : ");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}

}
