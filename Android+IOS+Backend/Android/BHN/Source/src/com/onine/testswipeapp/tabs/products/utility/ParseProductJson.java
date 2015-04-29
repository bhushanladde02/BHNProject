package com.onine.testswipeapp.tabs.products.utility;
//************************************************************************//
//                                                                        //
// Name        =  ParseProductJson                                                  //
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
// Status      = Version 01 Release 01 Modification Level 01              //
//                                                                        //
// Compiler    = Java Standard Edition (build 1.7)                        //                    
//                                                                        //
// Change Activity:                                                       //
//                                                                        //
// Feature/Defect     Date                Description                     //
// --------------  ----------  ------------------------------------------ //
// R12493   - YP  2014/09/26    Part Created                              //
//************************************************************************//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;


public class ParseProductJson {

	
	
	
	public HashMap<String, List<Product>> parseProductJson(String jsonString) {
		HashMap<String, List<Product>> productCategories = new HashMap<String,List<Product>>();
		
		try {
			String jsonData="";
			jsonData=jsonString;
			
			List<Product> products;// = new ArrayList<Product>();

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(jsonData);

			JSONObject hash = (JSONObject) jsonObject.get("hash");
			Set<String> productsTypes = hash.keySet();

			for (String product : productsTypes) {
				JSONArray productArray = (JSONArray) hash.get(product);
				products = new ArrayList<Product>();

				for (int j = 0; j < productArray.size(); j++) {
					JSONObject productEntry = (JSONObject) productArray.get(j);

					Product productObject = new Product();

					productObject.setId((String) String.valueOf(productEntry.get("id")));
					productObject.setName((String) productEntry.get("name"));
					productObject.setImageurl((String) productEntry
							.get("imageurl"));
					productObject.setType((String) productEntry.get("type"));
					productObject.setSdsurl((String) productEntry.get("sdfPath"));

					products.add(productObject);
				}
				productCategories.put(product, products);
			}

			System.out.println(productCategories.size());
			System.out.println(productCategories);

		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} 
		
		return productCategories;
	}
	
	

	public Product [][] get2dArray(HashMap<String, List<Product>> hashmap){
		Object[] keys=hashmap.keySet().toArray();
		
		Product [][] productArray=new Product[keys.length][];
		
		
		for (int i = 0; i < keys.length; i++) {
			List<Product> list=hashmap.get(keys[i].toString());
			productArray[i]=new Product[list.size()];
			for (int j = 0; j < list.size(); j++) {
				productArray[i][j]=list.get(j);
				System.out.println("added element "+i+", "+j+" Name: "+productArray[i][j].getName());
			}
		}
		
		
		return productArray;
		
	}
	
	public String[] getHeadingArray(HashMap<String, List<Product>> hashmap){
		Object[] keys=hashmap.keySet().toArray();
		String[] arr=new String[keys.length];
		for (int i = 0; i < keys.length; i++) {
			arr[i]=(String)keys[i];
		}
		return arr;
	}
	
	/*public static void main(String[] args) {
		ParseProductJson parseProductJson=new ParseProductJson();
		HashMap<String, List<Product>> hashmap=parseProductJson.parseProductJson("http://onine.in/bhn/service/products/");
		System.out.println(parseProductJson.get2dArray(hashmap));
		
		
		
		
	}*/

	
	

	
}
