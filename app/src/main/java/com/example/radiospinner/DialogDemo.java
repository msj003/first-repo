package com.example.radiospinner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogDemo extends Activity{
	
	Button btn1,btn2,btn3;
	TextView txt1,txt2;
	EditText one,two;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_demo);
		initViews();
		setListeners();
	}
	
	void initViews(){
		btn1=(Button) findViewById(R.id.dbutton1);
		btn2=(Button) findViewById(R.id.dbutton2);
		btn3=(Button) findViewById(R.id.dbutton3);

	}
	
	void setListeners(){
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder fire=new AlertDialog.Builder(DialogDemo.this);
				fire.setTitle("Delete");	
				fire.setMessage("R u sure").setPositiveButton("yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				}).setNegativeButton("no", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				fire.show();
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder list= new AlertDialog.Builder(DialogDemo.this);
				list.setTitle("Pick a color");
				list.setItems(R.array.color, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String[] ch=getResources().getStringArray(R.array.color);
						Toast.makeText(getApplicationContext(),ch[which] , Toast.LENGTH_LONG).show();
					}
				});
				list.show();
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder cust = new AlertDialog.Builder(DialogDemo.this);
				LayoutInflater inflater = (DialogDemo.this).getLayoutInflater();
				View dialogView = (View) inflater.inflate(R.layout.custom_dialog, null); 
				cust.setView(dialogView);
//				cust.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						// TODO Auto-generated method stub
//						
//					}
//				});
//				cust.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						// TODO Auto-generated method stub
//						
//					}
//				});
				Button custbtn1=(Button) dialogView.findViewById(R.id.custbutton1);
				Button custbtn2=(Button) dialogView.findViewById(R.id.custbutton2);
				one  = (EditText) dialogView.findViewById(R.id.custedit1);
				two = (EditText) dialogView.findViewById(R.id.custedit2);
				txt1=(TextView) findViewById(R.id.dialogtext1);
				txt2=(TextView) findViewById(R.id.dialogtext2);
				
				
				custbtn1.setOnClickListener(myListner);
				//custbtn2.setOnClickListener(myListner);
				
				cust.show();
			}
		});
		
	}

	
	OnClickListener myListner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			txt1.setText(one.getText().toString().toLowerCase().trim());
			txt2.setText(two.getText().toString().toLowerCase().trim());
		}
	};
}
