package com.onine.springservice.domain;

public class Products {

	private int id;
	private String name;
	private String imageurl;
	private String type;
	private String sdfPath;
	
	public String getSdfPath() {
		return sdfPath;
	}
	public void setSdfPath(String sdfPath) {
		this.sdfPath = sdfPath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return  name;
	}
	
	
	
		
}

