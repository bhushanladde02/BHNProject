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
