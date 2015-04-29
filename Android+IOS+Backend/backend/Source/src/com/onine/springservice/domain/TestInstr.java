//************************************************************************//
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
// Status      = Version 01 Release 07 Modification Level 08              //
//                                                                        //
// Compiler    = Java Standard Edition (build 1.7)                        //                    
//                                                                        //
// Change Activity:                                                       //
//                                                                        //
// Feature/Defect     Date                Description                     //
// --------------  ----------  ------------------------------------------ //
// R12493   - YP  2014/09/26    Part Created                              //
//************************************************************************//
package com.onine.springservice.domain;

public class TestInstr {
	private String id;
	private String PlantName;
	private String WhenToTakeSample;
	private String plantAppearance;
	private String PartToSample;
	private String DataSentToLab;
	private String SpecialInstructions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlantName() {
		return PlantName;
	}
	public void setPlantName(String plantName) {
		PlantName = plantName;
	}
	public String getWhenToTakeSample() {
		return WhenToTakeSample;
	}
	public void setWhenToTakeSample(String whenToTakeSample) {
		WhenToTakeSample = whenToTakeSample;
	}
	public String getPlantAppearance() {
		return plantAppearance;
	}
	public void setPlantAppearance(String plantAppearance) {
		this.plantAppearance = plantAppearance;
	}
	public String getPartToSample() {
		return PartToSample;
	}
	public void setPartToSample(String partToSample) {
		PartToSample = partToSample;
	}
	public String getDataSentToLab() {
		return DataSentToLab;
	}
	public void setDataSentToLab(String dataSentToLab) {
		DataSentToLab = dataSentToLab;
	}
	public String getSpecialInstructions() {
		return SpecialInstructions;
	}
	public void setSpecialInstructions(String specialInstructions) {
		SpecialInstructions = specialInstructions;
	}
	
	
}
