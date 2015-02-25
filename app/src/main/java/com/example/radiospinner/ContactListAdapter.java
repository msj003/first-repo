package com.example.radiospinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manjinder singh on 19-02-2015.
 */
public class ContactListAdapter extends BaseAdapter {
    TextView textView;
    String name;
    Context context;

    ArrayList<Contact> contactList;

    public ContactListAdapter(Context context, ArrayList<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.textview,viewGroup,false);
        textView=(TextView) view.findViewById(R.id.textViewContact);
        //holder.text.setText(myList.get(position).getMessage());
        textView.setText(contactList.get(i).getId()+"\n"+contactList.get(i).getName()+"\n"+contactList.get(i).getEmail());
        return view;
    }
}
