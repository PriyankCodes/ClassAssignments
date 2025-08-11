<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%
    String errorMsg = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body { background: #f8f9fa; }
    .container { max-width: 400px; margin: 60px auto; background: #fff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.07); padding: 32px 24px; }
    h3 { color: #d32f2f; }
    .btn-back { margin-top: 20px; }
</style>
</head>
<body>
    <div class="container text-center">
        <h3>Error: Feedback Not Submitted</h3>
        <p><%= (errorMsg != null) ? errorMsg : exception %></p>
        <a href="FeedbackForm.jsp" class="btn btn-primary btn-back">Back to Form</a>
    </div>
</body>
</html>
