package com.tss.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

import com.tss.dao.BankDAO;
import com.tss.model.Account;

public class BankService {

	private BankDAO dao = new BankDAO();

	public String transferFunds(Connection conn, int senderId, int receiverId, double amount) throws SQLException {
		conn.setAutoCommit(false);
		Account sender = dao.getAccountById(conn, senderId);
		Account receiver = dao.getAccountById(conn, receiverId);

		if (sender == null || receiver == null)
			return "One of the accounts does not exist.";
		if (amount <= 0)
			return "Transfer amount must be positive.";
		if (sender.getBalance() < amount)
			return "Insufficient balance.";

		dao.updateBalance(conn, senderId, sender.getBalance() - amount);
		Savepoint savePoint = conn.setSavepoint();

		try {
			dao.updateBalance(conn, receiverId, receiver.getBalance() + amount);
			conn.commit();
			return "Transfer successful.";
		} catch (SQLException e) {
			conn.rollback(savePoint);
			conn.commit(); 
			
			return "Credit failed. Debit retained. Manual correction needed.";
		}
	}

	public void showAllAccounts() throws Exception {
		List<Account> accounts = dao.getAllAccounts();
		if (accounts.isEmpty()) {
			System.out.println("No accounts found.");
		} else {
			System.out.printf("\n%-10s %-20s %-10s\n", "ID", "Name", "Balance");
			for (Account acc : accounts) {
				System.out.printf("%-10d %-20s ₹%-10.2f\n", acc.getId(), acc.getName(), acc.getBalance());
			}
		}
	}

}
