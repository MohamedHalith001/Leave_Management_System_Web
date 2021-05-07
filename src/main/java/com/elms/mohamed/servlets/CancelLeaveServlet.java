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
 * Servlet implementation class CancelLeaveServlet
 */
@WebServlet("/CancelLeaveServlet")
public class CancelLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelLeaveServlet() {
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
		int id = Integer.parseInt(request.getParameter("cancelbtn"));
		try {
			LeaveRequestManager.cancelRequests(id);
		} catch (Exception e) {
			output.println("Leave Request Not found");
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("viewrequest.jsp");
		dispatch.include(request, response);
	}

}
