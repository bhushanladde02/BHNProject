package com.onine.testswipeapp.tabs.calculator.utility;
//************************************************************************//
//                                                                        //
// Name        =  Cropdetails                                                  //
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

public class Cropdetails {
	private String	id;	
	private String	croptype;	
	private String	growthstage;	
	private String	n;	
	private String	p;	
	private String	k;	
	private String	ca;	
	private String	mg;	
	private String	s;	
	private String	na;	
	private String	fe;	
	private String	zn;	
	private String	mn;	
	private String	cu;	
	private String	b;
	
	public Cropdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cropdetails(String id, String croptype, String growthstage,
			String n, String p, String k, String ca, String mg, String s,
			String na, String fe, String zn, String mn, String cu, String b) {
		super();
		this.id = id;
		this.croptype = croptype;
		this.growthstage = growthstage;
		this.n = n;
		this.p = p;
		this.k = k;
		this.ca = ca;
		this.mg = mg;
		this.s = s;
		this.na = na;
		this.fe = fe;
		this.zn = zn;
		this.mn = mn;
		this.cu = cu;
		this.b = b;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCroptype() {
		return croptype;
	}
	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}
	public String getGrowthstage() {
		return growthstage;
	}
	public void setGrowthstage(String growthstage) {
		this.growthstage = growthstage;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getMg() {
		return mg;
	}
	public void setMg(String mg) {
		this.mg = mg;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
	public String getFe() {
		return fe;
	}
	public void setFe(String fe) {
		this.fe = fe;
	}
	public String getZn() {
		return zn;
	}
	public void setZn(String zn) {
		this.zn = zn;
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public String getCu() {
		return cu;
	}
	public void setCu(String cu) {
		this.cu = cu;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "Cropdetails [id=" + id + ", croptype=" + croptype
				+ ", growthstage=" + growthstage + ", n=" + n + ", p=" + p
				+ ", k=" + k + ", ca=" + ca + ", mg=" + mg + ", s=" + s
				+ ", na=" + na + ", fe=" + fe + ", zn=" + zn + ", mn=" + mn
				+ ", cu=" + cu + ", b=" + b + "]";
	}	

	

}