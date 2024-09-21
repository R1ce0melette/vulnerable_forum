<html>
<head>

<title>Dhllinc's VulnSpring</title>
</head>
<body>

	<h2>File upload - not sure yet</h2>
	<form method="POST" action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data">
		<label>Select a file to upload:</label> <input type="file" name="file" />
		<button type="submit">Upload</button>
	</form>
	<br>
	<b>${message}</b>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>

</body>
</html>