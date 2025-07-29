package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.database.DBConnection;
import com.tss.model.Account;

public class BankDAO {

	public Account getAccountById(Connection conn, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
		}
		return null;
	}

	public void updateBalance(Connection conn, int id, double newBalance) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = ? WHERE id = ?");
		ps.setDouble(1, newBalance);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

	public List<Account> getAllAccounts() throws Exception {
	    List<Account> accounts = new ArrayList<>();
	    String sql = "SELECT * FROM accounts";
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Account acc = new Account();
	            acc.setId(rs.getInt("id"));
	            acc.setName(rs.getString("name"));
	            acc.setBalance(rs.getDouble("balance"));
	            accounts.add(acc);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error retrieving accounts: " + e.getMessage());
	    }

	    return accounts;
	}


}
