package com.onine.springservice.domain;

/**
 * This model class contains the properties for the filed on the login.jsp page.
 * @author come2niks
 *
 */
public class LoginModel {
	
	/* This is the attribute name (path) of username field in login.jsp page */
	private String userName;
	
	/* This is the attribute name (path) of Password field in login.jsp page */
	private String password;
	
	/* Getters and setters for the private fields. */
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
