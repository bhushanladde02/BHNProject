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
