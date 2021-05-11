<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply for Leave</title>
</head>
<body>
<jsp:include page="employeepage.jsp"></jsp:include>
<form action="ApplyLeaveServlet" method="POST">
<label>Employee Name</label>
<input type="text" name="employeename" id="employeename" placeholder="Enter employee name"
	 required autofocus>
<label>Employee Id</label>
<input type="number" name="employeeid" id="employeeid" placeholder="Enter employee Id"
	 required>
<label>From Date</label>
<input type="date" name="fromdate" id="fromdate" oninput="mintodate()" 
	placeholder="From date" required>
<label>To Date</label>
<input type="date" name="todate" id="todate" placeholder="To date" required>
<label>Reason</label>
<select name="reason">
<option value="sick">Sick Leave</option>
<option value="casual">Casual Leave</option>
<option value="earn">Earn Leave</option>
</select>
<input type="submit"> 
</form>
</body>
<script type="text/javascript">
let date = new Date().toJSON().substr(0,10);
let mindate = document.getElementById("fromdate");
let todate = document.getElementById("todate");
mindate.setAttribute("value",date);
mindate.setAttribute("min",date);
todate.setAttribute("value",date);
function mintodate(){
	let day = (mindate.value);
	todate.setAttribute("min",day);
	todate.setAttribute("value",day);
	}
</script>
</html>