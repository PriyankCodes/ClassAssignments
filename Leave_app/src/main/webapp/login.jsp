<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login - Leave Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: linear-gradient(135deg, #ffffff, #f0f4ff);
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	color: #333;
}

.card {
	border-radius: 12px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.05);
	animation: fadeIn 0.6s ease-in-out;
}

@
keyframes fadeIn {
	from {opacity: 0;
	transform: translateY(20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
h3 {
	color: #224abe;
	font-weight: 600;
}

.btn-primary {
	background: linear-gradient(45deg, #4e73df, #224abe);
	border: none;
}

.btn-primary:hover {
	background: linear-gradient(45deg, #5a82f0, #2b55d4);
}

a {
	color: #28a745;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	color: #1e7e34;
}

.alert-danger {
	background: #fdd;
	color: #a00;
	border: none;
	border-radius: 6px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-md-5">
				<div class="card p-4">
					<h3 class="mb-3">Login</h3>
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
					<form action="LoginController" method="post">
						<div class="mb-3">
							<label class="form-label">Username</label> <input
								class="form-control" name="username" required>
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="password" required>
						</div>
						<button class="btn btn-primary w-100">Login</button>
					</form>
				</div>
				<p class="text-center text-muted mt-3">Login as admin or
					employee</p>
				<p class="text-center text-muted">
					Don't have an account? <a href="register.jsp">Register here</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
