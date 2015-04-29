package com.onine.testswipeapp.setting.testinstruction.utility;
//************************************************************************//
//                                                                        //
// Name        =  TestInstructionsVO                                                  //
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

public class TestInstructionsVO {
	
	String id;
	String plantAppearance;
	String dataSentToLab;
	String partToSample;
	String plantName;
	String specialInstructions;
	String whenToTakeSample;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlantAppearance() {
		return plantAppearance;
	}
	public void setPlantAppearance(String plantAppearance) {
		this.plantAppearance = plantAppearance;
	}
	public String getDataSentToLab() {
		return dataSentToLab;
	}
	public void setDataSentToLab(String dataSentToLab) {
		this.dataSentToLab = dataSentToLab;
	}
	public String getPartToSample() {
		return partToSample;
	}
	public void setPartToSample(String partToSample) {
		this.partToSample = partToSample;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}
	public String getWhenToTakeSample() {
		return whenToTakeSample;
	}
	public void setWhenToTakeSample(String whenToTakeSample) {
		this.whenToTakeSample = whenToTakeSample;
	}
	public TestInstructionsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PlantsTestInstructionsVO [id=" + id + ", plantAppearance="
				+ plantAppearance + ", dataSentToLab=" + dataSentToLab
				+ ", partToSample=" + partToSample + ", plantName=" + plantName
				+ ", specialInstructions=" + specialInstructions
				+ ", whenToTakeSample=" + whenToTakeSample + "]";
	}
	
	
	

}
