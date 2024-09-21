<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dhlinc's VulnSpring</title>
</head>
<body>
<h2> SSRF - host a python http server and send request from this app</h2>
	<p>Click to get some advices</p>
	<hr>
	<form method="GET" action="${pageContext.request.contextPath}/dossrf">
		<input type="hidden" name="url" value="http://localhost:8000/advice.txt">
		<input type="submit" value="Go">
	</form>
	<p>${response}</p>
	<hr>
	
	<a href ="${pageContext.request.contextPath}/post-login"> Back to Home Page </a> 
</body>
</html>