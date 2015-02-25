package com.example.radiospinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewDemoActivity extends Activity{

	ListView list;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		List<String> my_list=new ArrayList<String>();
		my_list.add("a");
		my_list.add("b");
		my_list.add("c");
		my_list.add("d");
		
		list=(ListView) findViewById(R.id.listview);
		adapter=new ArrayAdapter<String>(list.getContext(), android.R.layout.simple_list_item_1, my_list);
		list.setAdapter(adapter);
	}
	
}
