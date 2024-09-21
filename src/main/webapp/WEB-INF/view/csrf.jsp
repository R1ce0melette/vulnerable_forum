<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dhllinc's VulnSpring</title>
</head>
<body>
<h2> CSRF - update database with Get request</h2>
	<p>Only authorised user can access this page and change secret?</p>
	<hr>
	<form method="GET" action="${pageContext.request.contextPath}/docsrf">
		<input type="text" name="input">
		<input type="submit" value="Go">
	</form>
	<p>${secret2}</p>
	<hr>
	<a href ="${pageContext.request.contextPath}/post-login"> Back to Home Page </a> 
</body>
</html>