package com.onine.springservice.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.onine.springservice.domain.ProductTypeList;
import com.onine.springservice.domain.Products;
import com.onine.springservice.utility.DBUtility;


public class ProductService {
	
	
	public ProductService() {
		
	}
	
	public int getUserCount(){
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from products");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public void addUser(Products user) {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into products(Id,name,imageurl) values (?,?,? )");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getImageurl());			
			
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			DBUtility db=new DBUtility();
			Connection connection = db.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from products where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(Products user) throws ParseException {
		try {
			DBUtility db=new DBUtility();
			Connection connection = db.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update products set name=?,type=?" +
							"where id=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getType());			
			preparedStatement.setInt(3, user.getId());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductTypeList getAllUsers() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		HashMap map=new HashMap();
		ProductTypeList prdmain=new ProductTypeList();
		try {
			
			Statement statement = connection.createStatement();
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT DISTINCT TYPE FROM products");
			Properties prop = new Properties();
            InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
            prop.load(inputStream);
            String domainlink = prop.getProperty("domainlink");
            String domainlink1 = prop.getProperty("domainlink1");
			while (rs.next()) {
				//ProductTypeList prd=new ProductTypeList();
				String type=rs.getString("TYPE");
				ResultSet rsInner = statement1.executeQuery("SELECT TYPE ,id,name,imageurl,sdspdfurl FROM products  where type='"+type+"'"+" GROUP BY TYPE,id,name,imageurl,sdspdfurl");
				List<Products> users = new ArrayList<Products>();
				while (rsInner.next()) {
				Products user = new Products();
				user.setId(rsInner.getInt("id"));
				user.setName(rsInner.getString("name"));
				user.setImageurl(domainlink+rsInner.getString("imageurl"));				
				user.setType(rsInner.getString("type"));
				user.setSdfPath(domainlink1+rsInner.getString("sdspdfurl"));
				
				users.add(user);
				}
				map.put(type, users);
				
			}
			

			prdmain.setHashList(map);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
      return prdmain;
	
	}
	
	public Products getUserById(int userId) {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
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
            String domainlink1 = prop.getProperty("domainlink1");
			if (rs.next()) {
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setImageurl(domainlink+rs.getString("imageurl"));				
				user.setType(rs.getString("TYPE"));				
				user.setSdfPath(domainlink1+rs.getString("sdspdfurl"));
				
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//SELECT * 	FROM products GROUP BY TYPE , id, name, imageurl
	
	public List<Products> getList() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		List<Products> users = new ArrayList<Products>();
		try {
			
			Statement statement = connection.createStatement();
				ResultSet rsInner = statement.executeQuery("SELECT TYPE ,id,name,imageurl,sdspdfurl FROM products GROUP BY TYPE,id,name,imageurl,sdspdfurl");
				
				while (rsInner.next()) {
				Products user = new Products();
				user.setId(rsInner.getInt("id"));
				user.setName(rsInner.getString("name"));
				user.setImageurl(rsInner.getString("imageurl"));				
				user.setType(rsInner.getString("type"));
				user.setSdfPath(rsInner.getString("sdspdfurl"));
				
				
				users.add(user);
				}
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
      return users;
	
	}
	public List<Products> getListName() {
		DBUtility db=new DBUtility();
		Connection connection = db.getConnection();
		List<Products> users = new ArrayList<Products>();
		try {
			
			Statement statement = connection.createStatement();
				ResultSet rsInner = statement.executeQuery("SELECT TYPE ,id,name,imageurl,sdspdfurl FROM products order by name ");
				
				while (rsInner.next()) {
				Products user = new Products();
				user.setName(rsInner.getString("name")+ "    ----    " + rsInner.getString("type")) ;
				users.add(user);
				}
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
      return users;
	
	}
}

