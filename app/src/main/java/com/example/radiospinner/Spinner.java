package com.example.radiospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class Spinner extends Activity implements OnItemSelectedListener {

	android.widget.Spinner spinmain,spinsub;
	
	ArrayAdapter<CharSequence> adapterSp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		spinmain = (android.widget.Spinner) findViewById(R.id.spinmain);
		spinsub = (android.widget.Spinner) findViewById(R.id.spinsub);
		
		adapterSp = ArrayAdapter.createFromResource(this,
		        R.array.hello, android.R.layout.simple_spinner_item);
		adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinmain.setAdapter(adapterSp);
		
		spinmain.setOnItemSelectedListener(this);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		String selecteditem=spinmain.getSelectedItem().toString();
		//Toast.makeText(getApplicationContext(), selecteditem, Toast.LENGTH_SHORT).show();
		if(selecteditem.equals("India")){
			adapterSp = ArrayAdapter.createFromResource(this,
			        R.array.states_i, android.R.layout.simple_spinner_item);
			adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinsub.setAdapter(adapterSp);
		}
		else if(selecteditem.equals("Canada")){
			adapterSp = ArrayAdapter.createFromResource(this,
			        R.array.states_c, android.R.layout.simple_spinner_item);
			adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinsub.setAdapter(adapterSp);
		
		}
		else if(selecteditem.equals("USA")){
			adapterSp = ArrayAdapter.createFromResource(this,
			        R.array.states_u, android.R.layout.simple_spinner_item);
			adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinsub.setAdapter(adapterSp);
		
		}
		else if(selecteditem.equals("Pakistan")){
			adapterSp = ArrayAdapter.createFromResource(this,
			        R.array.states_p, android.R.layout.simple_spinner_item);
			adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinsub.setAdapter(adapterSp);
		
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
