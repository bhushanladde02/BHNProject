package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorScreen1Activity                                                  //
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

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



import com.onine.testswipeapp.R;


public class CalculatorScreen1Activity extends Activity {

	public static String areaText="";
	Spinner sp;
	Spinner spinnerCropType;
	Spinner spinnerGrowthStage;
	List<String> li;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen2);
		
		li=getAreaList();
		
		sp=(Spinner) findViewById(R.id.spinner1location);
		
		ArrayAdapter<String> adp=new ArrayAdapter<String>(this, 
				android.R.layout.simple_dropdown_item_1line,li);
		sp.setAdapter(adp);
		sp.setSelection(li.indexOf(li.get(li.size()-1)));
		
		Button calcuScr1 = (Button) findViewById(R.id.btn_calc_screen1);
		spinnerCropType = (Spinner)findViewById(R.id.spinner2CropType);
		spinnerGrowthStage = (Spinner)findViewById(R.id.spinner3GowthStage);
        OnTouchListener calcuScr1Listener = new OnTouchListener() {
            public boolean  onTouch  (View  v, MotionEvent  event) {
                if (event.getAction()==MotionEvent.ACTION_UP){
                	
                	String location = sp.getSelectedItem().toString();
                	String cropType=spinnerCropType.getSelectedItem().toString();
                	String growthStage=spinnerGrowthStage.getSelectedItem().toString();
                	
                	System.out.println(":::: Location : "+location+"  :::: cropType : "+cropType+"  ::::Growth Stage : "+growthStage);
                	
                	Intent calcScr2Act = new Intent(getParent(), CalculatorScreen2Activity.class);
                	calcScr2Act.putExtra("location", location);
                	calcScr2Act.putExtra("cropType", cropType);
                	calcScr2Act.putExtra("growthStage", growthStage);
             		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
             		parentActivity.startChildActivity("CalculatorScreen2Activity", calcScr2Act);
             		return true;
                }
                return false;
            }
        };
        
        calcuScr1.setOnTouchListener(calcuScr1Listener);
        
        
	}
	
	
	public void setList(Spinner sp, List<String> li, String newArea){
		
		ArrayAdapter<String> adp=new ArrayAdapter<String>(this, 
				android.R.layout.simple_dropdown_item_1line,li);
		sp.setAdapter(adp);
		
		sp.setSelection(li.indexOf(newArea));
	}
	
	
	public void buttonAddAreaClick(View view){
		
		System.out.println("In the method...");
		//
		
		// Create custom dialog object
        final Dialog dialog = new Dialog(getParent());
        System.out.println("Created dialogue object");
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_box_area);
        System.out.println("COntent vide set");
        // Set dialog title
        dialog.setTitle("Enter Field Name");
        System.out.println("Title set");

        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textDialog);
        text.setText("");
        

        System.out.println("Calling dialogue.show");
        dialog.show();
         
        Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
            	
            	
            	EditText editArea=(EditText)dialog.findViewById(R.id.areaText);
            	CalculatorScreen1Activity.areaText=editArea.getText().toString();
            	
                dialog.dismiss();
                
                
              //-------------------
        		
        		String newArea=CalculatorScreen1Activity.areaText;
        		
        		li.add(newArea);
        		sp=(Spinner) findViewById(R.id.spinner1location);
        		
        		System.out.println("New area is: : : "+newArea);
        		setList(sp, li, newArea);
            }
        });
		
		
        
        
        
		
		
	}
	
	
	
	public List<String> getAreaList(){
		List<String> list=new ArrayList<String>();
		
		list.add("Field 1");
		list.add("Field 2");
		list.add("Field 3");
		list.add("Field 4");
		list.add("Field 5");
		
		
		
		return list;
	}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deficiencies, menu);
		return true;
	}
*/
}
