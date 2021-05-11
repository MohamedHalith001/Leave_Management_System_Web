package com.elms.mohamed.validator;

import java.util.List;

import com.elms.mohamed.model.Employee;

import com.elms.mohamed.service.EmployeeManager;


public class LoginValidator {
	
	/**
	 * verifies the input for the admin.
	 * @param user
	 * @return
	 */
	public static boolean adminVerification(String username,String password) {
		boolean verified = false;
		if(username.equals("hradmin") && password.equals("realadmin")) {
			verified = true;
		}
		return verified;
	}
	/**
	 * verifies the input with the credentials of the employee
	 * @param user
	 * @return boolean
	 */
	public static boolean employeeVerification(String username,String password) {
		boolean verified = false;
		List<Employee> employeeList = EmployeeManager.getEmployeeList();
		for (Employee employee : employeeList) {
			if(username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
				verified=true;
			}
		}
		return verified;
	}
	
}
