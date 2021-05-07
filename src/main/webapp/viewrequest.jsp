<%@page import="java.util.ArrayList"%>
<%@page import="com.elms.mohamed.source.LeaveRequest"%>
<%@page import="com.elms.mohamed.source.LeaveRequestManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Requests</title>
</head>
<body>
<table border="2">
<thead>
<tr><th>S.No</th><th>Emp. Id</th><th>Name</th><th>From </th><th>To</th><th>Reason</th><th>Status</th></tr>
</thead>
<tbody>
<%
RequestDispatcher dispatch = request.getRequestDispatcher("employeepage.jsp");
dispatch.include(request, response);
ArrayList<LeaveRequest> requestList = LeaveRequestManager.getRequestList();
for(LeaveRequest leaveRequest : requestList){

%>
<tr>
<td><%=leaveRequest.getLeaveId() %></td>
<td><%=leaveRequest.getId() %></td>
<td><%=leaveRequest.getName() %></td>
<td><%=leaveRequest.getFromDate() %></td>
<td><%=leaveRequest.getToDate() %></td>
<td><%=leaveRequest.getReason() %></td>
<td><%=leaveRequest.getStatus() %></td>
</tr>
<% } %>
</tbody>
</table>
</body>
</html>