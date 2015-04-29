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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onine.springservice.dao.ProductService;
import com.onine.springservice.domain.LoginModel;

 
@Controller
@RequestMapping("/listProducts")
public class ListController {
 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		LoginModel loginModel = (LoginModel)arg0.getSession().getAttribute("user");
		if(loginModel!=null){
		System.out.println(loginModel.getUserName());
		ProductService prd = new ProductService();
		ModelAndView modelAndView = new ModelAndView("productList");
		modelAndView.addObject("productList", prd.getList());
		return modelAndView;
		}
		else{
			System.out.println("Logg off session");
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}
 
	
}