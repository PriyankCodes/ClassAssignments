<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>All Employees</title>
</head>
<body>
    <h2>All Employees</h2>
    
   <c:if test="${not empty employees}">
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>Name</th><th>Salary</th></tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty employees}">
    <p>No employees found.</p>
</c:if>

</body>
</html>
