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

public class Cropdetails {
	private String	id;	
	private String	croptype;	
	private String	growthstage;	
	private String	nd3_n;	
	private String	pd4_p;	
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
	private String	totalacrs;	
	private String	result;
	private String	isrecomm;
	private String	andr_or_i_phn;	
	private String	deviceid_n;	
	private String	extracolom;
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
	public String getNd3_n() {
		return nd3_n;
	}
	public void setNd3_n(String nd3N) {
		nd3_n = nd3N;
	}
	public String getPd4_p() {
		return pd4_p;
	}
	public void setPd4_p(String pd4P) {
		pd4_p = pd4P;
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
	public String getTotalacrs() {
		return totalacrs;
	}
	public void setTotalacrs(String totalacrs) {
		this.totalacrs = totalacrs;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIsrecomm() {
		return isrecomm;
	}
	public void setIsrecomm(String isrecomm) {
		this.isrecomm = isrecomm;
	}
	public String getAndr_or_i_phn() {
		return andr_or_i_phn;
	}
	public void setAndr_or_i_phn(String andrOrIPhn) {
		andr_or_i_phn = andrOrIPhn;
	}
	public String getDeviceid_n() {
		return deviceid_n;
	}
	public void setDeviceid_n(String deviceidN) {
		deviceid_n = deviceidN;
	}
	public String getExtracolom() {
		return extracolom;
	}
	public void setExtracolom(String extracolom) {
		this.extracolom = extracolom;
	}
	@Override
	public String toString() {
		return "Cropdetails [andr_or_i_phn=" + andr_or_i_phn + ", b=" + b
				+ ", ca=" + ca + ", croptype=" + croptype + ", cu=" + cu
				+ ", deviceid_n=" + deviceid_n + ", extracolom=" + extracolom
				+ ", fe=" + fe + ", growthstage=" + growthstage + ", id=" + id
				+ ", isrecomm=" + isrecomm + ", k=" + k + ", mg=" + mg
				+ ", mn=" + mn + ", n=" + n + ", na=" + na + ", nd3_n=" + nd3_n
				+ ", p=" + p + ", pd4_p=" + pd4_p + ", result=" + result
				+ ", s=" + s + ", totalacrs=" + totalacrs + ", zn=" + zn + "]";
	}
	
	

}