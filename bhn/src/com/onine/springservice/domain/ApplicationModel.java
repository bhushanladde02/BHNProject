package com.onine.springservice.domain;

/**
 * This model class is used mainly to send the data into a single object which contains all the details
 * that is needed to be displayed on the jsp pages.
 *  
 * @author come2niks
 *
 */
public class ApplicationModel{
	private LoginModel loginModel;

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
}