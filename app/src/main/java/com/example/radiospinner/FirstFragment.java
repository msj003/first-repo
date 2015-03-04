package com.example.radiospinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Manjinder singh on 03-03-2015.
 */
public class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.first_fragment_layout,container,false);
        TextView t1;
        t1=(TextView) v.findViewById(R.id.firstFragmentTextView);
        t1.setText("1. Hello This is First fragment :)  :)   :)");
        return v;

    }

}
