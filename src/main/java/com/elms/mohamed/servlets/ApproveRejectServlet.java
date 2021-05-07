package com.elms.mohamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elms.mohamed.source.LeaveRequestManager;

/**
 * Servlet implementation class ApproveRejectServlet
 */
@WebServlet("/ApproveRejectServlet")
public class ApproveRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRejectServlet() {
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
		String action= request.getParameter("approver");
		String[] values = action.split("-",2);
		int id = Integer.parseInt(values[1]);
		if(values[0].equals("approve")) {
			try {
				LeaveRequestManager.approveRequest(id);
			} catch (Exception e) {
				output.println("Invalid Leave Request");
			}
		}else {
			try {
				LeaveRequestManager.rejectRequest(id);
			} catch (Exception e) {
				output.println("Invalid Leave Request");
			}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("adminrequests.jsp");
		dispatch.include(request, response);
		
	}

}
