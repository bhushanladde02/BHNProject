//************************************************************************//
//                                                                        //
// Description =                                                          // 
//                                                                        //
// Copyright   = 1232-AUT \u00a9 Copyright ONINE 2014,2015                //
//               Licensed Material - Program Property of ONINE            //
//               Refer to Copyright Instructions Form Number G231-2083    //
//                                                                        //
//               ONINE Confidential (ONINE Confidential-Restricted when   //
//               combined with the aggregated OCO source modules for      //
//               this program)                                            //
//                                                                        //
//               OCO Source Material                                      //
//                                                                        //
// Status      = Version 01 Release 07 Modification Level 08              //
//                                                                        //
// Compiler    = Java Standard Edition (build 1.7)                        //                    
//                                                                        //
// Change Activity:                                                       //
//                                                                        //
// Feature/Defect     Date                Description                     //
// --------------  ----------  ------------------------------------------ //
// R12493   - YP  2014/09/26    Part Created                              //
//************************************************************************//
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
