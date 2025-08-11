package com.tss.service;

import com.tss.dao.FeedbackDao;
import com.tss.exception.FeedbackException;
import com.tss.model.Feedback;

public class FeedbackService {
    private FeedbackDao dao = new FeedbackDao();

    public boolean submitFeedback(Feedback feedback) throws FeedbackException {
        if (feedback.getName() == null || feedback.getName().isEmpty()) {
            throw new FeedbackException("Name is required");
        }
        if (feedback.getSessionDate() == null || feedback.getSessionDate().isEmpty()) {
            throw new FeedbackException("Session Date is required");
        }
        return dao.saveFeedback(feedback);
    }
}
