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
