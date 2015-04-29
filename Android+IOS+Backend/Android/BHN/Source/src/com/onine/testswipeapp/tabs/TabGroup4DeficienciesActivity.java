package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  TabGroup4DeficienciesActivity                                                  //
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
import com.onine.testswipeapp.R.drawable;
import com.onine.testswipeapp.R.id;
import com.onine.testswipeapp.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class TabGroup4DeficienciesActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deficiencies);
	}
	
	public void button1Click(View view){
		Button button1=(Button)findViewById(R.id.tab4_button1);
		Button button2=(Button)findViewById(R.id.tab4_button2);
		Button button3=(Button)findViewById(R.id.tab4_button3);
//		button1.setBackground(R.drawable.button_selected);
		button1.setBackgroundResource(R.drawable.button_selected);
		button1.setTextColor(Color.WHITE);
		button2.setBackgroundResource(R.drawable.button_unselected);
		button2.setTextColor(Color.BLACK);
		button3.setBackgroundResource(R.drawable.button_unselected);
		button3.setTextColor(Color.BLACK);
		
	}
	
	public void button2Click(View view){
		Button button1=(Button)findViewById(R.id.tab4_button1);
		Button button2=(Button)findViewById(R.id.tab4_button2);
		Button button3=(Button)findViewById(R.id.tab4_button3);
//		button1.setBackground(R.drawable.button_selected);
		button1.setBackgroundResource(R.drawable.button_unselected);
		button1.setTextColor(Color.BLACK);
		button2.setBackgroundResource(R.drawable.button_selected);
		button2.setTextColor(Color.WHITE);
		button3.setBackgroundResource(R.drawable.button_unselected);
		button3.setTextColor(Color.BLACK);
		
	}
	
	
	public void button3Click(View view){
		Button button1=(Button)findViewById(R.id.tab4_button1);
		Button button2=(Button)findViewById(R.id.tab4_button2);
		Button button3=(Button)findViewById(R.id.tab4_button3);
//		button1.setBackground(R.drawable.button_selected);
		button1.setBackgroundResource(R.drawable.button_unselected);
		button1.setTextColor(Color.BLACK);
		button2.setBackgroundResource(R.drawable.button_unselected);
		button2.setTextColor(Color.BLACK);
		button3.setBackgroundResource(R.drawable.button_selected);
		button3.setTextColor(Color.WHITE);
		
	}
	
	
	public void clorosisYesClick(View view){
		Button button_clorosisYes=(Button)findViewById(R.id.tab4_clorosisYes);
		Button button_clorosisNo=(Button)findViewById(R.id.tab4_clorosisNo);
		button_clorosisYes.setBackgroundResource(R.drawable.button_selected);
		button_clorosisYes.setTextColor(Color.WHITE);
		button_clorosisNo.setBackgroundResource(R.drawable.button_unselected);
		button_clorosisNo.setTextColor(Color.BLACK);
		
	}
	
	public void clorosisNoClick(View view){
		Button button_clorosisYes=(Button)findViewById(R.id.tab4_clorosisYes);
		Button button_clorosisNo=(Button)findViewById(R.id.tab4_clorosisNo);
		button_clorosisYes.setBackgroundResource(R.drawable.button_unselected);
		button_clorosisYes.setTextColor(Color.BLACK);
		button_clorosisNo.setBackgroundResource(R.drawable.button_selected);
		button_clorosisNo.setTextColor(Color.WHITE);
		
	}
	
	
	public void necrosisYesClick(View view){
		Button button_necrosisYes=(Button)findViewById(R.id.tab4_necrosisYes);
		Button button_necrosisNo=(Button)findViewById(R.id.tab4_necrosisNo);
		button_necrosisYes.setBackgroundResource(R.drawable.button_selected);
		button_necrosisYes.setTextColor(Color.WHITE);
		button_necrosisNo.setBackgroundResource(R.drawable.button_unselected);
		button_necrosisNo.setTextColor(Color.BLACK);
		
	}
	
	public void necrosisNoClick(View view){
		Button button_necrosisYes=(Button)findViewById(R.id.tab4_necrosisYes);
		Button button_necrosisNo=(Button)findViewById(R.id.tab4_necrosisNo);
		button_necrosisYes.setBackgroundResource(R.drawable.button_unselected);
		button_necrosisYes.setTextColor(Color.BLACK);
		button_necrosisNo.setBackgroundResource(R.drawable.button_selected);
		button_necrosisNo.setTextColor(Color.WHITE);
		
	}
	

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deficiencies, menu);
		return true;
	}*/

}
