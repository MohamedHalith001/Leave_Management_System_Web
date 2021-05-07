package com.elms.mohamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elms.mohamed.source.LeaveRequest;
import com.elms.mohamed.source.LeaveRequestManager;

/**
 * Servlet implementation class ApplyLeaveServlet
 */
@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String employeename = request.getParameter("employeename");
		int employeeid = Integer.parseInt(request.getParameter("employeeid"));
		LocalDate fromDate = LocalDate.parse(request.getParameter("fromdate"));
		LocalDate toDate = LocalDate.parse(request.getParameter("todate"));
		String reason = request.getParameter("reason");
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setName(employeename);
		leaveRequest.setId(employeeid);
		leaveRequest.setFromDate(fromDate);
		leaveRequest.setToDate(toDate);
		leaveRequest.setReason(reason);
		LeaveRequestManager.addRequest(leaveRequest);
		output.println("Leave request Applied Successfully");
		RequestDispatcher dispatch = request.getRequestDispatcher("employeepage.jsp");
		dispatch.include(request, response);
	}

}
