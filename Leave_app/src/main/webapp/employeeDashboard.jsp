<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.table thead {
	background: #f8f9fa;
}
</style>
</head>
<body>
	<%
	java.time.LocalDate today = java.time.LocalDate.now();
	%>

	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Welcome, ${user.name}</a>
			<form class="d-flex">
				<a href="login.jsp" class="btn btn-sm btn-outline-dark">Logout</a>
			</form>
		</div>
	</nav>

	<div class="container mt-4">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<div class="row">
			<!-- LEFT SIDE -->
			<div class="col-md-4">
				<div class="card p-3 mb-3">
					<h5>Leave Balance</h5>
					<p>
						Total: <strong>${balance.totalLeaves}</strong>
					</p>
					<p>
						Taken: <strong>${balance.leavesTaken}</strong>
					</p>
					<p>
						Remaining: <strong>${balance.totalLeaves - balance.leavesTaken}</strong>
					</p>
				</div>

				<div class="card p-3 mb-3">
					<h5>Leave Form</h5>
					<form action="EmployeeController" method="post">
						<input type="hidden" name="action" id="actionInput" value="apply" />
						<input type="hidden" name="request_id" id="requestIdInput" />

						<div class="mb-2">
							<label class="form-label">Start Date</label> <input type="date"
								name="start_date" class="form-control" id="startDateInput"
								min="<%=today%>" required
								onchange="calcDays(this.form,'update')">
						</div>
						<div class="mb-2">
							<label class="form-label">End Date</label> <input type="date"
								name="end_date" class="form-control" id="endDateInput"
								min="<%=today%>" required
								onchange="calcDays(this.form,'update')">
						</div>
						<div class="mb-2">
							<label class="form-label">Total Days</label> <input type="text"
								id="totalDaysInput" class="form-control" readonly>
						</div>

						<div class="mb-2">
							<label class="form-label">Reason</label>
							<textarea name="reason" class="form-control" id="reasonInput"
								required></textarea>
						</div>
						<button type="submit" class="btn btn-primary w-100" id="applyBtn">Apply
							Leave</button>
						<button type="button" class="btn btn-secondary w-100 mt-2"
							onclick="resetForm()">Reset Form</button>
					</form>
				</div>
			</div>

			<!-- RIGHT SIDE -->
			<div class="col-md-8">
				<h5>Your Leave History</h5>
				<!-- Date Filter -->
				<form method="get" action="EmployeeController" class="mb-3">
					<div class="row g-2">
						<div class="col-md-4">
							<input type="date" name="start_date" class="form-control" />
						</div>
						<div class="col-md-4">
							<input type="date" name="end_date" class="form-control" />
						</div>
						<div class="col-md-4">
							<button class="btn btn-secondary w-100">Filter</button>
						</div>
					</div>
				</form>

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Start</th>
							<th>End</th>
							<th>Days</th>
							<th>Reason</th>
							<th>Status</th>
							<th>Admin Comment</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty history}">
								<tr>
									<td colspan="8" class="text-center">No data available</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="h" items="${history}">
									<tr>
										<td>${h.requestId}</td>
										<td>${h.startDate}</td>
										<td>${h.endDate}</td>
										<td>${h.daysCount}</td>
										<td>${h.reason}</td>
										<td><c:choose>
												<c:when test="${h.status == 'APPROVED'}">
													<span class="text-success">${h.status}</span>
												</c:when>
												<c:when test="${h.status == 'REJECTED'}">
													<span class="text-danger">${h.status}</span>
												</c:when>
												<c:otherwise>
													<span class="text-warning">${h.status}</span>
												</c:otherwise>
											</c:choose></td>
										<td>${h.decisionComment}</td>
										<td>
											<button type="button" class="btn btn-warning btn-sm"
												data-id="${h.requestId}" data-start="${h.startDate}"
												data-end="${h.endDate}"
												data-reason="${fn:escapeXml(h.reason)}"
												onclick="fillUpdateFormFromButton(this)"
												<c:if test="${h.status != 'PENDING'}">disabled</c:if>>
												Update</button>
										</td>

									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<script>
	function fillUpdateFormFromButton(button) {
		document.getElementById('actionInput').value = 'update';
		document.getElementById('requestIdInput').value = button
				.getAttribute('data-id');
		document.getElementById('startDateInput').value = button
				.getAttribute('data-start');
		document.getElementById('endDateInput').value = button
				.getAttribute('data-end');
		document.getElementById('reasonInput').value = button
				.getAttribute('data-reason');
		document.getElementById('applyBtn').textContent = 'Update Leave';

		// Scroll to form smoothly
		document.getElementById('startDateInput').scrollIntoView({
			behavior : "smooth"
		});
	}

	// Optional: reset form to Apply Leave
	function resetForm() {
		document.getElementById('actionInput').value = 'apply';
		document.getElementById('requestIdInput').value = '';
		document.getElementById('startDateInput').value = '';
		document.getElementById('endDateInput').value = '';
		document.getElementById('reasonInput').value = '';
		document.getElementById('applyBtn').textContent = 'Apply Leave';
	}

	function calcDays(form, mode) {
		const startInput = document.getElementById('startDateInput');
		const endInput = document.getElementById('endDateInput');
		const totalDaysInput = document.getElementById('totalDaysInput');

		const startDate = new Date(startInput.value);
		const endDate = new Date(endInput.value);

		if (startInput.value && endInput.value) {
			// Calculate difference in milliseconds
			const diffTime = endDate - startDate;
			if (diffTime < 0) {
				totalDaysInput.value = 'Invalid Dates';
			} else {
				// Convert to days (+1 to include both start and end)
				const diffDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1;
				totalDaysInput.value = diffDays;
			}
		} else {
			totalDaysInput.value = '';
		}
	}
</script>
</html>
