package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueSortedWords {

	public static void main(String[] args) {
		List<String> sentences = List.of("Hello world", "hello Java", "Stream API");

		List<String> result = sentences.stream().flatMap(s -> Arrays.stream(s.toLowerCase().split("\\s+"))).distinct()
				.sorted().collect(Collectors.toList());

		System.out.println(result);
	}

}
