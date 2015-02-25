package com.example.radiospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Manjinder singh on 17-02-2015.
 */
public class HttpDemoActivity extends Activity {
    ListView list;
    JSONArray contacts=null;
    Button btn,btnPost;
    Contact contact;
    ArrayList<Contact> contactList;
    ContactListAdapter contactListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_layout);
        list=(ListView) findViewById(R.id.httpListView);
        btn=(Button) findViewById(R.id.btnH);
        btnPost=(Button) findViewById(R.id.buttonPostJson);
        contactList=new ArrayList<Contact>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactList.clear();
                DownloadPageClass dwn=new DownloadPageClass();
                dwn.execute(new String[] {"http://api.androidhive.info/contacts/"});
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact selectedItem=contactList.get(i);
                String selectedName=selectedItem.getName();
                contactList.remove(i);
                contactListAdapter=(ContactListAdapter) list.getAdapter();
                contactListAdapter.notifyDataSetChanged();
                //contactListAdapter = new ContactListAdapter(getApplicationContext(),contactList);
                //list.setAdapter(contactListAdapter);
                Toast.makeText(getApplicationContext(),"This was "+i+" "+selectedName,Toast.LENGTH_SHORT).show();
                return true;
            }
        });




        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject postThis=new JSONObject();
                JSONArray jarray=new JSONArray();

                try {
                    jarray.put(0,"a");
                    jarray.put(1,"b");
                    jarray.put(2,"c");
                    postThis.put("name", "msj");
                    postThis.put("id", 1);
                    postThis.put("myArray",jarray);
                }catch (JSONException e){

                }
                    Toast.makeText(getApplicationContext(),""+postThis.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private class DownloadPageClass extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
           // return null;
            String response="";
            for(String url:strings){
                DefaultHttpClient client=new DefaultHttpClient();
                HttpGet httpGet=new HttpGet(url);
                try {
                    HttpResponse httpResponse = client.execute(httpGet);
                    InputStream content = httpResponse.getEntity().getContent();
                    BufferedReader bfReader = new BufferedReader(new InputStreamReader(content));
                    String s = "";
                    while ((s = bfReader.readLine()) != null) {
                        response += s;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(response != null) {
                try {
                    //textView.setText(response);
                    JSONObject jsonObject = new JSONObject(response);
                    contacts=jsonObject.getJSONArray("contacts");
                    for(int i=0;i<contacts.length();i++){
                        JSONObject c=contacts.getJSONObject(i);
                        String id=c.getString("id");
                        String name=c.getString("name");
                        String email=c.getString("email");
                        String address=c.getString("address");
                        String gender=c.getString("gender");

                        JSONObject phone=c.getJSONObject("phone");
                        String mobile=phone.getString("mobile");
                        String home=phone.getString("home");
                        String office= phone.getString("office");
//                        contact.setId(id);
//                        contact.setEmail(email);
//                        contact.setName(name);
                        //contactList.add(contact);
                        contactList.add(new Contact(id,name,email));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }else{
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            contactListAdapter = new ContactListAdapter(getApplicationContext(),contactList);
            list.setAdapter(contactListAdapter);
        }
    }

}
