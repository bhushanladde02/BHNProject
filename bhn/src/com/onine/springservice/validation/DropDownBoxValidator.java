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