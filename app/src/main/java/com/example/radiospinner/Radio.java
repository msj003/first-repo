package com.example.radiospinner;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Radio extends Activity {

	RadioButton r1, r2, r3, r4;
	RadioGroup r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		r = (RadioGroup) findViewById(R.id.radiogroup);

		
		
//		r.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//
//			@Override
//			public void onCheckedChanged(RadioGroup parent, int id) {
//				// TODO Auto-generated method stub
//				switch (id) {
//				case R.id.rbutton1:
//					r.setBackgroundColor(Color.RED);
//					break;
//				case R.id.rbutton2:
//					r.setBackgroundColor(Color.YELLOW);
//					break;
//				case R.id.rbutton3:
//					r.setBackgroundColor(Color.GREEN);
//					break;
//				case R.id.rbutton4:
//					r.setBackgroundColor(Color.BLUE);
//					break;
//
//				}
//			}
//		});
		// initViews();
		// setListeners();
//	}

	// public void initViews(){
	// r1=(RadioButton) findViewById(R.id.rbutton1);
	// r2=(RadioButton) findViewById(R.id.rbutton2);
	// r3=(RadioButton) findViewById(R.id.rbutton3);
	// r4=(RadioButton) findViewById(R.id.rbutton4);
	//
	// }

//	public void clickKro(View v) {
//		boolean chek = ((RadioButton) v).isChecked();
//
//		switch (v.getId()) {
//		case R.id.rbutton1:
//			if (chek)
//				r.setBackgroundColor(Color.RED);
//			break;
//		case R.id.rbutton2:
//			if (chek)
//				r.setBackgroundColor(Color.YELLOW);
//			break;
//		case R.id.rbutton3:
//			if (chek)
//				r.setBackgroundColor(Color.GREEN);
//			break;
//		case R.id.rbutton4:
//			if (chek)
//				r.setBackgroundColor(Color.BLUE);
//			break;
//
//		}

	//}

	// public void setListeners(){
	// r1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	//
	// @Override
	// public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// r2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	//
	// @Override
	// public void onCheckedChanged(CompoundButton buttonView, boolean
	// isChecked) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// r3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	//
	// @Override
	// public void onCheckedChanged(CompoundButton buttonView, boolean
	// isChecked) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// r4.
	// }

}

//	@Override
//	public void onCheckedChanged(RadioGroup group, int checkedId) {
//		// TODO Auto-generated method stub
//		switch (group.getId()) {
//		case R.id.rbutton1:
//			r.setBackgroundColor(Color.RED);
//			break;
//		case R.id.rbutton2:
//			r.setBackgroundColor(Color.YELLOW);
//			break;
//		case R.id.rbutton3:
//			r.setBackgroundColor(Color.GREEN);
//			break;
//		case R.id.rbutton4:
//			r.setBackgroundColor(Color.BLUE);
//			break;
//
//		}
//
//	}
}