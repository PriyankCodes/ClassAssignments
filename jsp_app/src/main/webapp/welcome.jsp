<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learning JSP</title>
</head>
<body>
<!--write here form code-->

	<b>Welcome to JSP App</b>

	<!-- scriptlet Tag -->
	<%
	int number1 = 10;
	int number2 = 20;

	java.util.Date date = new java.util.Date();
	%>

	<!-- Expression Tag -->
	<h1><%=number1 + number2%></h1>

	<h2><%=date%></h2>

	<!-- Declaration Tag -->
	<%!double pi = 3.14;%>
	<i>PI = <%= pi %></i>
	
	<!-- Comment Tag -->
	<%-- Not compiled this comment --%>
	
	<!--  Directives
			1. Page
			2. Include
			3. Taglib	
	 -->
	 
	 <%@ include file="New.jsp" %>

</body>
</html>