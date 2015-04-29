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
	
	import java.util.Map;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	
	@Controller
	@RequestMapping("/uploadfileindex")
	public class UploadFileIndexController {
	
		// Display the form on the get request
		@RequestMapping(method = RequestMethod.GET)
		public String showRegistration(Map model) {
			return "uploadfileindex";
		}
	
		// Process the form.
		@RequestMapping(method = RequestMethod.POST)
		public String processRegistration(BindingResult result) {
			return "uploadfileindex";
		}
	}
