package com.onine.testswipeapp.tabs.calculator.utility;
//************************************************************************//
//                                                                        //
// Name        =  DatabaseHandlerBhn                                                  //
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
 
import java.util.ArrayList;
import java.util.List;



 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandlerBhn extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    int count=1;
    // Database Name
    private static final String DATABASE_NAME = "bhn";
 
    private static final String TABLE_REGISTER = "CropDetails";   
    
	private String	id ="ID";	
	private String	croptype ="CROPTYPE";	
	private String	growthstage="GROWTHSTAGE";	
	private String	n ="N";	
	private String	p ="P";	
	private String	k="K";	
	private String	ca="CA";	
	private String	mg="MG";	
	private String	s ="S";
	private String	na="NA";
	private String	fe ="FE";
	private String	zn ="ZN";
	private String	mn ="MN";
	private String	cu ="CU";
	private String	b ="B";
	//private String	extra ="extra";
    
    
    
 
    public DatabaseHandlerBhn(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("+id+" TEXT PRIMARY KEY,"+
    			croptype+" TEXT,"+ growthstage +" TEXT,"+n+" TEXT," +p +" TEXT,"+k+" TEXT,"+
    			ca+" TEXT,"+mg+" TEXT,"+
                s+" TEXT,"+na+" TEXT,"+fe+" TEXT,"+zn+" TEXT,"+ mn+" TEXT,"+ 
    			cu+" TEXT,"+b+" TEXT)";
    	System.out.println("Final Table Creation Query ::::::::::::::::::::::"+CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    
    public long add(Cropdetails register) {
    	long l= 0;
    	if(count<96){
    	SQLiteDatabase db = this.getWritableDatabase();
        System.out.println("I am inside insertion of data"+count);
        ContentValues values = new ContentValues();
        values.put(id ,register.getId());
        values.put(croptype  ,register.getCroptype());
        values.put(growthstage ,register.getGrowthstage());
        values.put(n ,register.getN());
        values.put(p ,register.getP());
        values.put(k ,register.getK());
        values.put(ca ,register.getCa());
        values.put(mg ,register.getMg());
        values.put(s ,register.getS());
        values.put(na,register.getNa());
        values.put(fe,register.getFe());
        values.put(zn ,register.getZn());
        values.put(mn ,register.getMn());
        
        values.put(cu ,register.getCu());
        values.put(b ,register.getB());
       
        // Inserting Row
        l= db.insert(TABLE_REGISTER, null, values);
        db.close();
        count++;
    	}
        
        return l;// Closing database connection
    }

   public Cropdetails get(String id,String id1 ) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_REGISTER, new String[] {id,croptype,growthstage,n,p,k,ca,mg,s,na,fe,zn,mn,cu,b}, croptype + "=?"+" and "+ growthstage + "=?" ,
                new String[] { "'"+id.toString()+"'","'"+id1.toString()+"'" }, null, null, null, null);
        
        if (cursor != null)
            cursor.moveToFirst();
 
        /*
          mDb.query(true, SQLITE_TABLE, new String[] {
                    KEY_ROWID,
                    KEY_COMPANY,
                    KEY_ORDER,
                    KEY_SEQ,
                    KEY_ITEM,
                    KEY_DESCRIPTION,
                    KEY_QUANTITY,
                    KEY_PRICE,}, 
                    KEY_COMPANY + "=?" + " and "  +
                    KEY_ORDER + "=?", 
                    new String[] {company,orderNumber},
                    null, null, KEY_ITEM , null);
  
         
         */
        Cropdetails register = new Cropdetails(cursor.getString(0),
                cursor.getString(1), cursor.getString(2)
                , cursor.getString(3), cursor.getString(4)
                , cursor.getString(5), cursor.getString(6)
                , cursor.getString(7), cursor.getString(8)
                , cursor.getString(9), cursor.getString(10)
                , cursor.getString(11), cursor.getString(12)
                , cursor.getString(13), cursor.getString(14));
        // return contact
        return register;
    }
   
 
    // Getting All Contacts
    public List<Cropdetails> getAll(String a,String b) {
        List<Cropdetails> registerList = new ArrayList<Cropdetails>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_REGISTER + " where croptype =  '"+a+"' and growthstage ='"+b+"'" ;
        System.out.println("Query :::"+selectQuery);
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        System.out.println("Query Excuted");
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	System.out.println("I am in first Record");
            	//id,croptype,growthstage,n,p,k,ca,mg,s,na,fe,zn,mn,cu,b
            	Cropdetails register = new Cropdetails();
             //   register.setId(cursor.getString(0));
               /* register.setCroptype(cursor.getString(1));
                register.setGrowthstage(cursor.getString(2));
                register.setN(cursor.getString(3));
                register.setP(cursor.getString(4));
                register.setK(cursor.getString(5));
                register.setCa(cursor.getString(6));
                register.setMg(cursor.getString(7));
                register.setS(cursor.getString(8));
                register.setNa(cursor.getString(9));
                register.setFe(cursor.getString(10));
                register.setZn(cursor.getString(11));
                register.setMn(cursor.getString(12));
                register.setCu(cursor.getString(13));
                register.setB(cursor.getString(14));*/
                
                // Adding contact to list
                registerList.add(register);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return registerList;
    }
 
    
    // Getting All Contacts
    public  List<Cropdetails>  getAll(String IdValue) {
    	 List<Cropdetails> registerList = new ArrayList<Cropdetails>();// Select All Query
    	 System.out.println("data almond::::::::::::::"+IdValue);
    	 
    	 int cou = 1;
        String selectQuery = "SELECT  * FROM " + TABLE_REGISTER +" where ID='"+IdValue+"'" ;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	if(cou<96){
            	System.out.println("I am in first Record"+cou+"::"+cursor.getString(0));
            	Cropdetails register = new Cropdetails();
                register.setId(cursor.getString(0));
                register.setCroptype(cursor.getString(1));
                register.setGrowthstage(cursor.getString(2));
                register.setN(cursor.getString(3));
                register.setP(cursor.getString(4));
                register.setK(cursor.getString(5));
                register.setCa(cursor.getString(6));
                register.setMg(cursor.getString(7));
                register.setS(cursor.getString(8));
                register.setNa(cursor.getString(9));
                register.setFe(cursor.getString(10));
                register.setZn(cursor.getString(11));
                register.setMn(cursor.getString(12));
                register.setCu(cursor.getString(13));
                register.setB(cursor.getString(14));
                registerList.add(register);
                cou++;
            	}
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return registerList;
    }
 
    // Getting All Contacts
    public  void  truncAll() {
    	
       
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_REGISTER);
 
      
    }
 
   
 
    public void delete(Cropdetails contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REGISTER, id + " = ?",
                new String[] { contact.getId() });
        db.close();
    }
 
    
    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_REGISTER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
     // return count
        int p= cursor.getCount();
        cursor.close();
        return p;
        
    }
}