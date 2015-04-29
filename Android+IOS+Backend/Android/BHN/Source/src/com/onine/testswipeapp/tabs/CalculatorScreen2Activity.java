package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorScreen2Activity                                                  //
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
import com.onine.testswipeapp.R.id;
import com.onine.testswipeapp.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorScreen2Activity extends Activity {

	public String N="";
	public String P="";
	public String K="";
	public String CA="";
	public String MG="";
	public String S="";
	public String NA="";
	public String FE="";
	public String ZN="";
	public String MN="";
	public String CU="";
	public String B="";
//	public String N="";
	EditText N1;
	EditText P1;
	EditText K1;
	EditText CA1;
	EditText MG1;
	EditText S1;
	EditText NA1;
	EditText FE1;
	EditText ZN1;
	EditText MN1;
	EditText CU1;
	EditText B1;

	String location;
	String cropType;
	String growthStage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_screen3_new);

		Intent intent=getIntent();
		location= intent.getStringExtra("location");
		cropType=intent.getStringExtra("cropType");
		growthStage=intent.getStringExtra("growthStage");
		
		System.out.println("CalculatorScreen2Activity  -- > Location : "+location+" cropType :"+cropType+"  growthStage  : "+growthStage);
		
		Button calcuScr2 = (Button) findViewById(R.id.btn_calc_screen2);

		N1=(EditText)findViewById(R.id.N);
		P1=(EditText)findViewById(R.id.P);
		K1=(EditText)findViewById(R.id.K);
		CA1=(EditText)findViewById(R.id.CA);
		MG1=(EditText)findViewById(R.id.MG);
		S1=(EditText)findViewById(R.id.S);
		NA1=(EditText)findViewById(R.id.NA);
		FE1=(EditText)findViewById(R.id.FE);
		ZN1=(EditText)findViewById(R.id.ZN);
		MN1=(EditText)findViewById(R.id.MN);
		CU1=(EditText)findViewById(R.id.CU);
		B1=(EditText)findViewById(R.id.B);
		
		
		OnTouchListener calcuScr1Listener = new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				N=N1.getText().toString();
				P=P1.getText().toString();
				K=K1.getText().toString();
				CA=CA1.getText().toString();
				MG=MG1.getText().toString();
				S=S1.getText().toString();
				NA=NA1.getText().toString();
				FE=FE1.getText().toString();
				ZN=ZN1.getText().toString();
				MN=MN1.getText().toString();
				CU=CU1.getText().toString();
				B=B1.getText().toString();
				
				
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent calcScr4Act = new Intent(getParent(),
							CalculatorScreen4Activity.class);
					calcScr4Act.putExtra("location", location);
					calcScr4Act.putExtra("cropType", cropType);
					calcScr4Act.putExtra("growthStage", growthStage);
					calcScr4Act.putExtra("N", N);
					calcScr4Act.putExtra("P", P);
					calcScr4Act.putExtra("K", K);
					calcScr4Act.putExtra("CA", CA);
					calcScr4Act.putExtra("MG", MG);
					calcScr4Act.putExtra("S", S);
					calcScr4Act.putExtra("NA", NA);
					calcScr4Act.putExtra("FE", FE);
					calcScr4Act.putExtra("ZN", ZN);
					calcScr4Act.putExtra("MN", MN);
					calcScr4Act.putExtra("CU", CU);
					calcScr4Act.putExtra("B", B);
					
					TabGroupActivity parentActivity = (TabGroupActivity) getParent();
					parentActivity.startChildActivity(
							"CalculatorScreen4Activity", calcScr4Act);
					return true;
				}
				return false;
			}
		};

		calcuScr2.setOnTouchListener(calcuScr1Listener);
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.deficiencies, menu); return true; }
	 */
}
