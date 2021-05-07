package com.elms.mohamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elms.mohamed.source.LoginValidator;
import com.elms.mohamed.source.User;

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
        // TODO Auto-generated constructor stub
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
		if(username==null) {
			output.println("Please log in first");
			dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean admin = LoginValidator.adminVerification(user);
		boolean employee = LoginValidator.employeeVerification(user);
		if(admin) {
			output.println("<h2>Welcome "+username+"!</h2>");
			dispatch = request.getRequestDispatcher("adminpage.jsp");
			dispatch.include(request, response);
		}else if(employee){
			output.println("<h2>Welcome"+username+"!</h2>");
			dispatch = request.getRequestDispatcher("employeepage.jsp");
			dispatch.include(request, response);
		}else {
			output.println("Sorry Incorrect Username or Password");
			dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);
		}
	}

}
