package com.example.radiospinner;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessaggeAdapter extends BaseAdapter{
	
	Context context;
	ArrayList<MessageItem> myList;
	ViewHolder holder;
	
	class ViewHolder{
		TextView text;
		LinearLayout li;
	}
	
	
	public MessaggeAdapter(Context context, ArrayList<MessageItem> myList) {
		super();
		this.context = context;
		this.myList = myList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return null;
		if(convertView==null){
		holder=new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.message_item, parent,
					false);
	
			holder.text=(TextView) convertView.findViewById(R.id.messageText);
			holder.li=(LinearLayout) convertView.findViewById(R.id.messageLineaerlayout);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.text.setText(myList.get(position).getMessage());
		if(myList.get(position).getPerson()){
			holder.li.setGravity(Gravity.RIGHT);
			
			holder.text.setTextColor(Color.BLACK);
			holder.text.setBackgroundResource(R.drawable.chat_right);
		}
		else{
			
			holder.text.setBackgroundResource(R.drawable.chat_left);
			holder.li.setGravity(Gravity.LEFT);
		}
		return convertView;
	}

}
