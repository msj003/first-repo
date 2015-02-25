package com.example.radiospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuDemo extends Activity {

	Boolean optKey; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_demo);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		//return super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu_demo, menu);
		return true;
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	//	return super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
			case R.id.action_settingsitem:
				Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
				return true;
			 
			case R.id.cancelitem:
				Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG).show();
				return true;
			 
			case R.id.subitem1:
				Toast.makeText(getApplicationContext(), "SubmenuItem1", Toast.LENGTH_LONG).show();
				return true;
			case R.id.subitem2:
				Toast.makeText(getApplicationContext(), "SubmenuItem2", Toast.LENGTH_LONG).show();
				return true;
			
			default:
				return super.onOptionsItemSelected(item);
		}
	
	}
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		if(keyCode == KeyEvent.KEYCODE_MENU){
//			showMenu(menu)
//			
//		}
//		return optKey;
//			
//	}
//	public void showMenu(Menu menu){
//		getMenuInflater().inflate(R.menu.menu_demo, menu);
//	}
}
