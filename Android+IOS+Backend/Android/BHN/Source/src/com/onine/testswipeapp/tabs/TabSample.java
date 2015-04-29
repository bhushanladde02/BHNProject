package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  TabSample                                                  //
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
import com.onine.testswipeapp.R.menu;
import com.onine.testswipeapp.setting.UserSettingSavedCalculationActivity;
import com.onine.testswipeapp.setting.UserSettingTestingInstructionActivity;
import com.onine.testswipeapp.setting.UserSettingUpdateAppActivity;
import com.onine.testswipeapp.setting.UserSettingsActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class TabSample extends TabActivity {
	
    
	
	public static void settitle(String title){
		settitle(title);
	}
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getActionBar().setHomeButtonEnabled(true);

        TabHost tabHost = getTabHost();       
      
/*      tabHost.addTab(tabHost.newTabSpec("Calc")
              .setIndicator("CALC")
              .setContent(new Intent(this, TabGroup1Activity.class)));
*/      
      
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab1_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText("Product Calc.");
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
//        icon.setImageResource(R.drawable.tab1_ico);
        tabHost.addTab(tabHost.newTabSpec("Calc")
              .setIndicator(tabIndicator)
              .setContent(new Intent(this, TabGroup1CalculatorActivity.class)));

      
      
      
      
      
      
        View tab2Indicator = LayoutInflater.from(this).inflate(R.layout.tab2_indicator, getTabWidget(), false);
        TextView title2 = (TextView) tab2Indicator.findViewById(R.id.title);
        title2.setText("Products");
        ImageView icon2 = (ImageView) tab2Indicator.findViewById(R.id.icon);
//        icon2.setImageResource(R.drawable.tab2_selected);
      tabHost.addTab(tabHost.newTabSpec("Products")
              .setIndicator(tab2Indicator)
              .setContent(new Intent(this, TabGroup2ProductsActivity.class)));
      
      
      
      
      View tab3Indicator = LayoutInflater.from(this).inflate(R.layout.tab3_indicator, getTabWidget(), false);
      TextView title3 = (TextView) tab3Indicator.findViewById(R.id.title);
      title3.setText("Mixing");
      ImageView icon3 = (ImageView) tab3Indicator.findViewById(R.id.icon);
//      icon3.setImageResource(R.drawable.tab3_selected);
      tabHost.addTab(tabHost.newTabSpec("Mix Guide")
              .setIndicator(tab3Indicator)
              .setContent(new Intent(this, TabGroup3MixingGuideActivity.class)));
      
      
      
/*      View tab4Indicator = LayoutInflater.from(this).inflate(R.layout.tab4_indicator, getTabWidget(), false);
      TextView title4 = (TextView) tab4Indicator.findViewById(R.id.title);
      title4.setText("Deficiencies");
      ImageView icon4 = (ImageView) tab4Indicator.findViewById(R.id.icon);
      icon4.setImageResource(R.drawable.tab4_selected);
      tabHost.addTab(tabHost.newTabSpec("Deficiencies")
              .setIndicator(tab4Indicator)
              .setContent(new Intent(this, TabGroup4DeficienciesActivity.class)));
*/
      tabHost.setCurrentTab(0); 
    }
    
private static final int RESULT_SETTINGS = 1;
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
 
        case R.id.menu_settings:
            Intent i = new Intent(this, UserSettingsActivity.class);
            startActivityForResult(i, RESULT_SETTINGS);
            break;
            
        case R.id.menu_testing_instructions:
            Intent testing_instructions = new Intent(this, UserSettingTestingInstructionActivity.class);
            startActivityForResult(testing_instructions, RESULT_SETTINGS);
            break;
            
        case R.id.menu_saved_calculations:
            Intent Saved_calculation = new Intent(this, UserSettingSavedCalculationActivity.class);
            startActivityForResult(Saved_calculation, RESULT_SETTINGS);
            break;
        
        case R.id.menu_update_app:
            Intent update_application = new Intent(this, UserSettingUpdateAppActivity.class);
            startActivityForResult(update_application, RESULT_SETTINGS);
            break;
         
        case android.R.id.home:
        	System.out.println("APP ICON CLICKED ::::");
        	Intent intent = new Intent(this, TabSample.class);            
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(intent); 
            break;
 
        }
 
        return true;
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
       switch (requestCode) {
        case RESULT_SETTINGS:
            //showUserSettings();
            break;
 
        }
 
    }
}