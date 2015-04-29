package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  UserSettingSavedCalculationDetailActivity                                                  //
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

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;
import com.onine.testswipeapp.db.sqllite.model.Result;

public class UserSettingSavedCalculationDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_setting_saved_calculation_detail);
		
		Intent intent = getIntent();
		String id = intent.getStringExtra("id");
		
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
	    Result results=db.getRedultByArea(Integer.parseInt(id));
	    
	 // Don't forget to close database connection
	 	db.closeDB();
	 	
	 	
	 	TextView textViewN=(TextView)findViewById(R.id.N); textViewN.setText(results.getN());
	 	TextView textViewP=(TextView)findViewById(R.id.P); textViewP.setText(results.getP());
	 	TextView textViewK=(TextView)findViewById(R.id.K); textViewK.setText(results.getK());
	 	TextView textViewCA=(TextView)findViewById(R.id.CA); textViewCA.setText(results.getCA());
	 	TextView textViewMG=(TextView)findViewById(R.id.MG); textViewMG.setText(results.getMG());
	 	TextView textViewS=(TextView)findViewById(R.id.S); textViewS.setText(results.getS());
	 	
	 	TextView textViewFE=(TextView)findViewById(R.id.FE); textViewFE.setText(results.getFE());
	 	TextView textViewZN=(TextView)findViewById(R.id.ZN); textViewZN.setText(results.getZN());
	 	TextView textViewMN=(TextView)findViewById(R.id.MN); textViewMN.setText(results.getMN());
	 	TextView textViewCU=(TextView)findViewById(R.id.CU); textViewCU.setText(results.getCU());
	 	TextView textViewB=(TextView)findViewById(R.id.B); textViewB.setText(results.getB());
	 	
	 	
	 	
	 	
		
	}

	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_setting_saved_calculation_detail,
				menu);
		return true;
	}*/

}
