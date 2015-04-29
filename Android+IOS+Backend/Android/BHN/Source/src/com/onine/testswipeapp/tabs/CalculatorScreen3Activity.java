package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorScreen3Activity                                                  //
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


public class CalculatorScreen3Activity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_screen4);
		
		
		Button calcuScr3 = (Button) findViewById(R.id.btn_calc_screen3);

		OnTouchListener calcuScr1Listener = new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent calcScr4Act = new Intent(getParent(),
							CalculatorScreen4Activity.class);
					TabGroupActivity parentActivity = (TabGroupActivity) getParent();
					parentActivity.startChildActivity(
							"CalculatorScreen4Activity", calcScr4Act);
					return true;
				}
				return false;
			}
		};

		calcuScr3.setOnTouchListener(calcuScr1Listener);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deficiencies, menu);
		return true;
	}
*/
}
