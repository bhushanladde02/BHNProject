package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  TabGroup1CalculatorActivity                                                  //
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

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;

public class TabGroup1CalculatorActivity extends TabGroupActivity {
	public static TabSample tabsample;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
        
        TabSample myTabs = (TabSample) this.getParent();
        myTabs.setTitle("Product Calculator");
        
        
        startChildActivity("CalculatorScreen1Activity", new Intent(this,CalculatorScreen1Activity.class));
    }
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
	}
}
