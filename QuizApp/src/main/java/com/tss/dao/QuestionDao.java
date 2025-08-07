package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tss.model.Question;
import com.tss.util.DBConnection;

public class QuestionDao {

	public Question getQuestionById(int id) {
		Question question = null;

		try (Connection conn = DBConnection.getConnection()) {
			String sql = "SELECT * FROM questions WHERE question_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionText(rs.getString("question_text"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_d"));
				question.setCorrectOption(rs.getString("correct_option"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return question;
	}
}
