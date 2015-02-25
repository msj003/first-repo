package com.example.radiospinner;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class ListCounterActivity extends Activity{

	ListView list;
	ArrayList<ListCounterItem> myList;
	ListCounterAdapter myAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_counter_main);
		list=(ListView) findViewById(R.id.listviewcounter);
		myList=new ArrayList<ListCounterItem>();
		myList.add(new ListCounterItem("0"));
		myList.add(new ListCounterItem("0"));
		myList.add(new ListCounterItem("0"));
		
		myAdapter=new ListCounterAdapter(ListCounterActivity.this, myList);
		
		list.setAdapter(myAdapter);
	}
}
