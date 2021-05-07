package com.elms.mohamed.source;

public class User {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username.isEmpty() || username.equals(" ")) {
			throw new IllegalArgumentException("Invalid Username");
		}
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password.isEmpty() || password.equals(" ")) {
			throw new IllegalArgumentException("Invalid Username");
		}
		this.password = password;
	}
}
