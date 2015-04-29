package com.onine.testswipeapp.setting;
//************************************************************************//
//                                                                        //
// Name        =  UserSettingTestInstructionDetailActivity                                                  //
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.setting.testinstruction.utility.ParseTestInstructionJson;
import com.onine.testswipeapp.setting.testinstruction.utility.TestInstructionsVO;

public class UserSettingTestInstructionDetailActivity extends Activity {

	int statusClass=2;
	
	Map<String, TestInstructionsVO> testInstructionMap=new HashMap<String, TestInstructionsVO>();
	
private String readTestInstructionJSON(String FILENAME) {
        
        String ret = "";
         
        try {
            InputStream inputStream = openFileInput(FILENAME);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                 
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                 
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
 
        return ret;
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_setting_test_instruction_detail);
		
		Intent intent = getIntent();
		String itemClicked = intent.getExtras().getString("item");
		
		
		String json=readTestInstructionJSON("testInstructions.json");
        if(json.equalsIgnoreCase("")){
        	new HttpAsyncTask().execute("http://104.130.240.26:8080/bhn/service/testinstr/");
        
        	do{
        		try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}while(statusClass==2);
        
        }else{
        	ParseTestInstructionJson parseJson=new ParseTestInstructionJson();
        	List<TestInstructionsVO> testInstructionsList = parseJson.parseTestInstructionJsonString(readTestInstructionJSON("testInstructions.json"));
   	     	testInstructionMap = parseJson.getTestInstructionMap(testInstructionsList);
//   	    	 arrChildelements=parseJson.get2dArray(hashmap);
   	     /*	values=new String[testInstructionMap.keySet().size()];
   	     	Object arr[]=testInstructionMap.keySet().toArray();
   	     	for (int i = 0; i < arr.length; i++) {
				values[i]=(String)arr[i];
			}*/
        	
        }
        TestInstructionsVO testInstructionVo=testInstructionMap.get(itemClicked);
        
        TextView whenToTakeSample=(TextView)findViewById(R.id.whenToTakeSample);
        TextView plantAppearance=(TextView)findViewById(R.id.plantAppearance);
        TextView partToSample=(TextView)findViewById(R.id.partToSample);
        TextView dataSentToLab=(TextView)findViewById(R.id.dataSentToLab);
        TextView specialInstructions=(TextView)findViewById(R.id.specialInstructions);
        TextView plantHeading=(TextView)findViewById(R.id.plantHeading);
        
        
        if(testInstructionVo !=null){
            whenToTakeSample.setText(testInstructionVo.getWhenToTakeSample().replaceAll("-->", "\n"));
            plantAppearance.setText(testInstructionVo.getPlantAppearance().replaceAll("-->", "\n"));
            partToSample.setText(testInstructionVo.getPartToSample().replaceAll("-->", "\n"));
            dataSentToLab.setText(testInstructionVo.getDataSentToLab().replaceAll("-->", "\n"));
            specialInstructions.setText(testInstructionVo.getSpecialInstructions().replaceAll("-->", "\n"));
            plantHeading.setText(itemClicked);
        }else{
        	System.out.println("Error: Map is empty..!!");
        }
        
        
		
		
	}
	
	
	
	
	
	
	
	
	
	
	//////////////From BHushan ----------------------
	
	public static String convertStreamToString(InputStream inputStream) throws IOException {
		if (inputStream != null) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		while ((line = reader.readLine()) != null) {
		sb.append(line).append("\n");
		}
		
		} finally {
		inputStream.close();
		}
		return sb.toString();
		} else {
		return "";
		}

 }
private class HttpAsyncTask extends AsyncTask<String, Void, String> {
	
	AlertDialog.Builder  builder;
    protected void onPreExecute() {
   super.onPreExecute();
         builder = new AlertDialog.Builder(UserSettingTestInstructionDetailActivity.this);  
    }
    @Override
    protected String doInBackground(String... urls) {
       
       // ImageUpload();//uploading images to server
        return POST(urls[0]);
    	
    }
   
    @Override
    protected void onPostExecute(String result) {}

 }

public String POST(String url){
	System.out.println("I am in post data./..............................");
    
	// Create a new HttpClient and Post Header
    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httppost = new HttpGet(url);
    String result=null;

    try {
        // Add your data
      //  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
       // nameValuePairs.add(new BasicNameValuePair("deviceID", beaconeId.toString().trim()));
       // httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);
     
        	int status = response.getStatusLine().getStatusCode();
        	
        	System.out.println("Status is : "+status);
        	ParseTestInstructionJson parseJson=new ParseTestInstructionJson();
        	if (status == 200) {
        	     result = EntityUtils.toString(response.getEntity());   
        	     System.out.println("################result1###############################"+result);
//        	     jsonStirng=result;
        	     
        	     
        	     FileOutputStream fos = openFileOutput("testInstructions.json", Context.MODE_PRIVATE);
        	     fos.write(result.getBytes());
        	     fos.close();
      
        	     System.out.println("Done");
        	     
        	     List<TestInstructionsVO> testInstructionsList = parseJson.parseTestInstructionJsonString(readTestInstructionJSON("testInstructions.json"));
        	     testInstructionMap = parseJson.getTestInstructionMap(testInstructionsList);
//        	     arrChildelements=parseJson.get2dArray(hashmap);
        	     /*values=new String[testInstructionMap.keySet().size()];
        	     Object arr[]=testInstructionMap.keySet().toArray();
        	     for (int i = 0; i < arr.length; i++) {
					values[i]=(String)arr[i];
				}*/
        	     
        	     statusClass=status;
        	     
        	     
        	     
        	//}
             }
        else{
        	statusClass=400;
        	result = "Did not work!";
            }

    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
    	e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
    	e.printStackTrace();
    }

   return result;
 }



//Bhushan Code Ends
	

}
