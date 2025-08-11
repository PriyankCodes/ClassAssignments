package com.tss.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.exception.FeedbackException;
import com.tss.model.Feedback;
import com.tss.service.FeedbackService;

@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private FeedbackService service = new FeedbackService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String name = request.getParameter("name");
			String sessionDate = request.getParameter("sessionDate");
			int sessionContent = Integer.parseInt(request.getParameter("sessionContent"));
			int queryResolution = Integer.parseInt(request.getParameter("queryResolution"));
			int interactivity = Integer.parseInt(request.getParameter("interactivity"));
			int impactfulLearning = Integer.parseInt(request.getParameter("impactfulLearning"));
			int contentDelivery = Integer.parseInt(request.getParameter("contentDelivery"));

			if (sessionContent > 10 || queryResolution > 10 || interactivity > 10 || impactfulLearning > 10
					|| contentDelivery > 10) {
				throw new FeedbackException("Ratings cannot be greater than 10.");
			}
			
			
			 LocalDate localSessionDate = LocalDate.parse(sessionDate);
             if (localSessionDate.isAfter(LocalDate.now())) {
                 throw new FeedbackException("Session date cannot be in the future.");
             }
             
			Feedback feedback = new Feedback();
			feedback.setName(name);
			feedback.setSessionDate(sessionDate);
			feedback.setSessionContent(sessionContent);
			feedback.setQueryResolution(queryResolution);
			feedback.setInteractivity(interactivity);
			feedback.setImpactfulLearning(impactfulLearning);
			feedback.setContentDelivery(contentDelivery);

			HttpSession session = request.getSession();
			if (service.submitFeedback(feedback)) {
				session.setAttribute("name", feedback.getName());
				session.setAttribute("sessionDate", feedback.getSessionDate());
				response.sendRedirect("success.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}

		} catch (FeedbackException e) {
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}
}
