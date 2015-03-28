package com.onine.springservice.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onine.springservice.domain.TestInstr;
import com.onine.springservice.utility.DBUtility;

public class TestingInstrService {
	
	public TestingInstrService() {
		
	}
	
	public List<TestInstr> getAll() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		List<TestInstr> users = new ArrayList<TestInstr>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from testinstr");
			Properties prop = new Properties();
            InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
            prop.load(inputStream);
           // String domainlink = prop.getProperty("domainlink");
			while (rs.next()) {
				
				TestInstr user = new TestInstr();
				user.setId(rs.getString("id"));		
				user.setDataSentToLab(rs.getString("datasenttolab"));	
				user.setPartToSample(rs.getString("parttosample"));	
				user.setPlantAppearance(rs.getString("plantAppearance"));	
				user.setPlantName(rs.getString("plantname"));
				user.setSpecialInstructions(rs.getString("specialinstructions"));
				user.setWhenToTakeSample(rs.getString("whentotakesample"));
				
				users.add(user);	
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
	
}
