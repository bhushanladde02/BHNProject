package com.onine.testswipeapp.tabs.calculator.utility;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorService                                                  //
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.text.GetChars;
import android.util.Log;

public class CalculatorService {
	
	
	
	
	public Map<String, String> getResult(Context appcontext, Map<String, String> inputMap, String cropName1, String growthStage1, String acres){
		Map<String, String> hashMap=new HashMap<String, String>();
		
		System.out.println("&&&&&&&&&&&&&&&&& Input from Previous Act: : : &&&&&&&&&& :"+inputMap.get("N"));
		
		
		final DatabaseHandlerBhn db = new DatabaseHandlerBhn(appcontext);
		
		 db.truncAll();
		 
		 
		 
		 
		//inputs
		String cropName=cropName1.trim();
		String growthStage=growthStage1.trim();
		String acrs=acres.trim();
		
		
		/*String labN="1.0";
		String labP="1.0";
		String labK="1.0";
		String labCa="1.0";
		String labMg="1.0";
		String labS="1.0";
		String labFe="1.0";
		String labZn="1.0";
		String labMn="1.0";
		String labCu="1.0";
		String labB="1.0";*/

		
		String labN=inputMap.get("N").trim();
		String labP=inputMap.get("P").trim();
		String labK=inputMap.get("K").trim();
		String labCa=inputMap.get("CA").trim();
		String labMg=inputMap.get("MG").trim();
		String labS=inputMap.get("S").trim();
		String labFe=inputMap.get("FE").trim();
		String labZn=inputMap.get("ZN").trim();
		String labMn=inputMap.get("MN").trim();
		String labCu=inputMap.get("CU").trim();
		String labB=inputMap.get("B").trim();
		
		//input end
		
		
		
		
		
		
		
		
		
		
		
		
	
		Cropdetails crop1= new Cropdetails ("ALMONDS1","ALMONDS","1","3.2","0.32","2.56","2.56","0.32","0.32",null,"130","37","60","16","42");
		Cropdetails crop2= new Cropdetails ("ALMONDS2","ALMONDS","2","3.8","0.38","3.04","3.04","0.38","0.38",null,"130","37","60","16","42");
		Cropdetails crop3= new Cropdetails ("ALMONDS3","ALMONDS","3","3.4","0.34","3.04","3.04","0.34","0.34",null,"130","37","60","16","42");
		Cropdetails crop4= new Cropdetails ("ALMONDS4","ALMONDS","4","3","0.3","3","3","0.3","0.3",null,"130","37","60","16","42");

		Cropdetails crop5= new Cropdetails ("APPLES1","APPLES","1","2.1","0.21","1.68","1.68","0.21","0.21",null,"105","25","65","12","31");
		Cropdetails crop6= new Cropdetails ("APPLES2","APPLES","2","2.5","0.25","2","2","0.25","0.25",null,"105","25","65","12","31");
		Cropdetails crop7= new Cropdetails ("APPLES3","APPLES","3","2.2","0.22","2.2","2.2","0.22","0.22",null,"105","25","65","12","31");
		Cropdetails crop8= new Cropdetails ("APPLES4","APPLES","4","2","0.2","1.6","1.6","0.2","0.2",null,"105","25","65","12","31");

		Cropdetails crop9= new Cropdetails ("CANTALOUPE1","CANTALOUPE","1","3.8","0.38","3.04","3.04","0.38","0.38",null,"118","53","91","14","62");
		Cropdetails crop10= new Cropdetails ("CANTALOUPE2","CANTALOUPE","2","4.2","0.42","3.36","3.36","0.42","0.42",null,"118","53","91","14","62");
		Cropdetails crop11= new Cropdetails ("CANTALOUPE3","CANTALOUPE","3","4","0.4","4","4","0.4","0.4",null,"118","53","91","14","62");
		Cropdetails crop12= new Cropdetails ("CANTALOUPE4","CANTALOUPE","4","3.8","0.38","4.2","4.2","0.38","0.38",null,"118","53","91","14","62");

		
		Cropdetails crop13= new Cropdetails ("CHILIPEPPERS1","CHILIPEPPERS","1","4.4","0.44","3.52","3.52","0.44","0.44",null,"245","43","115","17","46");
		Cropdetails crop14= new Cropdetails ("CHILIPEPPERS2","CHILIPEPPERS","2","4.6","0.44","3.52","3.52","0.44","0.44",null,"245","43","115","17","46");
		Cropdetails crop15= new Cropdetails ("CHILIPEPPERS3","CHILIPEPPERS","3","4.6","0.44","3.52","3.52","0.44","0.44",null,"245","43","115","17","46");
		Cropdetails crop16= new Cropdetails ("CHILIPEPPERS4","CHILIPEPPERS","4","3.8","0.38","3.52","3.52","0.38","0.38",null,"245","43","115","17","46");

		Cropdetails crop17= new Cropdetails ("CORN1","CORN","1","3.2","0.32","2.56","2.56","0.32","0.32",null,"95","33","60","12","13");
		Cropdetails crop18= new Cropdetails ("CORN2","CORN","2","3.8","0.38","3.04","3.04","0.38","0.38",null,"95","33","60","12","13");
		Cropdetails crop19= new Cropdetails ("CORN3","CORN","3","3.8","0.38","2.4","2.4","0.38","0.38",null,"95","33","60","12","13");
		Cropdetails crop20= new Cropdetails ("CORN4","CORN","4","2","0.2","2.6","2.6","0.2","0.2",null,"95","33","60","12","13");

		Cropdetails crop21= new Cropdetails ("COTTON1","COTTON","1","3.6","0.36","2.88","2.88","0.36","0.36",null,"104","41","48","19","62");
		Cropdetails crop22= new Cropdetails ("COTTON2","COTTON","2","3.6","0.36","2.88","2.88","0.36","0.36",null,"104","41","48","19","62");
		Cropdetails crop23= new Cropdetails ("COTTON3","COTTON","3","3.2","0.32","2.56","2.56","0.32","0.32",null,"104","41","48","19","62");
		Cropdetails crop24= new Cropdetails ("COTTON4","COTTON","4","3","0.3","2.4","2.4","0.3","0.3",null,"104","41","48","19","62");
		
		Cropdetails crop25= new Cropdetails ("CUCUMBERS1","CUCUMBERS","1","4","0.4","3.9","3.2","0.4","0.4",null,"300","48","85","16","45");
		Cropdetails crop26= new Cropdetails ("CUCUMBERS2","CUCUMBERS","2","4.4","0.44","3.52","3.52","0.44","0.44",null,"300","48","85","16","45");
		Cropdetails crop27= new Cropdetails ("CUCUMBERS3","CUCUMBERS","3","3.8","0.4","3.2","3.2","0.4","0.4",null,"300","48","85","16","45");
		Cropdetails crop28= new Cropdetails ("CUCUMBERS4","CUCUMBERS","4","3.4","0.36","3.2","3.2","0.4","0.4",null,"300","48","85","16","45");


		Cropdetails crop29= new Cropdetails ("DRYEDIBLEBEANS1","DRYEDIBLEBEANS","1","4.2","0.42","3.36","3.36","0.42","0.42",null,"135","36","83","14","42");
		Cropdetails crop30= new Cropdetails ("DRYEDIBLEBEANS2","DRYEDIBLEBEANS","2","4.2","0.42","3.36","3.36","0.42","0.42",null,"135","36","83","14","42");
		Cropdetails crop31= new Cropdetails ("DRYEDIBLEBEANS3","DRYEDIBLEBEANS","3","4.2","0.42","3.36","3.36","0.42","0.42",null,"135","36","83","14","42");
		Cropdetails crop32= new Cropdetails ("DRYEDIBLEBEANS4","DRYEDIBLEBEANS","4","3.8","0.38","3.04","3.04","0.38","0.38",null,"135","36","83","14","42");
		
		Cropdetails crop33= new Cropdetails ("GRAPES1","GRAPES","1","2.7","0.27","2.2","2.2","0.27","0.27",null,"75","36","70","12","31");
		Cropdetails crop34= new Cropdetails ("GRAPES2","GRAPES","2","3","0.3","2.4","2.4","0.3","0.3",null,"75","36","70","12","31");
		Cropdetails crop35= new Cropdetails ("GRAPES3","GRAPES","3","2.8","0.28","2.6","2.6","0.28","0.28",null,"75","36","70","12","31");
		Cropdetails crop36= new Cropdetails ("GRAPES4","GRAPES","4","2.4","0.24","2.4","2.4","0.24","0.24",null,"75","36","70","12","31");
		
		
		Cropdetails crop37= new Cropdetails ("ONIONS1","ONIONS","1","3.4","0.34","2.72","2.72","0.34","0.34",null,"90","55","75","16","27");
		Cropdetails crop38= new Cropdetails ("ONIONS2","ONIONS","2","3.8","0.38","3.04","3.04","0.38","0.38",null,"90","55","75","16","27");
		Cropdetails crop39= new Cropdetails ("ONIONS3","ONIONS","3","3.4","0.34","2.72","2.72","0.34","0.34",null,"90","55","75","16","27");
		Cropdetails crop40= new Cropdetails ("ONIONS4","ONIONS","4","3.1","0.31","3.1","3.1","0.31","0.31",null,"90","55","75","16","27");
		
		Cropdetails crop41= new Cropdetails ("ORANGES1","ORANGES","1","2.4","0.24","2.28","2.28","0.24","0.24",null,"130","60","120","15","54");
		Cropdetails crop42= new Cropdetails ("ORANGES2","ORANGES","2","2.8","0.28","2.48","2.48","0.28","0.28",null,"130","60","120","15","54");
		Cropdetails crop43= new Cropdetails ("ORANGES3","ORANGES","3","2.6","0.26","2.28","2.28","0.26","0.26",null,"130","60","120","15","54");
		Cropdetails crop44= new Cropdetails ("ORANGES4","ORANGES","4","2.6","0.26","2.28","2.28","0.26","0.26",null,"130","60","120","15","54");

		Cropdetails crop45= new Cropdetails ("PEACH-NECTARINE1","PEACH-NECTARINE","1","3.8","0.38","3.04","3.04","0.38","0.38",null,"130","40","55","12","30");
		Cropdetails crop46= new Cropdetails ("PEACH-NECTARINE2","PEACH-NECTARINE","2","3.6","0.36","2.88","2.88","0.36","0.36",null,"130","40","55","12","30");
		Cropdetails crop47= new Cropdetails ("PEACH-NECTARINE3","PEACH-NECTARINE","3","3.8","0.38","3.04","3.04","0.38","0.38",null,"130","40","55","12","30");
		Cropdetails crop48= new Cropdetails ("PEACH-NECTARINE4","PEACH-NECTARINE","4","3.4","0.34","2.72","2.72","0.34","0.34",null,"130","40","55","12","30");

		
		Cropdetails crop49= new Cropdetails ("PECANS1","PECANS","1","2.6","0.26","2.08","2.08","0.26","0.26",null,"100","48","115","25","55");
		Cropdetails crop50= new Cropdetails ("PECANS2","PECANS","2","3","0.3","2.4","2.4","0.3","0.3",null,"100","48","115","25","55");
		Cropdetails crop51= new Cropdetails ("PECANS3","PECANS","3","2.4","0.24","1.92","1.92","0.24","0.24",null,"100","48","115","25","55");
		Cropdetails crop52= new Cropdetails ("PECANS4","PECANS","4","3","0.3","2.4","2.4","0.3","0.3",null,"100","48","115","25","55");
		
		Cropdetails crop53= new Cropdetails ("POTATO1","POTATO","1","5.4","0.54","4.32","4.32","0.54","0.54",null,"135","50","120","18","35");
		Cropdetails crop54= new Cropdetails ("POTATO2","POTATO","2","6","0.6","4.8","4.8","0.6","0.6",null,"135","50","120","18","35");
		Cropdetails crop55= new Cropdetails ("POTATO3","POTATO","3","4.9","0.49","4.8","4.8","0.54","0.54",null,"135","50","120","18","35");
		Cropdetails crop56= new Cropdetails ("POTATO4","POTATO","4","4","0.4","4","4","0.4","0.4",null,"135","50","120","18","35");

		Cropdetails crop57= new Cropdetails ("RICE1","RICE","1","2.8","0.28","2.24","2.24","0.28","0.28",null,"117","42","52","10","35");
		Cropdetails crop58= new Cropdetails ("RICE2","RICE","2","3.6","0.36","2.88","2.88","0.36","0.36",null,"117","42","52","10","35");
		Cropdetails crop59= new Cropdetails ("RICE3","RICE","3","3.3","0.33","2.9","2.9","0.33","0.33",null,"117","42","52","10","35");
		Cropdetails crop60= new Cropdetails ("RICE4","RICE","4","2.8","0.28","2.8","2.8","0.28","0.28",null,"117","42","52","10","35");
		
		Cropdetails crop61= new Cropdetails ("SOYBEANS1","SOYBEANS","1","4.4","0.44","3.52","3.52","0.44","0.44",null,"95","39","58","13","41");
		Cropdetails crop62= new Cropdetails ("SOYBEANS2","SOYBEANS","2","5.2","0.52","4.16","4.16","0.52","0.52",null,"95","39","58","13","41");
		Cropdetails crop63= new Cropdetails ("SOYBEANS3","SOYBEANS","3","5.2","0.52","4.16","4.16","0.52","0.52",null,"95","39","58","13","41");
		Cropdetails crop64= new Cropdetails ("SOYBEANS4","SOYBEANS","4","4.4","0.44","3.52","3.52","0.44","0.44",null,"95","39","58","13","41");
		
		Cropdetails crop65= new Cropdetails ("TOMATO1","TOMATO","1","4.2","0.42","3.36","3.36","0.42","0.42",null,"140","40","145","20","60");
		Cropdetails crop66= new Cropdetails ("TOMATO2","TOMATO","2","4.6","0.46","3.68","3.68","0.46","0.46",null,"140","40","145","20","60");
		Cropdetails crop67= new Cropdetails ("TOMATO3","TOMATO","3","4.2","0.42","3.68","3.68","0.42","0.42",null,"140","40","145","20","60");
		Cropdetails crop68= new Cropdetails ("TOMATO4","TOMATO","4","3.2","0.32","3.2","3.2","0.32","0.32",null,"140","40","145","20","60");

		
		Cropdetails crop69= new Cropdetails ("WATERMELON1","WATERMELON","1","4.2","0.42","3.36","3.36","0.42","0.42",null,"140","48","90","16","45");
		Cropdetails crop70= new Cropdetails ("WATERMELON2","WATERMELON","2","4.2","0.42","3.36","3.36","0.42","0.42",null,"140","48","90","16","45");
		Cropdetails crop71= new Cropdetails ("WATERMELON3","WATERMELON","3","4.2","0.42","3.36","3.36","0.42","0.42",null,"140","48","90","16","45");
		Cropdetails crop72= new Cropdetails ("WATERMELON4","WATERMELON","4","3.8","0.38","3.36","3.36","0.42","0.42",null,"140","48","90","16","45");
	
		Cropdetails crop73= new Cropdetails ("WHEAT1","WHEAT","1","4","0.4","3.2","3.2","0.4","0.4",null,"63","36","33","10","27");
		Cropdetails crop74= new Cropdetails ("WHEAT2","WHEAT","2","4.5","0.45","3.6","3.6","0.45","0.45",null,"63","36","33","10","27");
		Cropdetails crop75= new Cropdetails ("WHEAT3","WHEAT","3","4","0.4","3.6","3.6","0.45","0.45",null,"63","36","33","10","27");
		Cropdetails crop76= new Cropdetails ("WHEAT4","WHEAT","4","3.2","0.32","2.56","2.56","0.32","0.32",null,"63","36","33","10","27");



		
		//DeficiencyFactor
		Cropdetails crop77= new Cropdetails ("ALMONDSfactor","ALMONDS","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");
		Cropdetails crop78= new Cropdetails ("APPLESfactor","APPLES","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");
		Cropdetails crop79= new Cropdetails ("CANTALOUPEfactor","CANTALOUPE","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop80= new Cropdetails ("CHILIPEPPERSfactor","CHILIPEPPERS","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop81= new Cropdetails ("CORNfactor","CORN","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop82= new Cropdetails ("COTTONfactor","COTTON","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop83= new Cropdetails ("CUCUMBERSfactor","CUCUMBERS","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop84= new Cropdetails ("DRYEDIBLEBEANSfactor","DRYEDIBLEBEANS","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");

		Cropdetails crop85= new Cropdetails ("GRAPESfactor","GRAPES","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");

		Cropdetails crop86= new Cropdetails ("ONIONSfactor","ONIONS","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");

		Cropdetails crop87= new Cropdetails ("ORANGESfactor","ORANGES","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");

		Cropdetails crop88= new Cropdetails ("PEACH-NECTARINEfactor","PEACH-NECTARINE","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");
		
		Cropdetails crop89= new Cropdetails ("PECANSfactor","PECANS","Divided by Deficiency Factor","0.1","0.008","0.075","0.025","0.025","0.01","128","2.5","2.5","2.5","1","2.5");
		Cropdetails crop90= new Cropdetails ("POTATOfactor","POTATO","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		
		Cropdetails crop91= new Cropdetails ("RICEfactor","RICE","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop92= new Cropdetails ("SOYBEANSfactor","SOYBEANS","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		
		Cropdetails crop93= new Cropdetails ("TOMATOfactor","TOMATO","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		Cropdetails crop94= new Cropdetails ("WATERMELONfactor","WATERMELON","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");
		
		Cropdetails crop95= new Cropdetails ("WHEATfactor","WHEAT","Divided by Deficiency Factor","0.2","0.015","0.15","0.05","0.05","0.02","128","5","5","5","2","5");

		db.add(crop1);
		db.add(crop2);
		db.add(crop3);
		db.add(crop4);
		db.add(crop5);
		db.add(crop6);
		db.add(crop7);
		db.add(crop8);
		db.add(crop9);
		db.add(crop10);
		db.add(crop11);
		db.add(crop12);
		db.add(crop13);
		db.add(crop14);
		db.add(crop15);
		db.add(crop16);
		db.add(crop17);
		db.add(crop18);
		db.add(crop19);
		db.add(crop20);
		db.add(crop21);
		db.add(crop22);
		db.add(crop23);
		db.add(crop24);
		db.add(crop25);
		db.add(crop26);
		db.add(crop27);
		db.add(crop28);
		db.add(crop29);
		db.add(crop30);
		db.add(crop31);
		db.add(crop32);
		db.add(crop33);
		db.add(crop34);
		db.add(crop35);
		db.add(crop36);
		db.add(crop37);
		db.add(crop38);
		db.add(crop39);
		db.add(crop40);
		db.add(crop41);
		db.add(crop42);
		db.add(crop43);
		db.add(crop44);
		db.add(crop45);
		db.add(crop46);
		db.add(crop47);
		db.add(crop48);
		db.add(crop49);
		db.add(crop50);
		db.add(crop51);
		db.add(crop52);
		db.add(crop53);
		db.add(crop54);
		db.add(crop55);
		db.add(crop56);
		db.add(crop57);
		db.add(crop58);
		db.add(crop59);
		db.add(crop60);
		db.add(crop61);
		db.add(crop62);
		db.add(crop63);
		db.add(crop64);
		db.add(crop65);
		db.add(crop66);
		db.add(crop67);
		db.add(crop68);
		db.add(crop69);
		db.add(crop70);
		db.add(crop71);
		db.add(crop72);
		db.add(crop73);
		db.add(crop74);
		db.add(crop75);
		db.add(crop76);
		db.add(crop77);
		db.add(crop78);
		db.add(crop79);
		db.add(crop80);
		db.add(crop81);
		db.add(crop82);
		db.add(crop83);
		db.add(crop84);
		db.add(crop85);
		db.add(crop86);
		db.add(crop87);
		db.add(crop88);
		db.add(crop89);
		db.add(crop90);
		db.add(crop91);
		db.add(crop92);
		db.add(crop93);
		db.add(crop94);
		db.add(crop95);
   
	   
	    	/////////////////////////////////////////////////////////////////
     Log.d("Starting calculation: ", "Starting creating output.."); 
		
		
		//inputs
		/*String cropName="CUCUMBERS";
		String growthStage="1";
		String acrs="10";
		
		
		String labN="1.0";
		String labP="1.0";
		String labK="1.0";
		String labCa="1.0";
		String labMg="1.0";
		String labS="1.0";
		String labFe="1.0";
		String labZn="1.0";
		String labMn="1.0";
		String labCu="1.0";
		String labB="1.0";*/
		
		//input end
		
	
		
		double n=0;
		double p=0;
		double k=0;
		double ca=0;
		double mg=0;
		double s=0;
		//double na=0;
		double fe=0;
		double zn=0;
		double mn=0;
		double cu=0;
		double b=0;
	
	  System.out.println("*********************************************************************Phase i*********************************************************************");
		
	  List<Cropdetails> cn2  = db.getAll(cropName+growthStage);       
         
      for(Cropdetails cn1:cn2){
    	  String cnN=cn1.getN();
    	  String cnP=cn1.getP();
    	  String cnK=cn1.getK();
    	  String cnCa=cn1.getCa();
    	  String cnMg=cn1.getMg();
    	  String cnS=cn1.getS();
    	  String cnFe=cn1.getFe();
    	  String cnZn=cn1.getZn();
    	  String cnMn=cn1.getMn();
    	  String cnCu=cn1.getCu();
    	  String cnB=cn1.getB();
    	  
    	  System.out.println("1st iteration");
          System.out.println("n:"+cnN);
          System.out.println("p:"+cnP);
          System.out.println("k:"+cnK);
          System.out.println("ca:"+cnCa);
          System.out.println("mg:"+cnMg);
          System.out.println("s:"+cnS);
          System.out.println("fe:"+cnFe);
          System.out.println("zn:"+cnZn);
          System.out.println("mn:"+cnMn);
          System.out.println("cu:"+cnCu);
          System.out.println("b:"+cnB);
          
      	  
    	  cnN=(cnN==null || cnN.equalsIgnoreCase("")) ? "0.0" : cnN;
    	  cnP=(cnP==null || cnP.equalsIgnoreCase("")) ? "0.0" : cnP;
    	  cnK=( cnK==null || cnK.equalsIgnoreCase("")) ? "0.0" : cnK;
    	  cnCa=(cnCa==null || cnCa.equalsIgnoreCase("") ) ? "0.0" : cnCa;
    	  cnMg=( cnMg==null || cnMg.equalsIgnoreCase("")) ? "0.0" : cnMg;
    	  cnS=(cnS==null ||cnN.equalsIgnoreCase("")  ) ? "0.0" : cnS;
    	  cnFe=(cnFe==null || cnN.equalsIgnoreCase("") ) ? "0.0" : cnFe;
    	  cnZn=(cnZn==null || cnN.equalsIgnoreCase("")  ) ? "0.0" : cnZn;
    	  cnMn=(cnMn==null || cnN.equalsIgnoreCase("") ) ? "0.0" : cnMn;
    	  cnCu=( cnCu==null || cnN.equalsIgnoreCase("")) ? "0.0" : cnCu;
    	  cnB=(cnB==null || cnN.equalsIgnoreCase("") ) ? "0.0" : cnB;
    	  
    	 
        	n=Double.parseDouble(cnN)-Double.parseDouble(labN);
            p=Double.parseDouble(cnP)-Double.parseDouble(labP);
            k=Double.parseDouble(cnK)-Double.parseDouble(labK);
            ca=Double.parseDouble(cnCa)-Double.parseDouble(labCa);
            mg=Double.parseDouble(cnMg)-Double.parseDouble(labMg);
            s=Double.parseDouble(cnS)-Double.parseDouble(labS);
            fe=Double.parseDouble(cnFe)-Double.parseDouble(labFe);
            zn=Double.parseDouble(cnZn)-Double.parseDouble(labZn);
            mn=Double.parseDouble(cnMn)-Double.parseDouble(labMn);
            cu=Double.parseDouble(cnCu)-Double.parseDouble(labCu);
            b=Double.parseDouble(cnB)-Double.parseDouble(labB);
            
            System.out.println("1st iteration");
            System.out.println("n:"+n);
            System.out.println("p:"+p);
            System.out.println("k:"+k);
            System.out.println("ca:"+ca);
            System.out.println("mg:"+mg);
            System.out.println("s:"+s);
            System.out.println("fe:"+fe);
            System.out.println("zn:"+zn);
            System.out.println("mn:"+mn);
            System.out.println("cu:"+cu);
            System.out.println("b:"+b);
           
        
      }
          
        //D13 check done
        n=  (n < 0) ? 0 : n;
        p=  (p < 0) ? 0 : p;
        k=  (k < 0) ? 0 : k;
        ca=  (ca < 0) ? 0 : ca;
        mg=  (mg < 0) ? 0 : mg;
        s=  (s < 0) ? 0 : s;
        fe=  (n < 0) ? 0 : fe;
        zn=  (n < 0) ? 0 : zn;
        mn=  (n < 0) ? 0 : mn;
        cu=  (n < 0) ? 0 : cu;
        b=  (n < 0) ? 0 : b;
        String multiPlyNumAcr="";
        
        
        System.out.println("*********************************************************************Phase ii*********************************************************************");
    	 
        //calculating per acr
        List<Cropdetails> cnp = db.getAll(cropName+"factor"); //db.getAll(cropName,"Divided by Deficiency Factor");   
        
        System.out.println("Size:::::::::::"+cnp.size());
        for(Cropdetails cn:cnp){
        	
        	  String cnN=cn.getN();
        	  String cnP=cn.getP();
        	  String cnK=cn.getK();
        	  String cnCa=cn.getCa();
        	  String cnMg=cn.getMg();
        	  String cnS=cn.getS();
        	  String cnFe=cn.getFe();
        	  String cnZn=cn.getZn();
        	  String cnMn=cn.getMn();
        	  String cnCu=cn.getCu();
        	  String cnB=cn.getB();
        	  
        	  System.out.println("1st iteration");
              System.out.println("n:"+cnN);
              System.out.println("p:"+cnP);
              System.out.println("k:"+cnK);
              System.out.println("ca:"+cnCa);
              System.out.println("mg:"+cnMg);
              System.out.println("s:"+cnS);
              System.out.println("fe:"+cnFe);
              System.out.println("zn:"+cnZn);
              System.out.println("mn:"+cnMn);
              System.out.println("cu:"+cnCu);
              System.out.println("b:"+cnB);
      	  
        	  cnN=(cnN==null || cnN.equalsIgnoreCase("")) ? "1.0" : cnN;
        	  cnP=(cnP==null || cnP.equalsIgnoreCase("")) ? "1.0" : cnP;
        	  cnK=( cnK==null || cnK.equalsIgnoreCase("")) ? "1.0" : cnK;
        	  cnCa=(cnCa==null || cnCa.equalsIgnoreCase("") ) ? "1.0" : cnCa;
        	  cnMg=( cnMg==null || cnMg.equalsIgnoreCase("")) ? "1.0" : cnMg;
        	  cnS=(cnS==null ||cnN.equalsIgnoreCase("")  ) ? "1.0" : cnS;
        	  cnFe=(cnFe==null || cnN.equalsIgnoreCase("") ) ? "1.0" : cnFe;
        	  cnZn=(cnZn==null || cnN.equalsIgnoreCase("")  ) ? "1.0" : cnZn;
        	  cnMn=(cnMn==null || cnN.equalsIgnoreCase("") ) ? "1.0" : cnMn;
        	  cnCu=( cnCu==null || cnN.equalsIgnoreCase("")) ? "1.0" : cnCu;
        	  cnB=(cnB==null || cnN.equalsIgnoreCase("") ) ? "1.0" : cnB;
        	
        	
        	n=n/Double.parseDouble(cnN);
        	p=p/Double.parseDouble(cnP);
        	k=k/Double.parseDouble(cnK);
            ca=ca/Double.parseDouble(cnCa);
            mg=mg/Double.parseDouble(cnMg);
            s=s/Double.parseDouble(cnS);
            fe=fe/Double.parseDouble(cnFe);
            zn=zn/Double.parseDouble(cnZn);
            mn=mn/Double.parseDouble(cnMn);
            cu=cu/Double.parseDouble(cnCu);
            b=b/Double.parseDouble(cnB);
            
            multiPlyNumAcr=cn.getNa();
            
            System.out.println("2nd iteration");
            System.out.println("n:"+n);
            System.out.println("p:"+p);
            System.out.println("k:"+k);
            System.out.println("ca:"+ca);
            System.out.println("mg:"+mg);
            System.out.println("s:"+s);
            System.out.println("fe:"+fe);
            System.out.println("zn:"+zn);
            System.out.println("mn:"+mn);
            System.out.println("cu:"+cu);
            System.out.println("b:"+b);
       
        }
        //D17 Check done
        n=  (n < 2) ? 0 : n;
        p=  (p < 2) ? 0 : p;
        k=  (k < 2) ? 0 : k;
        ca=  (ca < 2) ? 0 : ca;
        mg=  (mg < 2) ? 0 : mg;
        s=  (s < 2) ? 0 : s;
        fe=  (n < 2) ? 0 : fe;
        zn=  (n < 2) ? 0 : zn;
        mn=  (n < 2) ? 0 : mn;
        cu=  (n < 2) ? 0 : cu;
        b=  (n < 2) ? 0 : b;
        
        if(multiPlyNumAcr!=null && !multiPlyNumAcr.equalsIgnoreCase("")){
        
        n=(n* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        p=(p* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        k=(k* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        ca=(ca* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        mg=(mg* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        s=(s* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        fe=(fe* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        zn=(zn* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        mn=(mn* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        cu=(cu* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        b=(b* Double.parseDouble(acrs))/Double.parseDouble(multiPlyNumAcr);
        }
        else{
        	 System.out.println("Multiplier acr is nullllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
             
        }
        
        
        System.out.println("*********************************************************************Phase iii*********************************************************************");
    	      
        System.out.println("FINNNNNNNNNNNNNNNNNNNNNNNNNLLLLLLLLLLLYYYYYYYYYY OUT PUT IS::::::::::::::::");
        System.out.println("n:"+n);
        System.out.println("p:"+p);
        System.out.println("k:"+k);
        System.out.println("ca:"+ca);
        System.out.println("mg:"+mg);
        System.out.println("s:"+s);
        System.out.println("fe:"+fe);
        System.out.println("zn:"+zn);
        System.out.println("mn:"+mn);
        System.out.println("cu:"+cu);
        System.out.println("b:"+b);
        
        hashMap.put("N", n+"");
        hashMap.put("P", p+"");
        hashMap.put("K", k+"");
        hashMap.put("CA", ca+"");
        hashMap.put("MG", mg+"");
        hashMap.put("S", s+"");
        hashMap.put("FE", fe+"");
        hashMap.put("ZN", zn+"");
        hashMap.put("MN", mn+"");
        hashMap.put("CU", cu+"");
        hashMap.put("B", b+"");
        
        
        db.truncAll();
       
        
        return hashMap;
	}

}
