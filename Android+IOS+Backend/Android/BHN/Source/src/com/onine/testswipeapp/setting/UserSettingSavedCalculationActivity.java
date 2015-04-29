package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  UserSettingSavedCalculationActivity                                                  //
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

import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Date;import java.util.List;import android.app.ListActivity;import android.content.Intent;import android.os.Bundle;import android.view.Menu;import android.view.View;import android.widget.AdapterView;import android.widget.AdapterView.OnItemClickListener;import android.widget.ListView;import com.onine.testswipeapp.R;import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;import com.onine.testswipeapp.db.sqllite.model.Result;import com.onine.testswipeapp.setting.pojos.SavedCalculationRowData;public class UserSettingSavedCalculationActivity extends ListActivity {	protected void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);		setContentView(R.layout.activity_user_setting_saved_calculation);		SavedCalculationsListAdapter adapter= new SavedCalculationsListAdapter(this, getModel());		setListAdapter(adapter);						ListView lv = getListView();		   lv.setOnItemClickListener(new OnItemClickListener()		   {		      @Override		      public void onItemClick(AdapterView<?> adapter, View v, int position,		            long arg3) 		      {		            SavedCalculationRowData value = (SavedCalculationRowData)adapter.getItemAtPosition(position);		            		            System.out.println("Item at position : "+value.getArea());		            		            Intent intent = new Intent(UserSettingSavedCalculationActivity.this, UserSettingSavedCalculationDetailActivity.class);		            intent.putExtra("id", value.getId()+"");		            startActivity(intent);		      }		   });			}				private List<SavedCalculationRowData> getModel() {	    List<SavedCalculationRowData> list = new ArrayList<SavedCalculationRowData>();	    	    list.add(new SavedCalculationRowData(987,"Field 55", "  05 May 2014"));	    list.add(new SavedCalculationRowData(887,"Field 56", "  06 May 2014"));	    list.add(new SavedCalculationRowData(787,"Field 57", "  07 May 2014"));	    list.add(new SavedCalculationRowData(687,"Field 58", "  08 May 2014"));	    list.add(new SavedCalculationRowData(587,"Field 59", "  09 May 2014"));	    list.add(new SavedCalculationRowData(487,"Field 60", "  10 May 2014"));	    	    DatabaseHelper db = new DatabaseHelper(getApplicationContext());	    List<Result> results=db.getAllRedults();	 	db.closeDB();	    System.out.println("Resluts are: "+results);		for(Result result : results){			String date=getDisplayDate(result.getCreated());						list.add(new SavedCalculationRowData(result.getId(),result.getArea(), "  "+date));					}	    	    	    list.get(1).setSelected(true);	    return list;	  }		public String getDisplayDate(String datestr){				Date date;		String myDate ="";		try {			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datestr);			myDate= new SimpleDateFormat("dd-MM-yyyy").format(date);		} catch (ParseException e) {			e.printStackTrace();		}				return myDate;	}				@Override	public boolean onCreateOptionsMenu(Menu menu) {		getMenuInflater().inflate(R.menu.user_setting_saved_calculation, menu);		return true;	}}