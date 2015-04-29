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

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {
	private String filename;
	private CommonsMultipartFile fileData;
	private CommonsMultipartFile fileData1;
	private String productList;
	
	public CommonsMultipartFile getFileData1() {
		return fileData1;
	}

	public void setFileData1(CommonsMultipartFile fileData1) {
		this.fileData1 = fileData1;
	}

	public String getProductList() {
		return productList;
	}

	public void setProductList(String productList) {
		this.productList = productList;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
}
