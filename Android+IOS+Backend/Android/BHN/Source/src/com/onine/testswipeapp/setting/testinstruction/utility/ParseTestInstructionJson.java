package com.onine.testswipeapp.setting.testinstruction.utility;
//************************************************************************//
//                                                                        //
// Name        =  ParseTestInstructionJson                                                  //
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseTestInstructionJson {

	public String readJsonFromFile() {

		InputStream in;
		StringBuilder out = new StringBuilder();
		out.append("");
		try {
			in = new FileInputStream(new File("data/TestInstruction.ada"));

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			//System.out.println(out.toString()); // Prints the string content
												// read from input stream
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out.toString();
	}
	
	
	public List<TestInstructionsVO> parseTestInstructionJsonString(String jsonData){
		JSONParser jsonParser = new JSONParser();
		List<TestInstructionsVO> plantsList=new ArrayList<TestInstructionsVO>();
		try {
			JSONArray plantsArray = (JSONArray) jsonParser.parse(jsonData);
			
//			System.out.println(plantsArray);
			
			
			for (int i = 0; i < plantsArray.size(); i++) {
				
				JSONObject plantEntry = (JSONObject) plantsArray.get(i);
//				System.out.println(plantsArray.get(i));
				
				TestInstructionsVO testVO=new TestInstructionsVO();
				
				testVO.setId((String) plantEntry.get("id"));
				testVO.setDataSentToLab((String) plantEntry.get("dataSentToLab"));
				testVO.setPartToSample((String) plantEntry.get("partToSample"));
				testVO.setPlantAppearance((String) plantEntry.get("plantAppearance"));
				testVO.setPlantName((String) plantEntry.get("plantName"));
				testVO.setSpecialInstructions((String) plantEntry.get("specialInstructions"));
				testVO.setWhenToTakeSample((String) plantEntry.get("whenToTakeSample"));
				
				
				plantsList.add(testVO);
				
			}
			
			System.out.println("Size of the List: "+plantsList.size());
			System.out.println("List is: "+plantsList);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return plantsList;
	}
	
	public Map<String, TestInstructionsVO> getTestInstructionMap(List<TestInstructionsVO> testList){
		Map<String, TestInstructionsVO> plantInstructionMap=new HashMap<String, TestInstructionsVO>();
		
		
		for (int i = 0; i < testList.size(); i++) {
			plantInstructionMap.put(testList.get(i).getPlantName(), testList.get(i));
		}
		
		return plantInstructionMap;
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new ParseTestInstructionJson().readJsonFromFile());
		ParseTestInstructionJson parser=new ParseTestInstructionJson();
		List<TestInstructionsVO> voList=parser.parseTestInstructionJsonString(parser.readJsonFromFile());
		System.out.println(parser.getTestInstructionMap(voList));
		
		
		
		
		
	}
}
