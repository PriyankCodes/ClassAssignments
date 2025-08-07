package com.tss.service;

import com.tss.dao.QuestionDao;
import com.tss.model.Question;

public class QuestionService {

	private QuestionDao questionDao;

	public QuestionService() {
		questionDao = new QuestionDao();
	}

	public Question getQuestionById(int id) {
		return questionDao.getQuestionById(id);
	}
}
