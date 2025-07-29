package com.tss.controller;

import com.tss.database.DBConnection;
import com.tss.service.BankService;

import java.sql.Connection;
import java.util.Scanner;

public class BankController {

	private BankService service = new BankService();

	public void startTransferFlow() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Sender's Account ID: ");
		int senderId = scanner.nextInt();

		System.out.print("Enter Receiver's Account ID: ");
		int receiverId = scanner.nextInt();

		System.out.print("Enter Amount to Transfer: ");
		double amount = scanner.nextDouble();

		try (Connection conn = DBConnection.getConnection()) {
			String result = service.transferFunds(conn, senderId, receiverId, amount);

			System.out.println(result);
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void viewAllAccounts() throws Exception {
		service.showAllAccounts();
	}

}
