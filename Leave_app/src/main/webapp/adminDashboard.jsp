<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* keep your existing styles, trimmed for brevity */
.table thead {
	background: #f8f9fa;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Welcome, ${user.name}</a>
			<form class="d-flex">
				<a href="login.jsp" class="btn btn-sm btn-outline-dark">Logout</a>
			</form>
		</div>
	</nav>

	<div class="container mt-4">
		<h3>All Leave Requests</h3>

		<!-- Filters -->
		<form method="get" action="AdminController" class="mb-3">
			<div class="row g-2">
				<div class="col-md-3">
					<input type="date" name="start_date" class="form-control">
				</div>
				<div class="col-md-3">
					<input type="date" name="end_date" class="form-control">
				</div>
				<div class="col-md-3">
					<select name="status" class="form-select">
						<option value="">All</option>
						<option value="PENDING">Pending</option>
						<option value="APPROVED">Approved</option>
						<option value="REJECTED">Rejected</option>
					</select>
				</div>
				<div class="col-md-3">
					<button class="btn btn-secondary w-100">Filter</button>
				</div>
			</div>
		</form>

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>User Name</th>
					<th>Start</th>
					<th>End</th>
					<th>Days</th>
					<th>Reason</th>
					<th>Status</th>
					<th>Action By</th>
					<th>Comment</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty allLeaves}">
						<tr>
							<td colspan="10" class="text-center">No data available</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="lr" items="${allLeaves}">
							<tr>
								<td>${lr.requestId}</td>
								<td>${lr.userName}</td>
								<td>${lr.startDate}</td>
								<td>${lr.endDate}</td>
								<td>${lr.daysCount}</td>
								<td>${lr.reason}</td>
								<td><c:choose>
										<c:when test="${lr.status == 'APPROVED'}">
											<span class="text-success">${lr.status}</span>
										</c:when>
										<c:when test="${lr.status == 'REJECTED'}">
											<span class="text-danger">${lr.status}</span>
										</c:when>
										<c:otherwise>
											<span class="text-warning">${lr.status}</span>
										</c:otherwise>
									</c:choose></td>
								<td>${lr.approvedBy}</td>
								<td>${lr.decisionComment}</td>
								<td>
									<form action="AdminController" method="post"
										class="d-flex gap-1">
										<input type="hidden" name="id" value="${lr.requestId}" /> <input
											type="text" name="comment"
											class="form-control form-control-sm"
											placeholder="Add comment" required />
										<button name="action" value="approve"
											class="btn btn-sm btn-success"
											${lr.status != 'PENDING' ? 'disabled' : ''}>Approve</button>
										<button name="action" value="reject"
											class="btn btn-sm btn-danger"
											${lr.status != 'PENDING' ? 'disabled' : ''}>Reject</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>
