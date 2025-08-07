package com.tss.controller;

import com.tss.model.Question;
import com.tss.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuestionService questionService;

	@Override
	public void init() throws ServletException {
		questionService = new QuestionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int page = Integer.parseInt(request.getParameter("page")); 
		Question question = questionService.getQuestionById(page);

		if (question == null) {
			out.println("<h2>Question not found!</h2>");
			return;
		}

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Java Quiz</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body class='bg-light'>");
		out.println("<div class='container mt-5'>");
		out.println("<div class='card p-4 shadow-sm'>");
		out.println("<h4>Question " + page + "</h4>");
		out.println("<form method='post' action='QuestionController'>");
		out.println("<p>" + question.getQuestionText() + "</p>");
		out.println("<div class='form-check'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionA' value='A' required>");
		out.println("<label class='form-check-label' for='optionA'>" + question.getOptionA() + "</label>");
		out.println("</div>");

		out.println("<div class='form-check'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionB' value='B'>");
		out.println("<label class='form-check-label' for='optionB'>" + question.getOptionB() + "</label>");
		out.println("</div>");

		out.println("<div class='form-check'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionC' value='C'>");
		out.println("<label class='form-check-label' for='optionC'>" + question.getOptionC() + "</label>");
		out.println("</div>");

		out.println("<div class='form-check'>");
		out.println("<input class='form-check-input' type='radio' name='answer' id='optionD' value='D'>");
		out.println("<label class='form-check-label' for='optionD'>" + question.getOptionD() + "</label>");
		out.println("</div><br>");

		out.println("<input type='hidden' name='page' value='" + page + "'>");
		out.println("<button type='submit' class='btn btn-primary'>Submit</button>");
		out.println("</form>");
		out.println("</div></div></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int page = Integer.parseInt(request.getParameter("page"));
		String answer = request.getParameter("answer"); 

	
		session.setAttribute("q" + page, answer);

		int nextPage = page + 1;

		if (nextPage <= 10) {
			response.sendRedirect("QuestionController?page=" + nextPage);
		} else {
			response.sendRedirect("ResultController");
		}
	}
}
