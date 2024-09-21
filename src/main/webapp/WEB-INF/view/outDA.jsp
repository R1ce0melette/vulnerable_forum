<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.deakin.sit218.examgeneration.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	width: 50%;
	border-collapse: collapse;
	margin: 50px 0;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>User List</h2>
<table>
	<tbody>
	<%
            // Retrieve the List<User> from the model (assuming it's passed with the name "username")
            List<User> userList = (List<User>) request.getAttribute("username");
	
            // Recursive function logic implemented inline
            int index = 0;
            while (userList != null && index < userList.size()) {
                User user = userList.get(index);
        %>
                <tr>
                    <td><%= user.getUser_id() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getPassword() %></td>
                    <td><%= user.getSecret()%></td>
                </tr>
        <%
                index++; // Increment the index to move to the next user
            }
            if (userList == null || userList.isEmpty()) {
        %>
                <tr>
                    <td colspan="4">No users found</td>
                </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>