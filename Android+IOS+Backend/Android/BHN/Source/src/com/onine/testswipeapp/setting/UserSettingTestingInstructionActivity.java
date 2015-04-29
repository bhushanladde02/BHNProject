package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  UserSettingTestingInstructionActivity                                                  //
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

import java.io.BufferedReader;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import java.io.InputStream;import java.io.InputStreamReader;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import org.apache.http.HttpResponse;import org.apache.http.client.ClientProtocolException;import org.apache.http.client.HttpClient;import org.apache.http.client.methods.HttpGet;import org.apache.http.impl.client.DefaultHttpClient;import org.apache.http.util.EntityUtils;import android.app.Activity;import android.app.AlertDialog;import android.content.Context;import android.content.Intent;import android.os.AsyncTask;import android.os.Bundle;import android.view.View;import android.widget.AdapterView;import android.widget.ArrayAdapter;import android.widget.ListView;import com.onine.testswipeapp.R;import com.onine.testswipeapp.setting.testinstruction.utility.ParseTestInstructionJson;import com.onine.testswipeapp.setting.testinstruction.utility.TestInstructionsVO;public class UserSettingTestingInstructionActivity extends Activity {	String[] values=new String[]{"Alfalfa", "Almond, Pecan", "Beans (Pinto, Green, Garbanzo, or Chickpea)", "Beets", "Cole Crops (Broccoli, Cauliflower, and Cabbage)", "Carrots", "Celery", "Citrus", "Corn", "Cotton", "HUAP*", "Grapes", "Lettuce", "Melons", "Onions", "Orchard Fruits (Apples, Peaches, Pears)", "Ornamentals (Poinsettia, Roses)", "Peppers (Bell, Chile)", "Pistachio", "Potatoes", "Milo, Sorghum", "Soybeans", "Spinach", "Squash (Kabocha, Summer (Zuchini), Winter)", "Tomatoes", "Turf (Bermuda, Bentgrass, St. Augustine, Rye)", "Small grains (Wheat, Oats, Barley)"};	int statusClass=2;			    private String readTestInstructionJSON(String FILENAME) {                String ret = "";                 try {            InputStream inputStream = openFileInput(FILENAME);                         if ( inputStream != null ) {                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);                String receiveString = "";                StringBuilder stringBuilder = new StringBuilder();                                 while ( (receiveString = bufferedReader.readLine()) != null ) {                    stringBuilder.append(receiveString);                }                                 inputStream.close();                ret = stringBuilder.toString();            }        }catch (FileNotFoundException e) {        } catch (IOException e) {        }         return ret;    }							@Override	protected void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);		setContentView(R.layout.activity_user_setting_testing_instruction);						String json=readTestInstructionJSON("testInstructions.json");        if(json.equalsIgnoreCase("")){        	new HttpAsyncTask().execute("http://104.130.240.26:8080/bhn/service/testinstr/");                	do{        		try {        			Thread.sleep(2000);        		} catch (InterruptedException e) {        			e.printStackTrace();        		}        	}while(statusClass==2);                }else{        	ParseTestInstructionJson parseJson=new ParseTestInstructionJson();        	List<TestInstructionsVO> testInstructionsList = parseJson.parseTestInstructionJsonString(readTestInstructionJSON("testInstructions.json"));   	     	Map<String, TestInstructionsVO> testInstructionMap = parseJson.getTestInstructionMap(testInstructionsList);   	     	values=new String[testInstructionMap.keySet().size()];   	     	Object arr[]=testInstructionMap.keySet().toArray();   	     	for (int i = 0; i < arr.length; i++) {				values[i]=(String)arr[i];			}        	        }								final ListView listview = (ListView) findViewById(R.id.listview);	    	    	    	    final ArrayList<String> list = new ArrayList<String>();	    for (int i = 0; i < values.length; ++i) {	      list.add(values[i]);	    }	    	    	    final StableArrayAdapter adapter = new StableArrayAdapter(this,	            android.R.layout.simple_list_item_1, list);	        listview.setAdapter(adapter);	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {	          @Override	          public void onItemClick(AdapterView<?> parent, final View view,	              int position, long id) {	            final String item = (String) parent.getItemAtPosition(position);	            	            	            Intent testing_instructions = new Intent(UserSettingTestingInstructionActivity.this, UserSettingTestInstructionDetailActivity.class);	            testing_instructions.putExtra("item", item);	            startActivity(testing_instructions);	            	            	            System.out.println("Iten Clicked: "+item);	          }	        });	}							public static String convertStreamToString(InputStream inputStream) throws IOException {		if (inputStream != null) {		StringBuilder sb = new StringBuilder();		String line;		try {		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));		while ((line = reader.readLine()) != null) {		sb.append(line).append("\n");		}				} finally {		inputStream.close();		}		return sb.toString();		} else {		return "";		} }private class HttpAsyncTask extends AsyncTask<String, Void, String> {		AlertDialog.Builder  builder;    protected void onPreExecute() {   super.onPreExecute();         builder = new AlertDialog.Builder(UserSettingTestingInstructionActivity.this);      }    @Override    protected String doInBackground(String... urls) {               return POST(urls[0]);    	    }       @Override    protected void onPostExecute(String result) {} }public String POST(String url){	System.out.println("I am in post data./..............................");        HttpClient httpclient = new DefaultHttpClient();    HttpGet httppost = new HttpGet(url);    String result=null;    try {        HttpResponse response = httpclient.execute(httppost);             	int status = response.getStatusLine().getStatusCode();        	        	System.out.println("Status is : "+status);        	ParseTestInstructionJson parseJson=new ParseTestInstructionJson();        	if (status == 200) {        	     result = EntityUtils.toString(response.getEntity());           	     System.out.println("################result1###############################"+result);        	             	             	     FileOutputStream fos = openFileOutput("testInstructions.json", Context.MODE_PRIVATE);        	     fos.write(result.getBytes());        	     fos.close();              	     System.out.println("Done");        	             	     List<TestInstructionsVO> testInstructionsList = parseJson.parseTestInstructionJsonString(readTestInstructionJSON("testInstructions.json"));        	     Map<String, TestInstructionsVO> testInstructionMap = parseJson.getTestInstructionMap(testInstructionsList);        	     values=new String[testInstructionMap.keySet().size()];        	     Object arr[]=testInstructionMap.keySet().toArray();        	     for (int i = 0; i < arr.length; i++) {					values[i]=(String)arr[i];				}        	             	     statusClass=status;        	             	             	                  }        else{        	statusClass=400;        	result = "Did not work!";            }    } catch (ClientProtocolException e) {    	e.printStackTrace();    } catch (IOException e) {    	e.printStackTrace();    }   return result; }											private class StableArrayAdapter extends ArrayAdapter<String> {	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();	    public StableArrayAdapter(Context context, int textViewResourceId,	        List<String> objects) {	      super(context, textViewResourceId, objects);	      for (int i = 0; i < objects.size(); ++i) {	        mIdMap.put(objects.get(i), i);	      }	    }	    @Override	    public long getItemId(int position) {	      String item = getItem(position);	      return mIdMap.get(item);	    }	    @Override	    public boolean hasStableIds() {	      return true;	    }	  }}