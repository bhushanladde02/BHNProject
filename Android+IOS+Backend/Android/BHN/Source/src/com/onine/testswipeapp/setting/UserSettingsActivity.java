package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  UserSettingsActivity                                                  //
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

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;
import com.onine.testswipeapp.db.sqllite.model.UnitMeasurement;
 
public class UserSettingsActivity extends Activity  {
 

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
//       addPreferencesFromResource(R.xml.settings);
        setContentView(R.layout.activity_user_setting);
        
        
        
 
    }
	
	public void setAcre(View view){
		Button acre=(Button)findViewById(R.id.land_measure1);
		Button hectare=(Button)findViewById(R.id.land_measure2);
		Button mu=(Button)findViewById(R.id.land_measure3);
		acre.setTextColor(0xff0f7dc2);
		hectare.setTextColor(0xff000000);
		mu.setTextColor(0xff000000);
		
		
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Acre", "Gallons/Ounces");
		System.out.println("Updating AreaUtit to Acre");
		db.updateAreaUnit(unitMeasurement);
		System.out.println("Updated Area Unit to Acre.");
		// Don't forget to close database connection
		db.closeDB();
		
	}
	
	public void setHectare(View view){
		Button acre=(Button)findViewById(R.id.land_measure1);
		Button hectare=(Button)findViewById(R.id.land_measure2);
		Button mu=(Button)findViewById(R.id.land_measure3);
		acre.setTextColor(0xff000000);
		hectare.setTextColor(0xff0f7dc2);
		mu.setTextColor(0xff000000);
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Hectare", "Gallons/Ounces");
		System.out.println("Updating AreaUtit to Hectare");
		db.updateAreaUnit(unitMeasurement);
		System.out.println("Updated Area Unit to Hectare.");
		// Don't forget to close database connection
		db.closeDB();
	}

	public void setMu(View view){
	
		Button acre=(Button)findViewById(R.id.land_measure1);
		Button hectare=(Button)findViewById(R.id.land_measure2);
		Button mu=(Button)findViewById(R.id.land_measure3);
		acre.setTextColor(0xff000000);
		hectare.setTextColor(0xff000000);
		mu.setTextColor(0xff0f7dc2);
		
		
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Mu", "Gallons/Ounces");
		System.out.println("Updating AreaUtit to Mu");
		db.updateAreaUnit(unitMeasurement);
		System.out.println("Updated Area Unit to Mu.");
		// Don't forget to close database connection
		db.closeDB();
	}
	
	public void setGallonsOunces(View view){
		Button gallons_ounces=(Button)findViewById(R.id.gallons_ounces);
		Button liters_mililiters=(Button)findViewById(R.id.liters_mililiters);
		gallons_ounces.setTextColor(0xff0f7dc2);
		liters_mililiters.setTextColor(0xff000000);
		
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Acre", "Gallons/Ounces");
		System.out.println("Updating product Unit to Gallons/Ounces");
		db.updateProductUnit(unitMeasurement);
		System.out.println("Updated product Unit to Gallons/Ounces.");
		// Don't forget to close database connection
		db.closeDB();
		
		
	}
	
	public void setLitersMililiters(View view){
		
		Button gallons_ounces=(Button)findViewById(R.id.gallons_ounces);
		Button liters_mililiters=(Button)findViewById(R.id.liters_mililiters);
		gallons_ounces.setTextColor(0xff000000);
		liters_mililiters.setTextColor(0xff0f7dc2);
		
		
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Acre", "Liters/Mililiters");
		System.out.println("Updating product Unit to Liters/Mililiters.");
		db.updateProductUnit(unitMeasurement);
		System.out.println("Updated product Unit to Liters/Mililiters.");
		// Don't forget to close database connection
		db.closeDB();
	}
}
