<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>

	<c:out value="25" />

	<c:set var="name" value="Priyank" />

	<c:out value="${name}" />

	<c:if test="${name == 'Priyank'}">
		<p>Good Morning Priyank</p>
	</c:if>

	<c:choose>
		<c:when test="${name == 'Priyank'}">
			<p>Hello Priyank</p>
		</c:when>
		<c:otherwise>
			<p>Hello Guest</p>
		</c:otherwise>
	</c:choose>

	<%-- <c:set var="names" value="${['Priyank','Devang','Vivek']}" />

	<ul>
		<c:forEach var="name" items="${names}">
			<li>${name}</li>
		</c:forEach>
	</ul>
--%>
	<c:url var="googleUrl" value="https://www.google.com" />
	<p>
		Go to: <a href="${googleUrl}" x->${googleUrl}</a>
	</p>


</body>
</html>
