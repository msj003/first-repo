package com.example.radiospinner;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Manjinder singh on 04-03-2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //return null;
        switch (position){
            case 0:
                return  new FirstFragment();
            case 1:
                return new SecondFragment();
        }
        return null;
    }

    @Override
    public int getCount() {

        return 2;
    }
}
