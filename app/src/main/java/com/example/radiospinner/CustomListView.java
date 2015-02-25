package com.example.radiospinner;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomListView extends Activity{
	  ListView list;
	  ArrayList<CustomListItem> mylist;
	      CustomListAdapter myadapter;
	     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_list_view);
		list=(ListView) findViewById(R.id.listview2);
		mylist=new ArrayList<CustomListItem>();
		
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		mylist.add(new CustomListItem("my company", R.drawable.ic_launcher, "my url",false));
		myadapter=new CustomListAdapter(mylist,CustomListView.this);
		list.setAdapter(myadapter);
	}
	
}
