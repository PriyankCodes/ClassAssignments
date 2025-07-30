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

	public void updateBalance(Connection connection, int id, double newBalance) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE accounts SET balance = ? WHERE id = ?");
		preparedStatement.setDouble(1, newBalance);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
	}

	public List<Account> getAllAccounts() throws Exception {
	    List<Account> accounts = new ArrayList<>();
	    String sql = "SELECT * FROM accounts";
	    
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            Account account = new Account();
	            account.setId(resultSet.getInt("id"));
	            account.setName(resultSet.getString("name"));
	            account.setBalance(resultSet.getDouble("balance"));
	            accounts.add(account);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error retrieving accounts: " + e.getMessage());
	    }

	    return accounts;
	}


}
