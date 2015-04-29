package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  OptionsActivity                                                  //
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
import com.onine.testswipeapp.tabs.CalculatorScreen1Activity;
import com.onine.testswipeapp.tabs.TabGroupActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * @author Administrator
 *
 */
public class OptionsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionspage);
        
        Button back = (Button) findViewById(R.id.BackButton1);
        Button next = (Button) findViewById(R.id.NextButton1);
        
        OnTouchListener backListener = new OnTouchListener() {
                public boolean  onTouch  (View  v, MotionEvent  event) {
                    if (event.getAction()==MotionEvent.ACTION_UP){
                        finish();
                        //return true;
                    }
                    return false;
                }
            };
            
        OnTouchListener nextListener = new OnTouchListener() {
        	public boolean onTouch(View v, MotionEvent event) {
        		 if (event.getAction()==MotionEvent.ACTION_UP){
        			 Intent calcScreen1 = new Intent(getParent(), CalculatorScreen1Activity.class);
             		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
             		parentActivity.startChildActivity("CalculatorScreen1Activity", calcScreen1);
             		return true;
        		 }
        		 return false;
        	}
        };
        
        back.setOnTouchListener(backListener);
        next.setOnTouchListener(nextListener);
    }
}
