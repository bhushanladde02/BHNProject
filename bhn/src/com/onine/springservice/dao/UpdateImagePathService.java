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
