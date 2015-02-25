package com.example.radiospinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewActivity extends Activity{
	GridAdapter myAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view_main);
		GridView grid=(GridView) findViewById(R.id.grid);
		myAdapter= new GridAdapter(GridViewActivity.this);
		grid.setAdapter(myAdapter);
	}
}
