<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply for Leave</title>
</head>
<body>
<%
RequestDispatcher dispatch = request.getRequestDispatcher("employeepage.jsp");
dispatch.include(request, response);
%>
<form action="ApplyLeaveServlet" method="POST">
<label>Employee Name</label>
<input type="text" name="employeename" id="employeename" autofocus>
<label>Employee Id</label>
<input type="number" name="employeeid" id="employeeid">
<label>From Date</label>
<input type="date" name="fromdate" id="fromdate">
<label>To Date</label>
<input type="date" name="todate" id="todate">
<label>Reason</label>
<input type="text" name="reason" id="reason">
<input type="submit"> 
</form>
</body>
</html>