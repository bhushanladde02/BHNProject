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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.onine.springservice.dao.CropService;
import com.onine.springservice.domain.Cropdetails;
import com.onine.springservice.domain.Products;

@RestController
@RequestMapping("/service/crops/")
public class CropController {
	
	CropService cropSer=new CropService();
	public CropController(){
	System.out.println("init cropController");
    }
  

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Cropdetails> get(HttpServletResponse res) 
	{
		List<Cropdetails> users=cropSer.getAllCrops();
		return users;
	}
	@RequestMapping(value="recomm",method = RequestMethod.GET)
	public @ResponseBody List<Cropdetails> getRecom(HttpServletResponse res) 
	{
		List<Cropdetails> users=cropSer.getRecommended();
		return users;
	}
	
	@RequestMapping(value="/{deviceId}",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Cropdetails> getAllCrops(@PathVariable String deviceId) {
		List<Cropdetails> users=cropSer.getAllCrops(deviceId);
		return users;
	}
	
	@RequestMapping(value="cropdetails",headers="Accept=application/json", method = RequestMethod.POST)
	public @ResponseBody String post(@RequestBody final String cropdetails) 
	{
		System.out.println("I am in Post method::"+cropdetails);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			List<Cropdetails> list = mapper.readValue(cropdetails,
					TypeFactory.defaultInstance().constructCollectionType(List.class,  
							Cropdetails.class));
			cropSer.addCrop(list);
			//Iterator itr=list.iterator();
			/*while (itr.hasNext())
			{
				Cropdetails crop=(Cropdetails)itr.next();
				System.out.println(crop.getId()+":::::::::::::::::"+crop.getCa());
			}*/
			
		//convert the json string back to object
		//Cropdetails obj = gson.fromJson(cropdetails, Cropdetails.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cropdetails;
	}
}