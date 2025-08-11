<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Portal</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f8;
        margin: 40px;
        color: #333;
    }
    h1 {
        color: #1976d2;
        margin-bottom: 20px;
   
    }
    .info-box {
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.07);
        padding: 24px;
        max-width: 400px;
        margin: 0 auto;
    }
    .info-box p {
        font-size: 1.1em;
        margin: 12px 0;
    }
    .grade {
        font-weight: bold;
        color: #388e3c;
    }
</style>
</head>
<body>
    <h1><%= "Welcome to Student Portal" %></h1>
    <div class="info-box">
        <p>Current Date & Time: <%= new java.util.Date() %></p>
        <%! 
            String studentName = "Priyank Fichadiya";
            String course = "Java Programming";
            int marks = 95;
        %>
        <%
            String grade;
            if(marks >= 90) {
                grade = "A";
            } else if(marks >= 75) {
                grade = "B";
            } else if(marks >= 50) {
                grade = "C";
            } else {
                grade = "F";
            }
        %>
        <p>Student Name: <%= studentName %></p>
        <p>Course: <%= course %></p>
        <p>Marks: <%= marks %></p>
        <p class="grade">Grade: <%= grade %></p>
    </div>
</body>
</html>