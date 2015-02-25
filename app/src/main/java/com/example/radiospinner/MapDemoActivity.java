package com.example.radiospinner;

import android.app.Activity;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Manjinder singh on 20-02-2015.
 */
public class MapDemoActivity extends Activity{

    GoogleMap googleMap;
    double latitude = 31.310611;
    double longitude = 75.210305;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_demo_layout);

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

    }


}
