package com.onine.testswipeapp.splash;
//************************************************************************//
//                                                                        //
// Name        =  SplashScreen                                                  //
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

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.R.layout;
import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;
import com.onine.testswipeapp.db.sqllite.model.UnitMeasurement;
import com.onine.testswipeapp.tabs.TabSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

	private static int SPLASH_TIME_OUT = 3500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		System.out.println("creating table");
		db.createTableUnitMeasurement();
		System.out.println("table created");
		
		UnitMeasurement unitMeasurement =new UnitMeasurement("1", "Acre", "Gallons/Ounces");
		db.createUnitMeasurement(unitMeasurement);
		System.out.println("Default units got set.");
		// Don't forget to close database connection
				db.closeDB();
		
		
		
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				Intent i = new Intent(SplashScreen.this, TabSample.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
		
		
		

	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}
*/
}
