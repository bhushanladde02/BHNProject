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

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.onine.springservice.domain.Registration;


@Component("registrationValidator")
public class RegistrationValidation {
	public boolean supports(Class<?> klass) {
		return Registration.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");
		String userName = registration.getUserName();
		if ((userName.length()) > 50) {
			errors.rejectValue("userName",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		
	}
}
