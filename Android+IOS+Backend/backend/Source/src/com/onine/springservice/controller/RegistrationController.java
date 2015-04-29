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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onine.springservice.dao.UpdateImagePathService;
import com.onine.springservice.domain.ApplicationModel;
import com.onine.springservice.domain.LoginModel;
import com.onine.springservice.domain.Registration;


@Controller
@RequestMapping("/registrationform")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;

	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model,HttpServletRequest request, HttpServletResponse response) {
		Registration registration = new Registration();
		
		LoginModel loginModel = (LoginModel)request.getSession().getAttribute("user");
		if(loginModel!=null){
		System.out.println(loginModel.getUserName());
		model.put("registration", registration);
		
		return "registrationform";
		}
		else
		{
			System.out.println("Logg off session");
			
			
			return "logout";
		}
	}
	
	
	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result) {
		// set custom Validation by user
		registrationValidation.validate(registration, result);
		if (result.hasErrors()) {
			return "registrationform";
		}
		UpdateImagePathService img= new UpdateImagePathService();
		img.insertProduct(registration.getType(),registration.getUserName());
		
		return "registrationsuccess";
	}
}
