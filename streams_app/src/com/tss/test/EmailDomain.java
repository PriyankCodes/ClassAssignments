package com.tss.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailDomain {

	public static void main(String[] args) {
		List<String> emails = List.of("priyank@gmail.com", "devang@yahoo.com", "vivek@gmail.com");

		Set<String> domains = emails.stream().map(email -> email.substring(email.indexOf("@") + 1))
				.collect(Collectors.toSet());

		System.out.println(domains);
	}

}
