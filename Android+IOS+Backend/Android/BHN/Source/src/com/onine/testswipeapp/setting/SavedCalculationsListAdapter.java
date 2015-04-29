package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  SavedCalculationsListAdapter                                                  //
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
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.setting.pojos.SavedCalculationRowData;

public class SavedCalculationsListAdapter extends
		ArrayAdapter<SavedCalculationRowData> {

	private final Activity context;
	private final List<SavedCalculationRowData> rowData;

	public SavedCalculationsListAdapter(Activity context,
			List<SavedCalculationRowData> rowData) {
		super(context, R.layout.settings_showresults_row_layout, rowData);
		this.context = context;
		this.rowData = rowData;
	}

	static class ViewHolder {
		protected TextView area;
		protected TextView date;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.settings_showresults_row_layout,null);
			TextView area = (TextView) view.findViewById(R.id.area);
			TextView date = (TextView) view.findViewById(R.id.date);
			
			area.setText(rowData.get(position).getArea());
			area.setHint(rowData.get(position).getId()+"");
			date.setText(rowData.get(position).getDate());
		} else {
			view = convertView;
			TextView area = (TextView) view.findViewById(R.id.area);
			TextView date = (TextView) view.findViewById(R.id.date);
			area.setText(rowData.get(position).getArea());
			date.setText(rowData.get(position).getDate());
		}

		return view;
	}

}
