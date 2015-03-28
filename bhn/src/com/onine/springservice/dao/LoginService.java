package com.onine.springservice.dao;

import com.onine.springservice.domain.LoginModel;


/**
 * LoginService Interface
 * @author Niks
 *
 */
public interface LoginService {
	
	public boolean validate(LoginModel loginModel);
}
