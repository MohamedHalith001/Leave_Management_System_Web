package com.elms.mohamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elms.mohamed.validator.LoginValidator;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		RequestDispatcher dispatch;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user = request.getParameter("user");
		if(username==null) {
			output.println("Please log in first");
			dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);
		}
		boolean webUser;
		if(user != null) {
			if(user.equals("admin")) {
				boolean admin = LoginValidator.adminVerification(username,password);
				if(admin) {
					output.println("<h2>Welcome "+username+"!</h2>");
					dispatch = request.getRequestDispatcher("adminpage.jsp");
					dispatch.include(request, response);
				}
			}else if(user.equals("employee")) {
				boolean employee = LoginValidator.employeeVerification(username,password);
				if(employee){
					output.println("<h2>Welcome "+username+"!</h2>");
					dispatch = request.getRequestDispatcher("employeepage.jsp");
					dispatch.include(request, response);
				}
			}else {
					output.println("Sorry Incorrect Username or Password");
					dispatch = request.getRequestDispatcher("login.jsp");
					dispatch.include(request, response);
			}
		}else {
			output.println("Invalid Action");
			dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);
		}
	}
}
