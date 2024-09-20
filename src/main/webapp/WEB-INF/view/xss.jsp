<html>
<head>

<title>Secure Exam Generation</title>
</head>
<body>

	<h2>XSS page - add an input form and display text</h2>
	<form method="get" action="${pageContext.request.contextPath}/postxss">
		<input type="text" id="payload" name="payload" placeholder="put your payload here"><br>
		<input type="submit" value="Submit">
	</form>
	<hr>
	<p>${payload}</p>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>

</body>
</html>
>
