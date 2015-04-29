package com.onine.testswipeapp.db.sqllite.model;
//************************************************************************//
//                                                                        //
// Name        =  Result                                                  //
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

public class Result {
	int id;
	String area;
	String N;
	String P;
	String K;
	String CA;
	String MG;
	String S;
	String FE;
	String ZN;
	String MN;
	String CU;
	String B;
	String created;

	
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Result(int id, String area, String n, String p, String k, String cA,
			String mG, String s, String fE, String zN, String mN, String cU,
			String b) {
		super();
		this.id = id;
		this.area = area;
		N = n;
		P = p;
		K = k;
		CA = cA;
		MG = mG;
		S = s;
		FE = fE;
		ZN = zN;
		MN = mN;
		CU = cU;
		B = b;
	}



	public Result(String area, String n, String p, String k, String cA,
			String mG, String s, String fE, String zN, String mN, String cU,
			String b) {
		super();
		this.area = area;
		N = n;
		P = p;
		K = k;
		CA = cA;
		MG = mG;
		S = s;
		FE = fE;
		ZN = zN;
		MN = mN;
		CU = cU;
		B = b;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getN() {
		return N;
	}
	public void setN(String n) {
		N = n;
	}
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
	public String getK() {
		return K;
	}
	public void setK(String k) {
		K = k;
	}
	public String getCA() {
		return CA;
	}
	public void setCA(String cA) {
		CA = cA;
	}
	public String getMG() {
		return MG;
	}
	public void setMG(String mG) {
		MG = mG;
	}
	public String getS() {
		return S;
	}
	public void setS(String s) {
		S = s;
	}
	public String getFE() {
		return FE;
	}
	public void setFE(String fE) {
		FE = fE;
	}
	public String getZN() {
		return ZN;
	}
	public void setZN(String zN) {
		ZN = zN;
	}
	public String getMN() {
		return MN;
	}
	public void setMN(String mN) {
		MN = mN;
	}
	public String getCU() {
		return CU;
	}
	public void setCU(String cU) {
		CU = cU;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}



	@Override
	public String toString() {
		return "Result [id=" + id + ", area=" + area + ", N=" + N + ", P=" + P
				+ ", K=" + K + ", CA=" + CA + ", MG=" + MG + ", S=" + S
				+ ", FE=" + FE + ", ZN=" + ZN + ", MN=" + MN + ", CU=" + CU
				+ ", B=" + B + ", created=" + created + "]";
	}



	

	
//	CREATE TABLE IF NOT EXISTS SAVED_RESULTS(AREA VARCHAR, N VARCHAR, P VARCHAR, K VARCHAR, CA VARCHAR, MG VARCHAR, S VARCHAR, FE VARCHAR, ZN VARCHAR, MN VARCHAR, CU VARCHAR, B VARCHAR, CREATED DATETIME);";
}
