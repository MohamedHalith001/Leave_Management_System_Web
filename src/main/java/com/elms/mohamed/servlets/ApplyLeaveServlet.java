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

import com.elms.mohamed.model.LeaveRequest;
import com.elms.mohamed.service.LeaveRequestManager;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String employeename = request.getParameter("employeename");
		String stringId =request.getParameter("employeeid");
		int employeeid;
		LocalDate fromDate,toDate;
		String reason = request.getParameter("reason");
		LeaveRequest leaveRequest = new LeaveRequest();
		try {
			fromDate = LocalDate.parse(request.getParameter("fromdate"));
			toDate = LocalDate.parse(request.getParameter("todate"));
			leaveRequest.setName(employeename);
			employeeid = Integer.parseInt(stringId);
			leaveRequest.setId(employeeid);
			leaveRequest.setFromDate(fromDate);
			leaveRequest.setToDate(toDate);
			leaveRequest.setReason(reason);
			LeaveRequestManager.addRequest(leaveRequest);
			output.println("Leave request Applied Successfully");
		} catch (Exception e) {
			output.println(e.getMessage());
		}finally {
			RequestDispatcher dispatch = request.getRequestDispatcher("employeepage.jsp");
			dispatch.include(request, response);
		}
	}
}
