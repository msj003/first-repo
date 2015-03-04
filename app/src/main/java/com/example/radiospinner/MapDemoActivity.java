package com.example.radiospinner;

import android.app.Activity;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.googlecode.placesapiclient.client.entity.PlaceDetails;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Manjinder singh on 20-02-2015.
 */

public class MapDemoActivity extends Activity{
    private static final String LOG_TAG = "ExampleApp";

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    private static final String API_KEY = "AIzaSyAHNPXLUgK7l3zrMo12YgLUknMHgpthUZg";

    LatLng latLng;
    ArrayList<PlacesItem> resultList;
    GoogleMap googleMap;
    double latitude = 31.310611;
    double longitude = 75.210305;
    AutoCompleteTextView autoCompleteTextView;
    String selectedPlaceId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_demo_layout);
        autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteText);
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            Marker marker=googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitude)).title("Tibba").snippet("Kiwn aa"));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(latitude,longitude)).zoom(12).build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            // check if map is created successfully or not
            if (googleMap == null) {


                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                PlacesJson places=new PlacesJson();

                places.execute(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String desc=autoCompleteTextView.getText().toString();

//                Toast.makeText(getApplicationContext(),""+desc+" "+desc.length()+"\n"+resultList.get(0).getDescription()+" "+resultList.get(0).getDescription().length(),Toast.LENGTH_SHORT).show();
                for(int j=0;j<resultList.size();j++){
                    if(desc.matches(resultList.get(j).getDescription())){
                        selectedPlaceId=resultList.get(j).getPlaceId();
                    }
                }
//                Toast.makeText(getApplicationContext(),""+selectedPlaceId,Toast.LENGTH_SHORT).show();
                PlaceDetails details=new PlaceDetails();
                details.execute(selectedPlaceId);
            }
        });

    }


    class PlacesJson extends AsyncTask<String,Void,ArrayList<PlacesItem>>{



        private ArrayList<PlacesItem> autocomplete(String input) {
            //ArrayList<PlacesItem> resultList = null;

            HttpURLConnection conn = null;
            StringBuilder jsonResults = new StringBuilder();
            try {
                StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
                sb.append("?key=" + API_KEY);
                sb.append("&components;=country:uk");
                sb.append("&input=" + URLEncoder.encode(input, "utf8"));

                URL url = new URL(sb.toString());
                conn = (HttpURLConnection) url.openConnection();
                InputStreamReader in = new InputStreamReader(conn.getInputStream());

                // Load the results into a StringBuilder
                int read;
                char[] buff = new char[1024];
                while ((read = in.read(buff)) != -1) {
                    jsonResults.append(buff, 0, read);
                }
            } catch (MalformedURLException e) {
                Log.e(LOG_TAG, "Error processing Places API URL", e);
                return resultList;
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error connecting to Places API", e);
                return resultList;
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }

            try {
                // Create a JSON object hierarchy from the results
                JSONObject jsonObj = new JSONObject(jsonResults.toString());
                JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

                // Extract the Place descriptions from the results
                resultList = new ArrayList<PlacesItem>(predsJsonArray.length());
                for (int i = 0; i < predsJsonArray.length(); i++) {
                    resultList.add(new PlacesItem(predsJsonArray.getJSONObject(i).getString("place_id"),predsJsonArray.getJSONObject(i).getString("description")));
                }
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Cannot process JSON results", e);
            }

            return resultList;
        }
        @Override
        protected ArrayList<PlacesItem> doInBackground(String... strings) {
            //return null;
            ArrayList<PlacesItem> result=new ArrayList<PlacesItem>();
                for(String place:strings){
                    result=autocomplete(place);
                }

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<PlacesItem> s) {
            super.onPostExecute(s);
            ArrayList<String> displayList=new ArrayList<String>();
            //Toast.makeText(MapDemoActivity.this,""+s.get(0).getDescription(),Toast.LENGTH_SHORT).show();
            for(int i=0;i<s.size();i++){
                displayList.add(s.get(i).getDescription());
            }

            String desc;
            String placeId;
            ArrayAdapter arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.places_auto_text_layout,R.id.autocomplisttext,displayList);
            autoCompleteTextView.setAdapter(arrayAdapter);
        }
    }

    class PlaceDetails extends AsyncTask<String,Void,LatLng>{
        @Override
        protected LatLng doInBackground(String... strings) {
            //return null;
            HttpURLConnection conn = null;
            StringBuilder jsonResults = new StringBuilder();

            for(String placeId:strings) {
                try {
                    StringBuilder sb = new StringBuilder(PLACES_API_BASE + "/details" + OUT_JSON);
                    sb.append("?placeid=");
                    sb.append(placeId);
                    sb.append("&key=" + API_KEY);
                    //  sb.append("&input=" + URLEncoder.encode(input, "utf8"));

                    URL url = new URL(sb.toString());
                    Log.e("------------------------",url.toString());
                    //Toast.makeText(getApplicationContext(), url.toString(), Toast.LENGTH_SHORT).show();
                    conn = (HttpURLConnection) url.openConnection();
                    InputStreamReader in = new InputStreamReader(conn.getInputStream());

                    // Load the results into a StringBuilder
                    int read;
                    char[] buff = new char[1024];
                    while ((read = in.read(buff)) != -1) {
                        jsonResults.append(buff, 0, read);
                    }
                } catch (MalformedURLException e) {
                    Log.e(LOG_TAG, "Error processing Places API URL", e);
                }catch (IOException e){
                    Log.e(LOG_TAG, "Error processing Places API IO", e);
                }finally {
                    if (conn != null) {
                        conn.disconnect();
                    }
                }
            }
            try{
                JSONObject jsonObj = new JSONObject(jsonResults.toString());
                JSONObject results = jsonObj.getJSONObject("result");

                    JSONObject location = results.getJSONObject("geometry").getJSONObject("location");;
                    Double lat  = location.optDouble("lat");
                    Double lng  = location.optDouble("lng");
                    latLng=new LatLng(lat,lng);

            }catch (JSONException e){
                Log.e(LOG_TAG, "Error In JSON", e);
            }
            return latLng;
        }

        @Override
        protected void onPostExecute(LatLng s) {
            super.onPostExecute(s);
            Marker marker=googleMap.addMarker(new MarkerOptions().position(s).title(s.toString()).snippet("Kiwn aa"));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(s).zoom(12).build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }
    }
}