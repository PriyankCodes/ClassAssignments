package com.tss.service;

import com.tss.dao.LeaveDao;
import com.tss.model.LeaveBalance;
import com.tss.model.LeaveRequest;

import java.sql.Date;
import java.util.List;

public class LeaveService {
    private LeaveDao leaveDao = new LeaveDao();

    public LeaveBalance getBalance(int userId) {
        return leaveDao.getLeaveBalance(userId);
    }

    public List<LeaveRequest> getHistory(int userId) {
        return leaveDao.getLeaveHistory(userId);
    }

    public List<LeaveRequest> getHistoryByDate(int userId, Date start, Date end) {
        return leaveDao.getLeaveHistoryByDate(userId, start, end);
    }

    public boolean apply(LeaveRequest lr) {
        return leaveDao.applyLeave(lr);
    }

    public boolean updatePendingLeave(LeaveRequest lr) {
        return leaveDao.updatePendingLeave(lr);
    }

    public int getMonthlyLeaveDays(int userId, int year, int month) {
        return leaveDao.getMonthlyLeaveDays(userId, year, month);
    }

    public int getMonthlyLeaveDaysExcluding(int userId, int year, int month, int excludeRequestId) {
        return leaveDao.getMonthlyLeaveDaysExcluding(userId, year, month, excludeRequestId);
    }

    public boolean hasOverlap(int userId, Date start, Date end) {
        return leaveDao.hasOverlap(userId, start, end);
    }

    public boolean hasOverlapExcluding(int userId, Date start, Date end, int excludeRequestId) {
        return leaveDao.hasOverlapExcluding(userId, start, end, excludeRequestId);
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveDao.getAllLeaveRequests();
    }

    public List<LeaveRequest> getAllRequestsFiltered(Date start, Date end, String status) {
        return leaveDao.getAllLeaveRequestsFiltered(start, end, status);
    }

    public boolean updateStatus(int requestId, String status, int adminId, String comment) {
        return leaveDao.updateLeaveStatus(requestId, status, adminId, comment);
    }
}
