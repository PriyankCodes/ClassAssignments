package com.tss.dao;

import com.tss.model.LeaveBalance;
import com.tss.model.LeaveRequest;
import com.tss.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDao {

	public LeaveBalance getLeaveBalance(int userId) {
		String sql = "SELECT * FROM leave_balance WHERE user_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					LeaveBalance lb = new LeaveBalance();
					lb.setBalanceId(rs.getInt("balance_id"));
					lb.setUserId(rs.getInt("user_id"));
					lb.setTotalLeaves(rs.getInt("total_leaves"));
					lb.setLeavesTaken(rs.getInt("leaves_taken"));
					return lb;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LeaveRequest> getLeaveHistory(int userId) {
		List<LeaveRequest> list = new ArrayList<>();
		String sql = "SELECT lr.*, u2.name AS approver_name, lr.decision_comment " + "FROM leave_requests lr "
				+ "LEFT JOIN users u2 ON lr.approved_by = u2.user_id "
				+ "WHERE lr.user_id=? ORDER BY lr.request_id DESC";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequest lr = mapResultSet(rs);
					lr.setApprovedBy(rs.getString("approver_name"));
					lr.setDecisionComment(rs.getString("decision_comment"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LeaveRequest> getLeaveHistoryByDate(int userId, Date start, Date end) {
		List<LeaveRequest> list = new ArrayList<>();
		String sql = "SELECT lr.*, u2.name AS approver_name, lr.decision_comment " + "FROM leave_requests lr "
				+ "LEFT JOIN users u2 ON lr.approved_by = u2.user_id "
				+ "WHERE lr.user_id=? AND lr.start_date >= ? AND lr.end_date <= ? " + "ORDER BY lr.request_id DESC";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setDate(2, start);
			ps.setDate(3, end);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequest lr = mapResultSet(rs);
					lr.setApprovedBy(rs.getString("approver_name"));
					lr.setDecisionComment(rs.getString("decision_comment"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean applyLeave(LeaveRequest lr) {
		String sql = "INSERT INTO leave_requests (user_id, start_date, end_date, reason, status) "
				+ "VALUES (?, ?, ?, ?, 'PENDING')";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, lr.getUserId());
			ps.setDate(2, lr.getStartDate());
			ps.setDate(3, lr.getEndDate());
			ps.setString(4, lr.getReason());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePendingLeave(LeaveRequest lr) {
		String sql = "UPDATE leave_requests SET start_date=?, end_date=?, reason=? "
				+ "WHERE request_id=? AND user_id=? AND status='PENDING'";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, lr.getStartDate());
			ps.setDate(2, lr.getEndDate());
			ps.setString(3, lr.getReason());
			ps.setInt(4, lr.getRequestId());
			ps.setInt(5, lr.getUserId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getMonthlyLeaveDays(int userId, int year, int month) {
		String sql = "SELECT IFNULL(SUM(DATEDIFF(end_date, start_date) + 1), 0) AS days_count " + "FROM leave_requests "
				+ "WHERE user_id = ? AND YEAR(start_date) = ? AND MONTH(start_date) = ? "
				+ "AND status IN ('PENDING', 'APPROVED')";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, year);
			ps.setInt(3, month);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("days_count");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getMonthlyLeaveDaysExcluding(int userId, int year, int month, int excludeRequestId) {
		String sql = "SELECT IFNULL(SUM(DATEDIFF(end_date, start_date) + 1), 0) AS days_count\r\n"
				+ "FROM leave_requests\r\n" + "WHERE user_id = ?\r\n"
				+ "  AND start_date >= ? AND start_date < DATE_ADD(?, INTERVAL 1 MONTH)\r\n"
				+ "  AND status IN ('PENDING','APPROVED')\r\n" + "  AND request_id <> ?;\r\n" + "";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, year);
			ps.setInt(3, month);
			ps.setInt(4, excludeRequestId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return rs.getInt("days_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean hasOverlap(int userId, Date start, Date end) {
		String sql = "SELECT COUNT(*) FROM leave_requests " + "WHERE user_id=? AND status IN ('PENDING','APPROVED') "
				+ "AND NOT (end_date < ? OR start_date > ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setDate(2, start);
			ps.setDate(3, end);
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasOverlapExcluding(int userId, Date start, Date end, int excludeRequestId) {
		String sql = "SELECT COUNT(*) FROM leave_requests " + "WHERE user_id=? AND status IN ('PENDING','APPROVED') "
				+ "AND request_id <> ? " + "AND NOT (end_date < ? OR start_date > ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, excludeRequestId);
			ps.setDate(3, start);
			ps.setDate(4, end);
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<LeaveRequest> getAllLeaveRequests() {
		List<LeaveRequest> list = new ArrayList<>();
		String sql = "SELECT lr.*, u.name AS user_name, a.name AS approver_name " + ", lr.decision_comment "
				+ "FROM leave_requests lr " + "JOIN users u ON lr.user_id = u.user_id "
				+ "LEFT JOIN users a ON lr.approved_by = a.user_id " + "ORDER BY lr.request_id DESC";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				LeaveRequest lr = mapResultSet(rs);
				lr.setUserName(rs.getString("user_name"));
				lr.setApprovedBy(rs.getString("approver_name"));
				lr.setDecisionComment(rs.getString("decision_comment"));
				list.add(lr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LeaveRequest> getAllLeaveRequestsFiltered(Date start, Date end, String status) {
		List<LeaveRequest> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder(
				"SELECT lr.*, u.name AS user_name, a.name AS approver_name, lr.decision_comment "
						+ "FROM leave_requests lr " + "JOIN users u ON lr.user_id = u.user_id "
						+ "LEFT JOIN users a ON lr.approved_by = a.user_id WHERE 1=1 ");

		if (start != null)
			sql.append("AND lr.start_date >= ? ");
		if (end != null)
			sql.append("AND lr.end_date <= ? ");
		if (status != null && !status.isEmpty() && !"ALL".equalsIgnoreCase(status))
			sql.append("AND lr.status = ? ");

		sql.append("ORDER BY lr.request_id DESC");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {

			int i = 1;
			if (start != null)
				ps.setDate(i++, start);
			if (end != null)
				ps.setDate(i++, end);
			if (status != null && !status.isEmpty() && !"ALL".equalsIgnoreCase(status))
				ps.setString(i++, status);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequest lr = mapResultSet(rs);
					lr.setUserName(rs.getString("user_name"));
					lr.setApprovedBy(rs.getString("approver_name"));
					lr.setDecisionComment(rs.getString("decision_comment"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateLeaveStatus(int requestId, String status, int adminId, String comment) {
		String sql = "UPDATE leave_requests SET status=?, approved_by=?, decision_comment=? WHERE request_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, adminId);
			ps.setString(3, comment);
			ps.setInt(4, requestId);
			int updated = ps.executeUpdate();

			if (updated > 0 && "APPROVED".equals(status)) {
				// add approved days into leave_balance
				String fetch = "SELECT user_id, start_date, end_date FROM leave_requests WHERE request_id=?";
				try (PreparedStatement ps2 = conn.prepareStatement(fetch)) {
					ps2.setInt(1, requestId);
					try (ResultSet rs = ps2.executeQuery()) {
						if (rs.next()) {
							int uid = rs.getInt("user_id");
							Date s = rs.getDate("start_date");
							Date e = rs.getDate("end_date");
							int days = (int) ((e.getTime() - s.getTime()) / (1000L * 60 * 60 * 24)) + 1;

							String up = "UPDATE leave_balance SET leaves_taken = leaves_taken + ? WHERE user_id=?";
							try (PreparedStatement ps3 = conn.prepareStatement(up)) {
								ps3.setInt(1, days);
								ps3.setInt(2, uid);
								ps3.executeUpdate();
							}
						}
					}
				}
			}
			return updated > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private LeaveRequest mapResultSet(ResultSet rs) throws SQLException {
		LeaveRequest lr = new LeaveRequest();
		lr.setRequestId(rs.getInt("request_id"));
		lr.setUserId(rs.getInt("user_id"));
		lr.setStartDate(rs.getDate("start_date"));
		lr.setEndDate(rs.getDate("end_date"));
		lr.setReason(rs.getString("reason"));
		lr.setStatus(rs.getString("status"));

		return lr;
	}
}
