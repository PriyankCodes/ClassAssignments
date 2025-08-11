<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>

<jsp:useBean id="student" class="com.tss.model.Student" scope="request" />
<jsp:setProperty name="student" property="name" param="name" />
<jsp:setProperty name="student" property="marks" param="marks" />

<!DOCTYPE html>
<html>
<head>
<title>JSP Actions Demo</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f9f9f9;
	color: #222;
	margin: 0;
	padding: 40px 0;
}

.container {
	background: #fff;
	border-radius: 6px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
	max-width: 350px;
	margin: 0 auto;
	padding: 24px 20px;
}

h2 {
	text-align: center;
	color: #1565c0;
	margin-bottom: 20px;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin: 8px 0 16px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	background: #1565c0;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 4px;
	font-size: 1em;
	cursor: pointer;
}

input[type="submit"]:hover {
	background: #0d47a1;
}

.section {
	margin-top: 20px;
}

p {
	margin: 8px 0;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Student Info Demo</h2>
			<form action="Demo.jsp" method="post">
				<input type="text" name="name" placeholder="Name" required> 
				<input type="text" name="marks" placeholder="Marks" required> 
				<input type="submit" value="Submit">
			</form>


		<div class="section">
			<b>Included Section</b>
			<p>
				Name (getProperty):
				<jsp:getProperty name="student" property="name" /></p>
			<p>
				Marks (getProperty):
				<jsp:getProperty name="student" property="marks" /></p>

			<p>Name (param): ${param.name}</p>
			<p>Marks (param): ${param.marks}</p>
		</div>

		<%
		if (request.getParameter("name") != null && request.getParameter("marks") != null) {
		%>
		<div class="section">
			<b>Forwarded Section</b>
			<p>This is the forwarded page.</p>
			<p>
				Name:
				<jsp:getProperty name="student" property="name" /></p>
			<p>
				Marks:
				<jsp:getProperty name="student" property="marks" /></p>
		</div>
		<%
		}
		%>
	</div>
</body>