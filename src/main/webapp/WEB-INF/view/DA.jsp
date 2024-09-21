<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dhlinc's VulnSpring</title>
</head>
<body>
	<h2>Data aggregation - Blind SQLi</h2>
	<h3>Find user information</h3>
	<form method="get" action="${pageContext.request.contextPath}/doDA">
		<input type="text" id="username" name="username"
			placeholder="username"> <br> <input type="submit"
			value="Submit">
	</form>
	<h3>${username}</h3>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>
</body>
</html>