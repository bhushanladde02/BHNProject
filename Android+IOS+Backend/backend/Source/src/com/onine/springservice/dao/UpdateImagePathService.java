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
package com.onine.springservice.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.onine.springservice.utility.DBUtility;

public class UpdateImagePathService {
	
	public UpdateImagePathService() {
		
	}
	
	public void imagePathName(String imageName,String selectedItem){
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
	try {
		if(selectedItem!=null &&!selectedItem.equalsIgnoreCase("NONE") && !selectedItem.equalsIgnoreCase("") ){
		String arr[]=selectedItem.split("----");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		Statement statement = connection.createStatement();
		String query = "UPDATE  `bhn`.`products` SET  `imageurl` =  '"+imageName+"' WHERE  `products`.`type` =  '"+arr[1].trim().toString()+"' AND  `products`.`name` =  '"+arr[0].trim().toString()+"'";
		statement.executeUpdate(query);
		System.out.println("query::::::::::::::::::::::::::"+query);
		statement.close();
		connection.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public void imagePdfName1(String imageName,String selectedItem){
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
	try {
		if(selectedItem!=null &&!selectedItem.equalsIgnoreCase("NONE") && !selectedItem.equalsIgnoreCase("") ){
		String arr[]=selectedItem.split("----");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		Statement statement = connection.createStatement();
		String query = "UPDATE  `bhn`.`products` SET  `sdspdfurl` =  '"+imageName+"' WHERE  `products`.`type` =  '"+arr[1].trim().toString()+"' AND  `products`.`name` =  '"+arr[0].trim().toString()+"'";
		statement.executeUpdate(query);
		System.out.println("query::::::::::::::::::::::::::"+query);
		statement.close();
		connection.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public void insertProduct(String productType,String ProductName){
		try {
			DBUtility db=new DBUtility();
			Connection connection = db.getConnection();
			
			Statement statement = connection.createStatement();
			String query = "INSERT INTO `bhn`.`products` ( `name`, `imageurl`, `type`) VALUES ('"+ProductName+"', '', '"+productType+"');";
			statement.execute(query);
			System.out.println("query::::::::::::::::::::::::::"+query);
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
}
