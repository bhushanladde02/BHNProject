package com.onine.testswipeapp.tabs;
//************************************************************************//
//                                                                        //
// Name        =  CalculatorScreen5Activity                                                  //
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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.onine.testswipeapp.R;
import com.onine.testswipeapp.db.sqllite.helper.DatabaseHelper;
import com.onine.testswipeapp.db.sqllite.model.Result;


public class CalculatorScreen5Activity extends Activity {

	public static String N;
	public static String P;
	public static String K;
	public static String CA;
	public static String MG;
	public static String S;
	public static String FE;
	public static String ZN;
	public static String MN;
	public static String CU;
	public static String B;
	public static String location="";
	public static String cropName="";
	public static String growthStage="";
	public static String acrs="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nsc_new);
		
		Intent intent=getIntent();
		N=intent.getStringExtra("N");
		P=intent.getStringExtra("P");
		K=intent.getStringExtra("K");
		CA=intent.getStringExtra("CA");
		MG=intent.getStringExtra("MG");
		S=intent.getStringExtra("S");
		FE=intent.getStringExtra("FE");
		ZN=intent.getStringExtra("ZN");
		MN=intent.getStringExtra("MN");
		CU=intent.getStringExtra("CU");
		B=intent.getStringExtra("B");
		
		location=intent.getStringExtra("location");
		cropName=intent.getStringExtra("cropName");
		growthStage=intent.getStringExtra("growthStage");
		acrs=intent.getStringExtra("acrs");
		
		System.out.println("In CalculatorScreen5Activity : : : : :"+N);
		
		
		TextView textN=(TextView)findViewById(R.id.NRes);
		textN.setText(N);
		TextView textP=(TextView)findViewById(R.id.PRes);
		textP.setText(P);
		TextView textK=(TextView)findViewById(R.id.KRes);
		textK.setText(K);
		TextView textCA=(TextView)findViewById(R.id.CARes);
		textCA.setText(CA);
		TextView textMG=(TextView)findViewById(R.id.MGRes);
		textMG.setText(MG);
		TextView textS=(TextView)findViewById(R.id.SRes);
		textS.setText(S);
		TextView textFE=(TextView)findViewById(R.id.FERes);
		textFE.setText(FE);
		TextView textZN=(TextView)findViewById(R.id.ZNRes);
		textZN.setText(ZN);
		TextView textMN=(TextView)findViewById(R.id.MNRes);
		textMN.setText(MN);
		TextView textCU=(TextView)findViewById(R.id.CURes);
		textCU.setText(CU);
		TextView textB=(TextView)findViewById(R.id.BRes);
		textB.setText(B);
		
		
		/*		Button calcuScr4 = (Button) findViewById(R.id.btn_calc_screen4);

		OnTouchListener calcuScr1Listener = new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent calcScr5Act = new Intent(getParent(),
							CalculatorScreen5Activity.class);
					TabGroupActivity parentActivity = (TabGroupActivity) getParent();
					parentActivity.startChildActivity(
							"CalculatorScreen5Activity", calcScr5Act);
					return true;
				}
				return false;
			}
		};

		calcuScr4.setOnTouchListener(calcuScr1Listener);*/
	}
	
	
	public void saveResults(View view){

		System.out.println("in the saveResults method.");
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());

		System.out.println("creating table");
		db.createTableResult();
		System.out.println("table created");
		Result result=new Result(location, N, P, K, CA, MG, S, FE, ZN, MN, CU, B);
//		Result result1=new Result("Field 16", "12", "2", "16", "12", "12", "11", "14", "17", "19", "11", "10");
//		Result result2=new Result("Field 16", "0.123", "0.22", "0.12", "1", "0", "0.3321", "0.12", "0.23", "29", "18", "10");
		
//		long res1_id = db.createResult(result1);
//		long res2_id = db.createResult(result2);
		long res3_id = db.createResult(result);
		System.out.println("Results got saved");
//		long res2_id = db.createResult(result2);
		System.out.println("Saved Results count: : "+db.getAllRedults().size());
		// Don't forget to close database connection
		db.closeDB();
		
		
	}
	
	public void shareResults(View view){
		
		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
	    db.deleteResult("Field 16");
	    db.deleteResult("Field 15");
	    
	 // Don't forget to close database connection
	 	db.closeDB();
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	try {
			
	 		StringBuilder body=getHtmlContent("12", "0.2345", "0.987", "0.111", "21", "12", "32", "19", "31", "14", "22");
			String resarr[]={"12", "0.2345", "0.987", "0.111", "21", "12", "32", "19", "31", "14", "22"};
			System.out.println("Body is: "+body);
            /*email = editTextEmail.getText().toString();
            subject = editTextSubject.getText().toString();
            message = editTextMessage.getText().toString();*/

            final Intent emailIntent = new Intent(
                          android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/html");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                          new String[] { "" });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                          "Email from Huma Gro - Calculation Results");
            /*if (URI != null) {
                   emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
            }*/
//            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(body));
            
            /*emailIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    Html.fromHtml(new StringBuilder()
                        .append("<p><b>Some Content</b></p>")
                        .append("<a>http://www.google.com</a>")
                        .append("<small><p>More content</p></small>")
                        .toString())
                    );*/
            
            /*String emailstr="<table style='border-collapse:collapse;border-spacing:0'><tr><th style='font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>SUPER NITRO®</th><th style='font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>1</th></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>SUPER PHOS®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>2</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>SUPER K®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>3</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>CALCIUM®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>4</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>44 MAG®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>5</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>SULFUR®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>6</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>IRON®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>7</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>Z-MAX®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>8</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>MANGANESE®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>9</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>COPPER®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>10</td></tr><tr><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>BORON®</td><td style='font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal'>11</td></tr></table>";
            
            emailstr.replace(">1<", resarr[0]);
            emailstr.replace(">2<", resarr[1]);
            emailstr.replace(">3<", resarr[2]);
            emailstr.replace(">4<", resarr[3]);
            emailstr.replace(">5<", resarr[4]);
            emailstr.replace(">6<", resarr[5]);
            emailstr.replace(">7<", resarr[6]);
            emailstr.replace(">8<", resarr[7]);
            emailstr.replace(">9<", resarr[8]);
            emailstr.replace(">10<", resarr[9]);
            emailstr.replace(">11<", resarr[10]);*/
//            emailString.replace(">1<", result[0]);
            

//            StringBuilder strbuilder=new StringBuilder();
            
            emailIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    Html.fromHtml(new StringBuilder()
                    	.append("<p><b>------Saved Calculations------</b></p>")
                    	.append("<p>Super NITRO: "+N+"</p>")
                        .append("----------------------------------")
                        .append("<p>SUPER PHOS: "+P+"</p>")
                        .append("----------------------------------")
                        .append("<p>Super K: "+K+"</p>")
                        .append("----------------------------------")
                        .append("<p>CALCIUM: "+CA+"</p>")
                        .append("----------------------------------")
                        .append("<p>44 MAG: "+MG+"</p>")
                        .append("----------------------------------")
                        .append("<p>Supfer: "+S+"</p>")
                        .append("----------------------------------")
                        .append("<p>IRON: "+FE+"</p>")
                        .append("----------------------------------")
                        .append("<p>Z-MAX: "+ZN+"</p>")
                        .append("----------------------------------")
                        .append("<p>MANGANESE: "+MN+"</p>")
                        .append("----------------------------------")
                        .append("<p>COPPER: "+CU+"</p>")
                        .append("----------------------------------")
                        .append("<p>BORON: "+B+"</p>")
                        .append("----------------------------------")
                        .toString())
                    );
            
            /*emailIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    Html.fromHtml(strbuilder.append(emailstr)
                        .toString())
                    );*/
            
            startActivity(Intent.createChooser(emailIntent,"Sending email..."));

      } catch (Exception e) {
            e.printStackTrace();
      }
		
		
	}
	
	
	
public StringBuilder getHtmlContent(String N,String P,String K,String CA, String MG, String S, String FE, String ZN, String MN, String CU, String B){
		StringBuilder sbuilder=new StringBuilder();
		sbuilder.append("");
		
		String content="<body>"+
				"		<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 500px;\">"+
				"			<thead>"+
				"				<tr>"+
				"					<th scope=\"col\">"+
				"						Product</th>"+
				"					<th scope=\"col\">"+
				"						Recomended level</th>"+
				"				</tr>"+
				"			</thead>"+
				"			<tbody>"+
				"				<tr>"+
				"					<td>"+
				"						Super NITRO</td>"+
				"					<td>"+
				"						"+N+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						SUPER PHOS</td>"+
				"					<td>"+
				"						"+P+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						Super K</td>"+
				"					<td>"+
				"						"+K+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						CALCIUM</td>"+
				"					<td>"+
				"						"+CA+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						44 MAG</td>"+
				"					<td>"+
				"						"+MG+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						Supfer</td>"+
				"					<td>"+
				"						"+S+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						IRON</td>"+
				"					<td>"+
				"						"+FE+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						Z-MAX</td>"+
				"					<td>"+
				"						"+ZN+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						MANGANESE</td>"+
				"					<td>"+
				"						"+MN+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						COPPER</td>"+
				"					<td>"+
				"						"+CU+"</td>"+
				"				</tr>"+
				"				<tr>"+
				"					<td>"+
				"						BORON</td>"+
				"					<td>"+
				"						"+B+"</td>"+
				"				</tr>"+
				"			</tbody>"+
				"		</table>"+
				"		<p>"+
				"			&nbsp;</p>"+
				"		<div>"+
				"			&nbsp;</div>"+
				"	</body>";
		
		
		
		return sbuilder;
	}


	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deficiencies, menu);
		return true;
	}
*/
}
