package com.onine.testswipeapp.db.sqllite.model;
//************************************************************************//
//                                                                        //
// Name        =  UnitMeasurement                                                  //
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

public class UnitMeasurement {
	int id;
	String unitid;
	String areaUnit;
	String productUnit;
	public UnitMeasurement(int id, String unitid, String areaUnit,
			String productUnit) {
		super();
		this.id = id;
		this.unitid = unitid;
		this.areaUnit = areaUnit;
		this.productUnit = productUnit;
	}
	public UnitMeasurement(String unitid, String areaUnit, String productUnit) {
		super();
		this.unitid = unitid;
		this.areaUnit = areaUnit;
		this.productUnit = productUnit;
	}
	public UnitMeasurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public String getAreaUnit() {
		return areaUnit;
	}
	public void setAreaUnit(String areaUnit) {
		this.areaUnit = areaUnit;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	@Override
	public String toString() {
		return "UnitMeasurement [unitid=" + unitid + ", areaUnit=" + areaUnit
				+ ", productUnit=" + productUnit + "]";
	}

	
	
}
