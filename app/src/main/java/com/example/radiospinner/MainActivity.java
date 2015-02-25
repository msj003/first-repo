package com.example.radiospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
	Animation animFadeIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		setListeners();
	}

	public void initViews(){
		btn1= (Button) findViewById(R.id.button1);
		btn2= (Button) findViewById(R.id.button2);
		btn3= (Button) findViewById(R.id.button3);
		btn4= (Button) findViewById(R.id.button4);		
		btn5= (Button) findViewById(R.id.button5);
		btn6= (Button) findViewById(R.id.button6);		
		btn7= (Button) findViewById(R.id.button7);		
		btn8= (Button) findViewById(R.id.button8);		
		btn9=(Button) findViewById(R.id.button9);
		btn10=(Button) findViewById(R.id.button10);
		btn11=(Button) findViewById(R.id.button11);
        btn12=(Button) findViewById(R.id.button12);
        btn13=(Button) findViewById(R.id.button13);
        btn14=(Button) findViewById(R.id.button14);
        btn15=(Button) findViewById(R.id.button15);
        btn16=(Button) findViewById(R.id.button16);
		animFadeIn=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
	
	}
	
	public void setListeners(){
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ir=new Intent(MainActivity.this,Radio.class);
				startActivity(ir);
			//	btn2.startAnimation(animFadeIn);
				overridePendingTransition(R.anim.fade_in,R.anim.fade_out );
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent is=new Intent(MainActivity.this,Spinner.class);
				startActivity(is);
				overridePendingTransition(R.anim.zoom_in,R.anim.zoom_in_in );
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				startActivity(new Intent(MainActivity.this,IntentDemo.class));
			}
		});
		
		btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,DialogDemo.class));
			}
		});
		
		btn5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,ProgressDemo.class));
			}
		});
		btn6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,MenuDemo.class));
			}
		});
		btn7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,ListViewDemoActivity.class));	
			}
		});
		btn8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,CustomListView.class));	
			}
		});
		btn9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,ListCounterActivity.class));	
					
			}
		});
		btn10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,MessageActivity.class));	
					
			}
		});
		btn11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,GridViewActivity.class));
			}
		});
        btn12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,VideoViewActivity.class));
            }
        });
        btn13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WebViewActivity.class));
            }
        });
        btn14.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HttpDemoActivity.class));
            }
        });
        btn15.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MapDemoActivity.class));
            }
        });
        btn16.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CameraPicture.class));
            }
        });
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
