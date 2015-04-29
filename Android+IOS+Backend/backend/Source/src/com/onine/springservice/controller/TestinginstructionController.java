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

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onine.springservice.dao.ProductService;
import com.onine.springservice.dao.TestingInstrService;
import com.onine.springservice.domain.Cropdetails;
import com.onine.springservice.domain.ProductTypeList;
import com.onine.springservice.domain.TestInstr;


@RestController
@RequestMapping("/service/testinstr/")
public class TestinginstructionController {
	
	TestingInstrService TrsService=new TestingInstrService();
	    
	
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<TestInstr> getAllUsers() {
		List<TestInstr> users=TrsService.getAll();
		return users;
	}
}
