package com.example.radiospinner;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListAdapter extends BaseAdapter {

	ImageView image;
	TextView text;
	CheckBox check;
	ArrayList<CustomListItem> myArrayList;
	Context context;
	Boolean[] checked;
	ViewHolder holder;
    private int lastPosition = -1;
	class ViewHolder {

		TextView text;
		CheckBox check;
		ImageView image;
	}

	public CustomListAdapter(ArrayList<CustomListItem> myArrayList,
			Context context) {
		super();
		this.myArrayList = myArrayList;
		this.context = context;
		// checked= new Boolean[myArrayList.size()];
		// Arrays.fill(checked, Boolean.FALSE);
	}

//	@Override
//	public int getItemViewType(int position) {
//	// TODO Auto-generated method stub
//	return position;
//	}
//
//	@Override
//	public int getViewTypeCount() {
//	// TODO Auto-generated method stub
//	return getCount();
//	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myArrayList.size();
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
		// return null;
		
		if (convertView == null) {
			holder = new ViewHolder();	
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_list_object, parent,
					false);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			holder.check = (CheckBox) convertView.findViewById(R.id.checkList);
			convertView.setTag(holder);
			

		} else {

			holder = (ViewHolder) convertView.getTag();

		}

		
		holder.image.setImageResource(myArrayList.get(position).getImage());
		holder.text.setText(myArrayList.get(position).getCompanyName());
		holder.check.setTag(position);
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.zoom_in_list : R.anim.zoom_in_list);
        convertView.startAnimation(animation);
        lastPosition = position;
		if (myArrayList.get(position).isSelected())
			holder.check.setChecked(true);
		else
			holder.check.setChecked(false);
		
		holder.check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int pos = (Integer) v.getTag();
				Toast.makeText(context, "" + pos, Toast.LENGTH_LONG).show();
				if (myArrayList.get(pos).isSelected())
					myArrayList.get(pos).setSelected(false);
				else
					myArrayList.get(pos).setSelected(true);
			}
			
		});
		//
		// holder.check.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// int pos = (Integer) v.getTag();
		// //holder.check.setSelected(checked[pos]);
		// if(!checked[pos]){
		// checked[pos]=true;
		// Toast.makeText(context, "" + pos, Toast.LENGTH_LONG).show();
		//
		// }
		// }
		// });

		

//		if (myArrayList.get(position).isSelected())
//			holder.check.setSelected(true);
//		else
//			holder.check.setSelected(false);
		return convertView;

	}

}
