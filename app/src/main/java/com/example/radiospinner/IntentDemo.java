package com.example.radiospinner;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentDemo extends Activity {
	
	List<String> data = new ArrayList<String>();

	Button btnIntent;
	EditText edit1,edit2,edit3,edit4,edit5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_demo_main);
		initViews();
		
		btnIntent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(edit1.getText().toString().trim().equalsIgnoreCase("") || edit2.getText().toString().trim().equalsIgnoreCase("") || edit3.getText().toString().trim().equalsIgnoreCase("") || edit4.getText().toString().trim().equalsIgnoreCase("") || edit5.getText().toString().trim().equalsIgnoreCase(""))
					Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
				else{
//					data.add(edit1.getText().toString());
//					data.add(edit2.getText().toString());
//					data.add(edit3.getText().toString());
//					data.add(edit4.getText().toString());
//					data.add(edit5.getText().toString());
					Intent send=new Intent(IntentDemo.this,IntentDemoSecond.class);
					//send.putStringArrayListExtra("data", (ArrayList<String>) data);
					send.putExtra("name", edit1.getText().toString());
					send.putExtra("rollno", edit2.getText().toString());
					send.putExtra("class", edit3.getText().toString());
					send.putExtra("address", edit4.getText().toString());
					send.putExtra("phone", edit5.getText().toString());
					startActivity(send);
				}
				
			}
		});
		
	}
	
	public void initViews(){
		btnIntent = (Button) findViewById(R.id.button_intent_main);
		edit1 = (EditText) findViewById(R.id.edit_text_1);
		edit2 = (EditText) findViewById(R.id.edit_text_2);
		edit3 = (EditText) findViewById(R.id.edit_text_3);
		edit4 = (EditText) findViewById(R.id.edit_text_4);
		edit5 = (EditText) findViewById(R.id.edit_text_5);
		
	}
}
