package com.onine.testswipeapp.db.sqllite.helper;
//************************************************************************//
//                                                                        //
// Name        =  DatabaseHelper                                          //
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

import com.onine.testswipeapp.db.sqllite.model.Result;
import com.onine.testswipeapp.db.sqllite.model.UnitMeasurement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String LOG = "DatabaseHelper";

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "contactsManager";

	private static final String TABLE_SAVED_RESULTS = "SAVED_RESULTS";
	private static final String TABLE_UNIT_MEASUREMENT = "UNIT_MEASUREMENT";
	

	// Common column names
//	private static final String KEY_ID = "id";
//	private static final String KEY_CREATED_AT = "created_at";

	// NOTES Table - column nmaes
//	private static final String KEY_TODO = "todo";
//	private static final String KEY_STATUS = "status";

	// TAGS Table - column names
//	private static final String KEY_TAG_NAME = "tag_name";

	// NOTE_TAGS Table - column names
//	private static final String KEY_TODO_ID = "todo_id";
//	private static final String KEY_TAG_ID = "tag_id";

	// Table Create Statements
	// Todo table create statement
	/*private static final String CREATE_TABLE_TODO = "CREATE TABLE "
			+ TABLE_TODO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TODO
			+ " TEXT," + KEY_STATUS + " INTEGER," + KEY_CREATED_AT
			+ " DATETIME" + ")";*/
	
	private static final String CREATE_TABLE_RESULTS = "CREATE TABLE IF NOT EXISTS SAVED_RESULTS(id INTEGER PRIMARY KEY, AREA VARCHAR, N VARCHAR, P VARCHAR, K VARCHAR, CA VARCHAR, MG VARCHAR, S VARCHAR, FE VARCHAR, ZN VARCHAR, MN VARCHAR, CU VARCHAR, B VARCHAR, CREATED DATETIME);";
	private static final String CREATE_TABLE_UNITMEASUREMENT = "CREATE TABLE IF NOT EXISTS UNIT_MEASUREMENT(UNITID VARCHAR, AREAUNIT VARCHAR, PRODUCTUNIT VARCHAR);";

	// Tag table create statement
/*	private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TAG
			+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT,"
			+ KEY_CREATED_AT + " DATETIME" + ")";*/

	// todo_tag table create statement
/*	private static final String CREATE_TABLE_TODO_TAG = "CREATE TABLE "
			+ TABLE_TODO_TAG + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_TODO_ID + " INTEGER," + KEY_TAG_ID + " INTEGER,"
			+ KEY_CREATED_AT + " DATETIME" + ")";*/

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		/*db.execSQL(CREATE_TABLE_TODO);
		db.execSQL(CREATE_TABLE_TAG);
		db.execSQL(CREATE_TABLE_TODO_TAG);*/
		db.execSQL(CREATE_TABLE_RESULTS);
		db.execSQL(CREATE_TABLE_UNITMEASUREMENT);
		System.out.println("Table create Saved Results ::-->");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		/*db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);*/
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_RESULTS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_UNITMEASUREMENT);
		System.out.println("Table create Saved Results ::-->");
		// create new tables
		onCreate(db);
	}
	
	
	// ------------------------ "SAVED_RESULTS" table methods ----------------//

	public void createTableUnitMeasurement(){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL(CREATE_TABLE_UNITMEASUREMENT);
	}
	
	public long createUnitMeasurement(UnitMeasurement unitMeasurement) {
//		long result_id;
		SQLiteDatabase db = this.getWritableDatabase();
		
		System.out.println("Truncating measurement table.");
		db.delete(TABLE_UNIT_MEASUREMENT, "UNITID" + "=" + unitMeasurement.getUnitid(), null);
		System.out.println("Truncated measurement table.");
		
		ContentValues values = new ContentValues();
		values.put("AREAUNIT", unitMeasurement.getAreaUnit());
		values.put("PRODUCTUNIT", unitMeasurement.getProductUnit());
		values.put("UNITID", unitMeasurement.getUnitid());
		long result_id = db.insert(TABLE_UNIT_MEASUREMENT, null, values);
		
		
		return result_id;
	}
	
	public long updateAreaUnit(UnitMeasurement unitMeasurement){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put("AREAUNIT", unitMeasurement.getAreaUnit());
//		args.put("PRODUCTUNIT", unitMeasurement.getProductUnit());
		
		long update_result=db.update(TABLE_UNIT_MEASUREMENT, args, "UNITID" + "=" + 1, null);
		
		return update_result;
	}
	
	public long updateProductUnit(UnitMeasurement unitMeasurement){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues args = new ContentValues();
//		args.put("AREAUNIT", unitMeasurement.getAreaUnit());
		args.put("PRODUCTUNIT", unitMeasurement.getProductUnit());
		
		long update_result=db.update(TABLE_UNIT_MEASUREMENT, args, "UNITID" + "=" + 1, null);
		
		return update_result;
	}
	
	
	
	/**
	 * getting all results
	 * */
	public List<UnitMeasurement> getUnitMeasurement() {
		List<UnitMeasurement> measurement = new ArrayList<UnitMeasurement>();
		String selectQuery = "SELECT  * FROM " + TABLE_UNIT_MEASUREMENT +" where UNITID='1'";

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				UnitMeasurement unitMeasurement=new UnitMeasurement();
				unitMeasurement.setAreaUnit(c.getString(c.getColumnIndex("AREAUNIT")));
				unitMeasurement.setProductUnit(c.getString(c.getColumnIndex("PRODUCTUNIT")));
				// adding to tags list
				measurement.add(unitMeasurement);
			} while (c.moveToNext());
		}
		return measurement;
	}
	
	// ------------------------ "SAVED_RESULTS" table methods ----------------//

	public void createTableResult(){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAVED_RESULTS);
		db.execSQL(CREATE_TABLE_RESULTS);
	}
	
	
	public void deleteResult(String area) {
//		long result_id;
		SQLiteDatabase db = this.getWritableDatabase();
		
		System.out.println("Truncating measurement table.");
		db.delete(TABLE_SAVED_RESULTS, "AREA" + "='" + area+"'", null);
		System.out.println("Truncated measurement table.");
	
	}
	
	public long createResult(Result result) {
//		long result_id;
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("AREA", result.getArea());
		values.put("N", result.getN());
		values.put("P", result.getP());
		values.put("K", result.getK());
		values.put("CA", result.getCA());
		values.put("MG", result.getMG());
		values.put("S", result.getS());
		values.put("FE", result.getFE());
		values.put("ZN", result.getZN());
		values.put("MN", result.getMN());
		values.put("CU", result.getCU());
		values.put("B", result.getB());
		values.put("CREATED", getDateTime());
		long result_id = db.insert(TABLE_SAVED_RESULTS, null, values);
		
		return result_id;
	}
	
	
	/**
	 * getting all results
	 * */
	public List<Result> getAllRedults() {
		List<Result> results = new ArrayList<Result>();
		String selectQuery = "SELECT  * FROM " + TABLE_SAVED_RESULTS;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				Result result=new Result();
				result.setId(c.getInt(c.getColumnIndex("id")));
				result.setArea(c.getString(c.getColumnIndex("AREA")));
				result.setN(c.getString(c.getColumnIndex("N")));
				result.setP(c.getString(c.getColumnIndex("P")));
				result.setK(c.getString(c.getColumnIndex("K")));
				result.setCA(c.getString(c.getColumnIndex("CA")));
				result.setMG(c.getString(c.getColumnIndex("MG")));
				result.setS(c.getString(c.getColumnIndex("S")));
				result.setFE(c.getString(c.getColumnIndex("FE")));
				result.setZN(c.getString(c.getColumnIndex("ZN")));
				result.setMN(c.getString(c.getColumnIndex("MN")));
				result.setCU(c.getString(c.getColumnIndex("CU")));
				result.setB(c.getString(c.getColumnIndex("B")));
				result.setCreated(c.getString(c.getColumnIndex("CREATED")));
				
				// adding to tags list
				results.add(result);
			} while (c.moveToNext());
		}
		return results;
	}
	
	public Result getRedultByArea(int id) {
//		List<Result> results = new ArrayList<Result>();
//		String selectQuery = "SELECT  * FROM " + TABLE_SAVED_RESULTS + " where AREA='"+area+"';";
		String selectQuery = "SELECT  * FROM " + TABLE_SAVED_RESULTS + " where id="+id+";";

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		Result result=new Result();
		if (c.moveToFirst()) {
			do {
				
				result.setArea(c.getString(c.getColumnIndex("AREA")));
				result.setN(c.getString(c.getColumnIndex("N")));
				result.setP(c.getString(c.getColumnIndex("P")));
				result.setK(c.getString(c.getColumnIndex("K")));
				result.setCA(c.getString(c.getColumnIndex("CA")));
				result.setMG(c.getString(c.getColumnIndex("MG")));
				result.setS(c.getString(c.getColumnIndex("S")));
				result.setFE(c.getString(c.getColumnIndex("FE")));
				result.setZN(c.getString(c.getColumnIndex("ZN")));
				result.setMN(c.getString(c.getColumnIndex("MN")));
				result.setCU(c.getString(c.getColumnIndex("CU")));
				result.setB(c.getString(c.getColumnIndex("B")));
				result.setCreated(c.getString(c.getColumnIndex("CREATED")));
				
				// adding to tags list
//				results.add(result);
			} while (c.moveToNext());
		}
		return result;
	}
	

	// closing database
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}

	/**
	 * get datetime
	 * */
	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}
}
