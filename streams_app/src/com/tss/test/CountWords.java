package com.tss.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWords {

	public static void main(String[] args) {
		List<String> words = List.of("apple", "banana", "apricot", "blueberry", "cherry");

		Map<Character, Long> count = words.stream()
				.collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));

		count.forEach((k, v) -> System.out.println(k + " => " + v));
	}

}
