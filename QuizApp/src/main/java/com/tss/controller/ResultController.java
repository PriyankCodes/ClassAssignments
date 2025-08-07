package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.ResultDao;
import com.tss.model.Question;
import com.tss.service.QuestionService;

@WebServlet("/ResultController")
public class ResultController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionService questionService = new QuestionService();
        HttpSession session = request.getSession();

        int totalQuestions = 10;
        int score = 0;
        List<String> userAnswers = new ArrayList<>();

        String username = "Guest";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    username = c.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Quiz Result</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<div class='card shadow p-4'>");
        out.println("<h3 class='mb-3'>Quiz Result</h3>");
        out.println("<p><strong>User:</strong> " + username + "</p>");

        for (int i = 1; i <= totalQuestions; i++) {
            String selectedAnswer = (String) session.getAttribute("q" + i);
            userAnswers.add(selectedAnswer);

            Question q = questionService.getQuestionById(i);
            if (q != null && selectedAnswer != null && selectedAnswer.equals(q.getCorrectOption())) {
                score++;
            }
        }
        ResultDao resultDao = new ResultDao();
        resultDao.saveResult(username, score, totalQuestions);
        out.println("<p><strong>Score:</strong> " + score + " out of " + totalQuestions + "</p>");
        out.println("<hr>");
        out.println("<h5 class='mt-4'>Your Answers:</h5>");
        out.println("<ul class='list-group'>");

        for (int i = 0; i < totalQuestions; i++) {
            Question q = questionService.getQuestionById(i + 1);
            String selected = userAnswers.get(i);
            String correct = q.getCorrectOption();

            out.println("<li class='list-group-item'>");
            out.println("<strong>Question " + (i + 1) + ":</strong><br>");
            out.println(q.getQuestionText() + "<br>");

            if (selected != null) {
                String selectedText = getOptionText(q, selected);
                if (selected.equals(correct)) {
                    out.println("<span class='text-success'>Your Answer: <strong>" + selected + "</strong> - " + selectedText + "</span><br>");
                } else {
                    out.println("<span class='text-danger'>Your Answer: <strong>" + selected + "</strong> - " + selectedText + "</span><br>");
                    String correctText = getOptionText(q, correct);
                    out.println("<span class='text-success'>Correct Answer: <strong>" + correct + "</strong> - " + correctText + "</span><br>");
                }
            } else {
                out.println("<span class='text-danger'>Your Answer: Not Answered</span><br>");
                String correctText = getOptionText(q, correct);
                out.println("<span class='text-success'>Correct Answer: <strong>" + correct + "</strong> - " + correctText + "</span><br>");
            }

            out.println("</li>");
        }

        out.println("</ul>");

        out.println("<div class='mt-4'>");
        out.println("<a href='QuestionController?page=1' class='btn btn-success'>Try Again</a>");
        out.println(" <a href='LogoutController' class='btn btn-danger'>Logout</a>");
        out.println("</div>");

        out.println("</div></div>");
        out.println("</body></html>");
    }

    private String getOptionText(Question q, String option) {
        if (q == null || option == null) return "";
        switch (option) {
            case "A": return q.getOptionA();
            case "B": return q.getOptionB();
            case "C": return q.getOptionC();
            case "D": return q.getOptionD();
            default: return "";
        }
    }
}
