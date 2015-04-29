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
package com.onine.springservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onine.springservice.domain.ApplicationModel;
import com.onine.springservice.domain.LoginModel;



@Controller
public class UsersController {
	
	private LoginModel loginModel;

	/**
	 * This method will be called from LoginController if the user is validated.
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/success", method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) 
	{
		ApplicationModel applicationModel = new ApplicationModel();
		loginModel = (LoginModel)request.getSession().getAttribute("user");
		applicationModel.setLoginModel(loginModel);
		return new ModelAndView("index", "applicationModel", applicationModel);
	}
}