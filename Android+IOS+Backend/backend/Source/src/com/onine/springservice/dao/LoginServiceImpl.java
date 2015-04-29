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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.PreparedStatement;
import com.onine.springservice.domain.LoginModel;
import com.onine.springservice.utility.DBUtility;


/**
 * Implementation of LoginService
 * @author Niks
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	
	public boolean validate(LoginModel loginModel) {
		String SQL = "SELECT * FROM users WHERE userName =? and password = ?;";
		
		
		
		
		System.out.println("SQL : "+ SQL);
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
	
		try
		{
			PreparedStatement preparedStatement =(PreparedStatement) connection.prepareStatement(SQL);
			preparedStatement.setString(1, loginModel.getUserName());
			preparedStatement.setString(2, loginModel.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (null!= rs && rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("SQL Exception : "+e.getMessage());
			return false;
		}
	}

}
