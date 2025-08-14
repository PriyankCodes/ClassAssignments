package com.tss.controller;

import com.tss.model.LeaveBalance;
import com.tss.model.LeaveRequest;
import com.tss.model.User;
import com.tss.service.LeaveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private LeaveService leaveService = new LeaveService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		User user = (User) session.getAttribute("user");
		if (user == null || !"EMPLOYEE".equalsIgnoreCase(user.getRole())) {
			response.sendRedirect("login.jsp");
			return;
		}

		String startFilter = request.getParameter("start_date");
		String endFilter = request.getParameter("end_date");

		LeaveBalance balance = leaveService.getBalance(user.getUserId());
		List<LeaveRequest> history;
		if (startFilter != null && !startFilter.isEmpty() && endFilter != null && !endFilter.isEmpty()) {
			history = leaveService.getHistoryByDate(user.getUserId(), Date.valueOf(startFilter),
					Date.valueOf(endFilter));
		} else {
			history = leaveService.getHistory(user.getUserId());
		}

		request.setAttribute("balance", balance);
		request.setAttribute("history", history);
		request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		User user = (User) session.getAttribute("user");
		if (user == null || !"EMPLOYEE".equalsIgnoreCase(user.getRole())) {
			response.sendRedirect("login.jsp");
			return;
		}

		String action = request.getParameter("action");

		if ("update".equalsIgnoreCase(action)) {
			try {
				int requestId = Integer.parseInt(request.getParameter("request_id"));
				Date sd = Date.valueOf(request.getParameter("start_date"));
				Date ed = Date.valueOf(request.getParameter("end_date"));
				String reason = request.getParameter("reason");

				if (sd.after(ed)) {
					request.setAttribute("error", "Start date cannot be later than end date.");
					doGet(request, response);
					return;
				}

				if (leaveService.hasOverlapExcluding(user.getUserId(), sd, ed, requestId)) {
					request.setAttribute("error", "Dates overlap an existing leave (pending/approved).");
					doGet(request, response);
					return;
				}

				int year = sd.toLocalDate().getYear();
				int month = sd.toLocalDate().getMonthValue();
				int daysNew = (int) ((ed.getTime() - sd.getTime()) / (1000L * 60 * 60 * 24)) + 1;
				int daysOthers = leaveService.getMonthlyLeaveDaysExcluding(user.getUserId(), year, month, requestId);
				if (daysOthers + daysNew > 3) {
					request.setAttribute("error", "Monthly limit is 3 leave days. Update exceeds the limit.");
					doGet(request, response);
					return;
				}

				LeaveRequest lr = new LeaveRequest();
				lr.setRequestId(requestId);
				lr.setUserId(user.getUserId());
				lr.setStartDate(sd);
				lr.setEndDate(ed);
				lr.setReason(reason);

				if (!leaveService.updatePendingLeave(lr)) {
					request.setAttribute("error", "Unable to update. Leave might not be in PENDING state.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Invalid update request.");
			}
			response.sendRedirect("EmployeeController");
			return;
		}

		try {
			Date sd = Date.valueOf(request.getParameter("start_date"));
			Date ed = Date.valueOf(request.getParameter("end_date"));
			String reason = request.getParameter("reason");

			LeaveBalance balance = leaveService.getBalance(user.getUserId());
			List<LeaveRequest> history = leaveService.getHistory(user.getUserId());

			if (sd.after(ed)) {
				request.setAttribute("error", "Start date cannot be later than end date.");
				request.setAttribute("balance", balance);
				request.setAttribute("history", history);
				request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
				return;
			}

			// Overlap check
			if (leaveService.hasOverlap(user.getUserId(), sd, ed)) {
				request.setAttribute("error", "You already have a leave (pending/approved) that overlaps these dates.");
				request.setAttribute("balance", balance);
				request.setAttribute("history", history);
				request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
				return;
			}

			// Monthly limit (3 days)
			int year = sd.toLocalDate().getYear();
			int month = sd.toLocalDate().getMonthValue();
			int totalDaysThisReq = (int) ((ed.getTime() - sd.getTime()) / (1000L * 60 * 60 * 24)) + 1;
			int takenThisMonth = leaveService.getMonthlyLeaveDays(user.getUserId(), year, month);
			if (takenThisMonth + totalDaysThisReq > 3) {
				request.setAttribute("error", "You cannot take more than 3 leave days in a month.");
				request.setAttribute("balance", balance);
				request.setAttribute("history", history);
				request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
				return;
			}

			// Remaining balance check
			if (totalDaysThisReq > (balance.getTotalLeaves() - balance.getLeavesTaken())) {
				request.setAttribute("error", "You cannot apply for more than your remaining leave balance.");
				request.setAttribute("balance", balance);
				request.setAttribute("history", history);
				request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
				return;
			}

			LeaveRequest lr = new LeaveRequest();
			lr.setUserId(user.getUserId());
			lr.setStartDate(sd);
			lr.setEndDate(ed);
			lr.setReason(reason);
			lr.setStatus("PENDING");

			leaveService.apply(lr);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Invalid date selection.");
			request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("EmployeeController");
	}
}
