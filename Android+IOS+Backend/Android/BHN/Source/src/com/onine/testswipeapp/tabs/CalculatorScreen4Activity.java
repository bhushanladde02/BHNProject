package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorScreen4Activity                                                  //
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
import java.util.Set;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.R.id;
import com.onine.testswipeapp.R.layout;
import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;
import com.onine.testswipeapp.db.sqllite.model.UnitMeasurement;
import com.onine.testswipeapp.tabs.calculator.utility.CalculatorService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorScreen4Activity extends Activity {

	public static String cropName="ALMONDS";
	public static String growthStage="1";
	public static String acrs="10";
	public static String location="";
	
	
	public static String labN="";
	public static String labP="1.0";
	public static String labK="1.0";
	public static String labCa="1.0";
	public static String labMg="1.0";
	public static String labS="1.0";
	public static String labFe="1.0";
	public static String labZn="1.0";
	public static String labMn="1.0";
	public static String labCu="1.0";
	public static String labB="1.0";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_screen5);
		
		Intent intent=getIntent();
		System.out.println("CalculatorScreen4Activity  --> Location  :: "+intent.getStringExtra("location")+ " , N : "+ intent.getStringExtra("N"));
		
		labN=intent.getStringExtra("N");
		labP=intent.getStringExtra("P");
		labK=intent.getStringExtra("K");
		labCa=intent.getStringExtra("CA");
		labMg=intent.getStringExtra("MG");
		labS=intent.getStringExtra("S");
		labFe=intent.getStringExtra("FE");
		labZn=intent.getStringExtra("ZN");
		labMn=intent.getStringExtra("MN");
		labCu=intent.getStringExtra("CU");
		labB=intent.getStringExtra("B");
		
		cropName=intent.getStringExtra("cropType");
		growthStage=intent.getStringExtra("growthStage");
		location=intent.getStringExtra("location");
		
		
		
/*		calcScr4Act.putExtra("location", location);
		calcScr4Act.putExtra("cropType", cropType);
		calcScr4Act.putExtra("growthStage", growthStage);
*/
		
		
		
		
		
		Button calcuScr4 = (Button) findViewById(R.id.btn_calc_screen4);

		TextView areaLebel=(TextView)findViewById(R.id.totalareaLebel);
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		
		System.out.println("Updating AreaUtit to Hectare");
		List<UnitMeasurement> unilist=db.getUnitMeasurement();
		UnitMeasurement unitMeasurement=unilist.get(0);
		
		System.out.println("Updated Area Unit to Hectare.");
		// Don't forget to close database connection
		db.closeDB();
		
		areaLebel.setText("Enter Total Numbers of "+unitMeasurement.getAreaUnit()+" to Treat");
		
		
		
		
		
		
		
		
		/*calcuScr4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				System.out.println("In teh OnClick on getResult Button");
				// TODO Auto-generated method stub
				Intent calculationIntent=new Intent(CalculatorScreen4Activity.this, MainActivity.class);
				calculationIntent.putExtra("N", labN);
				calculationIntent.putExtra("P", "");
				calculationIntent.putExtra("K", "");
				startActivity(intent)
			}
		});*/
		
		
		
		OnTouchListener calcuScrActListener = new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent calcScr5Act = new Intent(getParent(),
							CalculatorScreen5Activity.class);
					
					
					CalculatorService calcService=new CalculatorService();
					Map<String, String> inputMap=new HashMap<String, String>();
					inputMap.put("N", labN);
					inputMap.put("P", labP);
					inputMap.put("K", labK);
					inputMap.put("CA", labCa);
					inputMap.put("MG", labMg);
					inputMap.put("S", labS);
					inputMap.put("FE", labFe);
					inputMap.put("ZN", labZn);
					inputMap.put("MN", labMn);
					inputMap.put("CU", labCu);
					inputMap.put("B", labB);
		
					EditText acresInp=(EditText)findViewById(R.id.totalAcresInput);
					
//					acrs=acresInp.getText().toString();
					
					acrs=acresInp.getText().toString();
					Map<String, String> resultMap=calcService.getResult(getApplicationContext(), inputMap, cropName, growthStage, acrs);
					Set<String> keyset=resultMap.keySet();
					//System.out.println(keyset.);
				
					for(String str:keyset){
						System.out.println(str);
						calcScr5Act.putExtra(str, resultMap.get(str));
					}
					calcScr5Act.putExtra("location", location);
					calcScr5Act.putExtra("cropName", cropName);
					calcScr5Act.putExtra("growthStage", growthStage);
					calcScr5Act.putExtra("acrs", acrs);
					
					TabGroupActivity parentActivity = (TabGroupActivity) getParent();
					parentActivity.startChildActivity(
							"CalculatorScreen5Activity", calcScr5Act);
					return true;
				}
				
				
				
//				calculationIntent.putExtra("N", labN);
				
				
				return true;
			}
		};

		calcuScr4.setOnTouchListener(calcuScrActListener);
	}

	
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deficiencies, menu);
		return true;
	}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
