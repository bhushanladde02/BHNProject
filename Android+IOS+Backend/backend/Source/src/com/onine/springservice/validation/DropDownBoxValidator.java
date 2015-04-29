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
package com.onine.springservice.validation;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 

import com.onine.springservice.domain.Products;
 
public class DropDownBoxValidator implements Validator{
 
	@Override
	public boolean supports(Class clazz) {
	   //just validate the Customer instances
	   return Products.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
 
		Products cust = (Products)target;
		if("NONE".equals(cust.getName())){
		errors.rejectValue("productList", "required.product");
	   }
	}
}