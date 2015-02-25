package com.example.radiospinner;


import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{

	public Integer[] thumbId ={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
			R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.chat_left,R.drawable.chat_right};
	Context context;
	ViewHolder holder;
	LinearLayout.LayoutParams layoutParams; 
	
	class ViewHolder{
		ImageView image;
		TextView text;
		
		
	}
	
	
	
	public GridAdapter(Context context) {
		super();
		this.context = context;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = (size.x)/3;
		layoutParams = new LinearLayout.LayoutParams(width,width);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return thumbId.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return thumbId[arg0];
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
		if(arg1==null){
			holder=new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg1 = inflater.inflate(R.layout.gridview_item, arg2,
					false);
	
			holder.text=(TextView) arg1.findViewById(R.id.gridText);
			holder.image=(ImageView) arg1.findViewById(R.id.grid_image);
			arg1.setTag(holder);
			
		}
		else{
			holder=(ViewHolder) arg1.getTag();
		}
		holder.image.setLayoutParams(layoutParams);
		holder.image.setImageResource(thumbId[arg0]);
		holder.text.setText(thumbId[arg0]);
		return arg1;
	}

	
}
