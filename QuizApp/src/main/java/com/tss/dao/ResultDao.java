package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResultDao {
	public void saveResult(String username, int score, int totalQuestions) {
		try (Connection conn = com.tss.util.DBConnection.getConnection()) {
			String sql = "INSERT INTO results (username, score, total_questions) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setInt(2, score);
			stmt.setInt(3, totalQuestions);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
