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

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onine.springservice.domain.Cropdetails;
import com.onine.springservice.domain.Products;
import com.onine.springservice.utility.DBUtility;

public class CropService {

	

	public CropService() {
		
	}
	
	public int getUserCount(){
		int count=0;
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from cropdetails");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public void addCrop(List<Cropdetails>  list) {
		try {
		
			DBUtility db=new DBUtility();
			Connection connection = db.getConnection();
			Statement statement = connection.createStatement();
			 
			for (Cropdetails cropdetails: list) {
			    String query = "INSERT INTO `bhn`.`cropdetails` (`id`, `croptype`, `growthstage`, `nd3_n`, `pd4_p`, `n`, `p`, `k`, `ca`, `mg`, `s`, `na`, `fe`, `zn`, `mn`, `cu`, `b`, `totalacrs`, `result`, `isrecomm`, `andr_or_i_phn`, `deviceid_n`, `extracolom`) VALUES ('"+cropdetails.getId()+"', '"+cropdetails.getCroptype()+"', '"+cropdetails.getGrowthstage()+"', '"+cropdetails.getNd3_n()+"', '"+cropdetails.getPd4_p()+"', '"+cropdetails.getN()+"', '"+cropdetails.getP()+"', '"+cropdetails.getK()+"', '"+cropdetails.getCa()+"', '"+cropdetails.getMg()+"', '"+cropdetails.getS()+"', '"+cropdetails.getNa()+"', '"+cropdetails.getFe()+"', '"+cropdetails.getZn()+"', '"+cropdetails.getMn()+"', '"+cropdetails.getCu()+"', '"+cropdetails.getB()+"', '"+cropdetails.getTotalacrs()+"', '"+cropdetails.getResult()+"', '"+cropdetails.getIsrecomm()+"', '"+cropdetails.getAndr_or_i_phn()+"', '"+cropdetails.getDeviceid_n()+"', '"+cropdetails.getExtracolom()+"');";
			    System.out.println("query:"+query);
			    statement.addBatch(query);
			}
			statement.executeBatch();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int userId) {
		try {
			DBUtility db=new DBUtility();
			Connection connection = db.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cropdetails where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Products user) throws ParseException {
			}

	public List<Cropdetails> getAllCrops(String deviceID) {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		List<Cropdetails> users = new ArrayList<Cropdetails>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cropdetails where id='"+deviceID+"'");
			Properties prop = new Properties();
            InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
            prop.load(inputStream);
          
			while (rs.next()) {
				Cropdetails user = new Cropdetails();
				user.setId(rs.getString("id"));		
				user.setCroptype(rs.getString("croptype"));	
				user.setGrowthstage(rs.getString("growthstage"));	
				user.setNd3_n(rs.getString("nd3_n"));	
				user.setPd4_p(rs.getString("pd4_p"));	
				user.setN(rs.getString("n"));	
				user.setP(rs.getString("p"));	
				user.setK(rs.getString("k"));	
				user.setCa(rs.getString("ca"));	
				user.setMg(rs.getString("mg"));	
				user.setS(rs.getString("s"));	
				user.setNa(rs.getString("na"));	
				user.setFe(rs.getString("fe"));	
				user.setZn(rs.getString("zn"));	
				user.setMn(rs.getString("mn"));	
				user.setCu(rs.getString("cu"));	
				user.setB(rs.getString("b"));	
				user.setTotalacrs(rs.getString("totalacrs"));	
				user.setResult(rs.getString("result"));	
				user.setIsrecomm(rs.getString("isrecomm"));	
				user.setAndr_or_i_phn(rs.getString("andr_or_i_phn"));	
				user.setDeviceid_n(rs.getString("deviceid_n"));	
				user.setExtracolom(rs.getString("extracolom"));
				users.add(user);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
	public List<Cropdetails> getRecommended() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		List<Cropdetails> users = new ArrayList<Cropdetails>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cropdetails where isrecomm='Y'");
			Properties prop = new Properties();
            InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
            prop.load(inputStream);
          
			while (rs.next()) {
				Cropdetails user = new Cropdetails();
				user.setId(rs.getString("id"));		
				user.setCroptype(rs.getString("croptype"));	
				user.setGrowthstage(rs.getString("growthstage"));	
				user.setNd3_n(rs.getString("nd3_n"));	
				user.setPd4_p(rs.getString("pd4_p"));	
				user.setN(rs.getString("n"));	
				user.setP(rs.getString("p"));	
				user.setK(rs.getString("k"));	
				user.setCa(rs.getString("ca"));	
				user.setMg(rs.getString("mg"));	
				user.setS(rs.getString("s"));	
				user.setNa(rs.getString("na"));	
				user.setFe(rs.getString("fe"));	
				user.setZn(rs.getString("zn"));	
				user.setMn(rs.getString("mn"));	
				user.setCu(rs.getString("cu"));	
				user.setB(rs.getString("b"));	
				user.setTotalacrs(rs.getString("totalacrs"));	
				user.setResult(rs.getString("result"));	
				user.setIsrecomm(rs.getString("isrecomm"));	
				user.setAndr_or_i_phn(rs.getString("andr_or_i_phn"));	
				user.setDeviceid_n(rs.getString("deviceid_n"));	
				user.setExtracolom(rs.getString("extracolom"));
				users.add(user);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
	public List<Cropdetails> getAllCrops() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		
		List<Cropdetails> users = new ArrayList<Cropdetails>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cropdetails");
			Properties prop = new Properties();
            InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
            prop.load(inputStream);
           // String domainlink = prop.getProperty("domainlink");
			while (rs.next()) {
				
				Cropdetails user = new Cropdetails();
				user.setId(rs.getString("id"));		
				user.setCroptype(rs.getString("croptype"));	
				user.setGrowthstage(rs.getString("growthstage"));	
				user.setNd3_n(rs.getString("nd3_n"));	
				user.setPd4_p(rs.getString("pd4_p"));	
				user.setN(rs.getString("n"));	
				user.setP(rs.getString("p"));	
				user.setK(rs.getString("k"));	
				user.setCa(rs.getString("ca"));	
				user.setMg(rs.getString("mg"));	
				user.setS(rs.getString("s"));	
				user.setNa(rs.getString("na"));	
				user.setFe(rs.getString("fe"));	
				user.setZn(rs.getString("zn"));	
				user.setMn(rs.getString("mn"));	
				user.setCu(rs.getString("cu"));	
				user.setB(rs.getString("b"));	
				user.setTotalacrs(rs.getString("totalacrs"));	
				user.setResult(rs.getString("result"));	
				user.setIsrecomm(rs.getString("isrecomm"));	
				user.setAndr_or_i_phn(rs.getString("andr_or_i_phn"));	
				user.setDeviceid_n(rs.getString("deviceid_n"));	
				user.setExtracolom(rs.getString("extracolom"));
				users.add(user);	
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
	
	/*public Products getUserById(int userId) {
		Products user = new Products();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from products where id=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
	        InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
			Properties prop = new Properties();
            prop.load(inputStream);
            String domainlink = prop.getProperty("domainlink");
			if (rs.next()) {
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setImageurl(domainlink+rs.getString("imageurl"));				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}*/

}
