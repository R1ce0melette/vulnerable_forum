<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Dhllinc's VulnSpring</title>
</head>
<body>

	<h2>File upload - not sure yet</h2>
	<form:form action="${pageContext.request.contextPath}/fileUpload"
		method="POST" enctype="multipart/form-data">
		<label>Select a file to upload:</label> <input type="file" name="file" />
		<button type="submit">Go</button>
	</form:form>
	<br>
	<b>${message}</b>
	<hr>

	<a href="${pageContext.request.contextPath}/post-login"> Back to
		Home Page </a>

</body>
</html>