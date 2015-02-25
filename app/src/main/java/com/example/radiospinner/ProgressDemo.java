package com.example.radiospinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class ProgressDemo extends Activity{

	ProgressBar progressBar;
	RatingBar ratingBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress);
		initViews();
		setListeners();
	}
	
	public void initViews(){
		progressBar=(ProgressBar) findViewById(R.id.progressBar);
		ratingBar=(RatingBar) findViewById(R.id.ratingBar);
	}
	
	public void setListeners(){
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"Rating Bar : "+ arg1, Toast.LENGTH_LONG).show();
			}
		});
	}
}
