package com.example.ksnimesh.theglenrock;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity4 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap Amap,Amap2,Amap3,Amap4,Amap5,Amap6,Amap7,Amap8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_maps4 );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ( ).findFragmentById ( R.id.map );
        mapFragment.getMapAsync ( this );
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
        Amap = googleMap;
        Amap2= googleMap;
        Amap3= googleMap;
        Amap4= googleMap;
        Amap5= googleMap;
        Amap6= googleMap;
        Amap7=googleMap;
        Amap8=googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sanasa = new LatLng ( 6.654227, 80.698628   );
        Amap.addMarker ( new MarkerOptions ( ).position ( sanasa ).title ( "Sanasa Bank" ) );
        Amap.moveCamera ( CameraUpdateFactory.newLatLng (sanasa ) );
        Amap.moveCamera(CameraUpdateFactory.newLatLngZoom(sanasa,13));

        LatLng Union = new LatLng ( 6.651009, 80.698465  );
        Amap2.addMarker ( new MarkerOptions ( ).position ( Union ).title ( "Union Bank" ) );
        Amap2.moveCamera ( CameraUpdateFactory.newLatLng (Union ) );
        Amap2.moveCamera(CameraUpdateFactory.newLatLngZoom(Union,13));

        LatLng ndb = new LatLng ( 6.650780, 80.697886  );
        Amap3.addMarker ( new MarkerOptions ( ).position ( ndb ).title ( "NDB Bank" ) );
        Amap3.moveCamera ( CameraUpdateFactory.newLatLng (ndb ) );
        Amap3.moveCamera(CameraUpdateFactory.newLatLngZoom(ndb,13));

        LatLng nsb = new LatLng ( 6.650160, 80.698261 );
        Amap4.addMarker ( new MarkerOptions ( ).position ( nsb ).title ( "NSB Bank" ) );
        Amap4.moveCamera ( CameraUpdateFactory.newLatLng (nsb) );
        Amap4.moveCamera(CameraUpdateFactory.newLatLngZoom(nsb,13));

        LatLng cb = new LatLng ( 6.650608, 80.700556);
        Amap5.addMarker ( new MarkerOptions ( ).position ( cb ).title ( "Commercial Bank" ) );
        Amap5.moveCamera ( CameraUpdateFactory.newLatLng (cb ) );
        Amap5.moveCamera(CameraUpdateFactory.newLatLngZoom(cb,13));


        LatLng rb = new LatLng ( 6.719935, 80.772113 );
        Amap6.addMarker ( new MarkerOptions ( ).position ( rb ).title ( "Belihuloya Rural bank" ) );
        Amap6.moveCamera ( CameraUpdateFactory.newLatLng (rb ) );
        //Amap6.moveCamera(CameraUpdateFactory.newLatLngZoom(rb,10));


        LatLng PS = new LatLng ( 6.720295, 80.786154 );
        Amap7.addMarker ( new MarkerOptions ( ).position ( PS ).title ( "People's Bank" ) );
        Amap7.moveCamera ( CameraUpdateFactory.newLatLng (PS ) );
       // Amap7.moveCamera(CameraUpdateFactory.newLatLngZoom(PS,10));

        LatLng bc = new LatLng ( 6.714918, 80.786190);
        Amap8.addMarker ( new MarkerOptions ( ).position ( bc ).title ( "BOC Pambahinna" ) );
        Amap8.moveCamera ( CameraUpdateFactory.newLatLng (bc ) );
       // Amap8.moveCamera(CameraUpdateFactory.newLatLngZoom(bc,10));



    }
}