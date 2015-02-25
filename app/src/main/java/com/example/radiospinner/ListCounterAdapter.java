package com.example.radiospinner;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListCounterAdapter extends BaseAdapter{


	Button plusButton;
	Button minusButton;
	TextView countText;
	String v;
	int a;
	
	
	Context context;
	ArrayList<ListCounterItem> countList;
	
	
	public ListCounterAdapter(Context context,ArrayList<ListCounterItem> countList) {
		super();
		this.context = context;
		this.countList = countList;
	}


	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		//return position % 2;
		//return (position == this.getCount() - 1) ? 1 : 0;
		if(position % 2==0)
			return 1;
		else
			return 0;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getCount() {
		// TODO -Auto-generated method stub
		return countList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		//return null;
		
		
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		if(getItemViewType(arg0)==0){
		arg1=inflater.inflate(R.layout.list_counter_item, arg2, false);
		plusButton=(Button) arg1.findViewById(R.id.plusButton);
		minusButton=(Button) arg1.findViewById(R.id.minusButton);
		countText=(TextView) arg1.findViewById(R.id.textCounter);
		
		
		}
		else if(getItemViewType(arg0)==1){
		arg1=inflater.inflate(R.layout.lis_counter_item_rev, arg2, false);	
		plusButton=(Button) arg1.findViewById(R.id.plusButtonR);
		minusButton=(Button) arg1.findViewById(R.id.minusButtonR);
		countText=(TextView) arg1.findViewById(R.id.textCounter);
		}
		plusButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View parent = (View) v.getParent();
				
				TextView count = (TextView) parent.findViewById(R.id.textCounter);
				
				int a=Integer.parseInt(count.getText().toString());
				Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
				a++;
				count.setText(""+a);
				
			}
		});
		minusButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View parent = (View) v.getParent();
				
				TextView count = (TextView) parent.findViewById(R.id.textCounter);
				
				int a=Integer.parseInt(count.getText().toString());
				Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
				a--;
				count.setText(""+a);
			
			}
		});
		return arg1;
	}

}
