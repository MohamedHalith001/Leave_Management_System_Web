<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="LoginServlet" method="POST">
		<label>User Name</label> 
		<input type="text" name="username" placeholder="Enter username"
			 id="username" required autofocus><br/>
		<label>Password</label> 
		<input type="password" pattern="[a-zA-z0-9]{8,}" name="password" id="password"
			placeholder="Enter password" required><br/>
		<label for="user">Admin</label>
		<input type="radio" value="admin" name="user" required> <br/>
		<label for="user">Employee</label> 
		<input type="radio" value="employee" name="user" required><br/>
		<button type="submit">Login</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>