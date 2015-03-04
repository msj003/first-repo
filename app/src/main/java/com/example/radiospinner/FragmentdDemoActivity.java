package com.example.radiospinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FragmentdDemoActivity extends FragmentActivity {
    Button changeButton;
    boolean a=false;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentd_demo);
        changeButton=(Button) findViewById(R.id.changeFragmentButton);
        FragmentManager fragmentManager= getSupportFragmentManager();


        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a){
                    a=true;
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FirstFragment()).addToBackStack(null).commit();
                }
                else{
                    a=false;
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new SecondFragment()).commit();
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragmentd_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
