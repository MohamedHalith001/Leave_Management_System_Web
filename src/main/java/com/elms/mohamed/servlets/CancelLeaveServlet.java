package com.elms.mohamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elms.mohamed.service.LeaveRequestManager;

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
		try {
			int id = Integer.parseInt(request.getParameter("cancelbtn"));
			LeaveRequestManager.cancelRequest(id);
			output.println("Removed the leave request");
		} catch (Exception e) {
			output.println(e.getMessage());
		}finally {
			RequestDispatcher dispatch = request.getRequestDispatcher("cancelleave.jsp");
			dispatch.include(request, response);
		}
	}

}
