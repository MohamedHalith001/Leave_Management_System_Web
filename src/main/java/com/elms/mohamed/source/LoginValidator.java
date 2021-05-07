package com.elms.mohamed.source;

public class LoginValidator {
	
	/**
	 * verifies the input for the admin.
	 * @param user
	 * @return
	 */
	public static boolean adminVerification(User user) {
		boolean verified = false;
		if(user.getUsername().equals("hradmin") && user.getPassword().equals("realadmin")) {
			verified = true;
		}
		return verified;
	}
	/**
	 * verifies the input with the credentials of the employee
	 * @param user
	 * @return boolean
	 */
	public static boolean employeeVerification(User user) {
		boolean verified = false;
		if(user.getUsername().equals("moha2627") && user.getPassword().equals("pass1234")) {
			verified = true;
		}
		return verified;
	}
	
}
