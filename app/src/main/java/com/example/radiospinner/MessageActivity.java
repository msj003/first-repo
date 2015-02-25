package com.example.radiospinner;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MessageActivity extends Activity {
	
	ListView list;
	ArrayList<MessageItem> mylist;
	MessaggeAdapter myAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_main);
		list=(ListView) findViewById(R.id.messageList);
		mylist=new ArrayList<MessageItem>();
		mylist.add(new MessageItem("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", true));
		mylist.add(new MessageItem("Hi", true));
		mylist.add(new MessageItem("Hi", true));
		mylist.add(new MessageItem("Hi", true));
		mylist.add(new MessageItem("HHHH", false));
		mylist.add(new MessageItem("HH" +"\ndsffv\nffgdgggggtdgv\ndHH", false));
		mylist.add(new MessageItem("HHHH", false));
		mylist.add(new MessageItem("HHHH", false));
		mylist.add(new MessageItem("Hi", true));
		mylist.add(new MessageItem("HHHH", false));
		
		myAdapter=new MessaggeAdapter(MessageActivity.this, mylist);
		list.setDivider(null);
		list.setDividerHeight(0);
		list.setAdapter(myAdapter);
	}

}
