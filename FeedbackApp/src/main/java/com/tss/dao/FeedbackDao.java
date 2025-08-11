package com.tss.dao;

import com.tss.model.Feedback;
import com.tss.util.DBConnection;
import com.tss.exception.FeedbackException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDao {

    public boolean saveFeedback(Feedback feedback) throws FeedbackException {
        String sql = "INSERT INTO feedback (name, session_date, session_content, query_resolution, interactivity, impactful_learning, content_delivery) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, feedback.getName());
            ps.setString(2, feedback.getSessionDate());
            ps.setInt(3, feedback.getSessionContent());
            ps.setInt(4, feedback.getQueryResolution());
            ps.setInt(5, feedback.getInteractivity());
            ps.setInt(6, feedback.getImpactfulLearning());
            ps.setInt(7, feedback.getContentDelivery());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new FeedbackException("Error saving feedback: " + e.getMessage());
        }
    }
}
