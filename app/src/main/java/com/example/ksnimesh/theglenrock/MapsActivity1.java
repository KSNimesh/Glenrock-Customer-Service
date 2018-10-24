package com.example.ksnimesh.theglenrock;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap bmap,bmap2,bmap3,bmap4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        bmap = googleMap;
        bmap2=googleMap;
        bmap3=googleMap;
        bmap4=googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ndb = new LatLng ( 6.768311, 80.957604  );
        bmap.addMarker ( new MarkerOptions ( ).position ( ndb ).title ( "Haputale railway Station" ) );
        bmap.moveCamera ( CameraUpdateFactory.newLatLng (ndb ) );
        bmap.moveCamera(CameraUpdateFactory.newLatLngZoom(ndb,13));

//        LatLng nsb = new LatLng ( 6.650160, 80.698261 );
//        bmap2.addMarker ( new MarkerOptions ( ).position ( nsb ).title ( "NSB Bank" ) );
//        bmap2.moveCamera ( CameraUpdateFactory.newLatLng (nsb) );
//        bmap2.moveCamera(CameraUpdateFactory.newLatLngZoom(nsb,13));
//
//        LatLng cb = new LatLng ( 6.650608, 80.700556);
//        bmap3.addMarker ( new MarkerOptions ( ).position ( cb ).title ( "Commercial Bank" ) );
//        bmap3.moveCamera ( CameraUpdateFactory.newLatLng (cb ) );
//        bmap3.moveCamera(CameraUpdateFactory.newLatLngZoom(cb,13));



    }


}
