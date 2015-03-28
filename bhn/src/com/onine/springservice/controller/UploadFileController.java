package com.onine.springservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletConfig;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.*;

import org.springframework.web.multipart.MultipartFile;

import com.onine.springservice.dao.ProductService;
import com.onine.springservice.dao.UpdateImagePathService;
import com.onine.springservice.domain.LoginModel;
import com.onine.springservice.domain.Products;
import com.onine.springservice.domain.UploadItem;
import com.onine.springservice.utility.DBUtility;

@Controller
@RequestMapping(value = "/uploadfile")
public class UploadFileController  {
	private String uploadFolderPath;
	ServletConfig config;
	ProductService prd= new ProductService();


	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model,HttpServletRequest request, HttpServletResponse response) {
		LoginModel loginModel = (LoginModel)request.getSession().getAttribute("user");
		if(loginModel!=null){
		System.out.println(loginModel.getUserName());
		model.addAttribute(new UploadItem());
	
		
		
		model.addAttribute("list", prd.getListName());
		return "/uploadfile";
		}
		else
		{
			System.out.println("Logg off session");
			
			
			return "logout";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "/uploadfile";
		}
		String selectedValue=uploadItem.getProductList();
		/*if("NONE".equals(selectedValue)){
			ObjectError errors =new ObjectError("productList", "required.product");
			return "/uploadfile";
		   }
		*/
		// Some type of file processing...
		System.err.println("-------------------------------------------");
		try {
			UpdateImagePathService pat = new UpdateImagePathService();
			System.out.println("selectedValue::::::::::::::::::::::::"+selectedValue);
			MultipartFile file = uploadItem.getFileData();
			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				if (file.getSize() > 10000000) {
					System.out.println("File Size:::" + file.getSize());
					return "/uploadfile";
				}
				
				Properties prop = new Properties();
	            InputStream inputStream1 = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
	            prop.load(inputStream1);
	            
	            String domainlink = prop.getProperty("path");
				String nameFile= file.getOriginalFilename().replaceAll("\\s+","");
				System.out.println("size::" + file.getSize());
				
				fileName = domainlink+"/bhnImages/"+ file.getOriginalFilename().replaceAll("\\s+","");
				
				//fileName = domainlink+"\\images\\"+ file.getOriginalFilename().replaceAll("\\s+","");
				
				outputStream = new FileOutputStream(fileName);
				System.out.println(" fileName:::::::"  +fileName);
			
				System.out.println("fileName:" + file.getOriginalFilename().replaceAll("\\s+",""));
				
				int readBytes = 0;
				byte[] buffer = new byte[10000000];
				while ((readBytes = inputStream.read(buffer, 0, 10000000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				

				

				
				
			
				
				pat.imagePathName(nameFile, selectedValue);
			}
			
			//// Sds pdf upload
			MultipartFile file1 = uploadItem.getFileData1();
			String fileName1 = null;
			InputStream inputStream11 = null;
			OutputStream outputStream1 = null;
			if (file1.getSize() > 0) {
				inputStream11 = file1.getInputStream();
				if (file1.getSize() > 100000000) {
					System.out.println("File Size:::" + file1.getSize());
					return "/uploadfile";
				}
				
				Properties prop1 = new Properties();
	            InputStream inputStream111 = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
	            prop1.load(inputStream111);
	            
	            String domainlink1 = prop1.getProperty("path");
				String nameFile1= file1.getOriginalFilename().replaceAll("\\s+","");
				System.out.println("size::" + file1.getSize());
				
				fileName1 = domainlink1+"/sdspdf/"+ file1.getOriginalFilename().replaceAll("\\s+","");
				
				//fileName1 = domainlink1+"\\sdspdf\\"+ file1.getOriginalFilename().replaceAll("\\s+","");
				
				outputStream1 = new FileOutputStream(fileName1);
				System.out.println(" fileName:::::::"  +fileName1);
			
				System.out.println("fileName:" + file1.getOriginalFilename().replaceAll("\\s+",""));
				
				int readBytes1 = 0;
				byte[] buffer1 = new byte[100000000];
				while ((readBytes1 = inputStream11.read(buffer1, 0, 10000000)) != -1) {
					outputStream1.write(buffer1, 0, readBytes1);
				}
				outputStream1.close();
				inputStream11.close();
				pat.imagePdfName1(nameFile1, selectedValue);
			}
         
			// ..........................................
			session.setAttribute("uploadFile", file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:success";
	}

}
