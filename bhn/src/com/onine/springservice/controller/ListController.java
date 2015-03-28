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