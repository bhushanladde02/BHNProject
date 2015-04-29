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

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.onine.springservice.dao.ProductService;
import com.onine.springservice.domain.ProductTypeList;
import com.onine.springservice.domain.Products;


@RestController
@RequestMapping("/service/products/")
public class ProductServiceController {
	
	ProductService userService=new ProductService();
	     	    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Products getUser(@PathVariable int id) {
		Products user=userService.getUserById(id);
		System.out.println("I m in this method.....");
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public ProductTypeList getAllUsers() {
		ProductTypeList users=userService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public ModelAndView getDeletedUser(@PathVariable int id) {
		userService.deleteUser(id);
		System.out.println("I m in deleted method method.....");
		ModelAndView modelAndView = new ModelAndView("success");
		 modelAndView.addObject("message", "Record Deleted");
			
		return modelAndView;
	}
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public ModelAndView getUpdateUser(@PathVariable int id) {
		Products user=userService.getUserById(id);
		ModelAndView modelAndView = new ModelAndView("Update");
		modelAndView.addObject("product", user);
		
		System.out.println("I m in this method.....");
		return modelAndView;
	}
	
	 @RequestMapping(value = "update/save/{name}", method = RequestMethod.GET)
	    public ModelAndView save(@PathVariable String name,HttpServletResponse httpServletResponse) {
		 try{
			 System.out.println(name);
		    String splitvalue[]=name.split("~~");
	        System.out.println("ID:::::::::"+splitvalue[0]);
	        System.out.println("Name:::::::::"+splitvalue[1]);
	        System.out.println("Type::::::::::"+splitvalue[2]);
	        Products pro =new Products();
	        pro.setId(Integer.parseInt(splitvalue[0].trim().toString()));
	        pro.setName(splitvalue[1]);
	        pro.setType(splitvalue[2]);
	        userService.updateUser(pro);
	        ModelAndView modelAndView = new ModelAndView("success");
	        modelAndView.addObject("message", "Record Updated");
	       // httpServletResponse.setHeader("Location", "bhn/success.do");
			return modelAndView;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 ModelAndView modelAndView = new ModelAndView("success");
			 modelAndView.addObject("message", "Not Updated");
				
			 return modelAndView;
		 }
	    }
}