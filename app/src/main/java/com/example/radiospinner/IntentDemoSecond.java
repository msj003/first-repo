package com.example.radiospinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntentDemoSecond extends Activity {
	TextView t1,t2,t3,t4,t5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_demo_second);
//		Intent i= getIntent();
//		List<String> get = new ArrayList<String>();
//		get = i.getStringArrayListExtra("data");
		initViews();
		
	}
	
	public void initViews(){
		t1 = (TextView) findViewById(R.id.text1);
		t2 = (TextView) findViewById(R.id.text2);
		t3 = (TextView) findViewById(R.id.text3);
		t4 = (TextView) findViewById(R.id.text4);
		t5 = (TextView) findViewById(R.id.text5);
		t1.setText(getIntent().getStringExtra("name"));
		t2.setText(getIntent().getStringExtra("rollno"));
		t3.setText(getIntent().getStringExtra("class"));
		t4.setText(getIntent().getStringExtra("address"));
		t5.setText(getIntent().getStringExtra("phone"));
		

	}

}
