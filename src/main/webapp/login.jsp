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
<input type="text" name="username" required autofocus id="username">
<label>Password</label>
<input type="password" pattern="[a-zA-z0-9]{8,}" name="password" required id="password">
<input type="submit" value="Login">
</form>
</body>
</html>