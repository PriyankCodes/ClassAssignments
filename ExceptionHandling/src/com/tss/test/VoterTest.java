package com.tss.test;

import com.tss.model.Voter;

public class VoterTest {
	public static void main(String[] args) {
		try {
			Voter voter1 = new Voter("Priyank", 210, 19);
			System.out.println(voter1);

			Voter voter2 = new Voter("Devang", 310, 10);

		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
