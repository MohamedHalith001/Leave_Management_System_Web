<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<nav>
<a href="applyleave.jsp">Apply for Leave</a>
<a href="cancelleave.jsp">Cancel a Request</a>
<a href="viewrequest.jsp">View Request Status</a>
</nav>
<button id="logoutbtn">Logout</button>
<script type="text/javascript">
logoutbtn = document.getElementById("logoutbtn");
logoutbtn.addEventListener('click',function(){
	window.location.replace("LogoutServlet");
});
</script>
</body>
</html>