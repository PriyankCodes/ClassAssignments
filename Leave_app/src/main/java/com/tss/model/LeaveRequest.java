package com.tss.model;

import java.sql.Date;

public class LeaveRequest {
	private int requestId;
	private int userId;
	private Date startDate;
	private Date endDate;
	private String reason;
	private String status; // PENDING, APPROVED, REJECTED
	private String approvedBy; // display name (set via JOIN)
	private String userName; // display name (set via JOIN)
	private String decisionComment; // admin comment on approve/reject

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getDecisionComment() {
		return decisionComment;
	}

	public void setDecisionComment(String decisionComment) {
		this.decisionComment = decisionComment;
	}

	public int getDaysCount() {
		long diff = endDate.getTime() - startDate.getTime();
		return (int) (diff / (1000L * 60 * 60 * 24)) + 1;
	}
}
