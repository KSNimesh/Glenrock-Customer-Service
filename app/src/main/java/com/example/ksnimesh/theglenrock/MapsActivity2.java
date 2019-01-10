package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.ksnimesh.theglenrock.LandmarkPlaces.Landmark_detail01;
import com.example.ksnimesh.theglenrock.LandmarkPlaces.lanmark_detail2;
import com.example.ksnimesh.theglenrock.LandmarkPlaces.lanmark_detail3;
import com.example.ksnimesh.theglenrock.LandmarkPlaces.lanmark_detail4;
import com.example.ksnimesh.theglenrock.LandmarkPlaces.lanmark_detail5;
import com.example.ksnimesh.theglenrock.LandmarkPlaces.lanmark_detail6;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap1,map2,map3,map4,map5,map6,map7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
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
        mMap1 = googleMap;
        map2=googleMap;
        map3=googleMap;
        map4=googleMap;
        map5=googleMap;
        map5=googleMap;
        map6=googleMap;
        map7=googleMap;

        // Add a marker in Sydney and move the camera
        LatLng adarakanda = new LatLng(6.7369795,80.7797668);
        mMap1.addMarker(new MarkerOptions().position(adarakanda).title("Adarakanda Mountain peak"));
        mMap1.moveCamera(CameraUpdateFactory.newLatLng(adarakanda));
       // mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(adarakanda,11));


        LatLng pahanthudawa = new LatLng ( 6.7257285,80.7566866    );
        map2.addMarker ( new MarkerOptions ( ).position ( pahanthudawa ).title ( "Pahanthudawa Falls" ) );
        map2.moveCamera ( CameraUpdateFactory.newLatLng (pahanthudawa ) );
        map2.moveCamera(CameraUpdateFactory.newLatLngZoom(pahanthudawa,11));

        LatLng wangedi = new LatLng ( 6.7612026,80.8152578    );
        map3.addMarker ( new MarkerOptions ( ).position ( wangedi ).title ( "Wangedigala Mountain peak" ) );
        map3.moveCamera ( CameraUpdateFactory.newLatLng (wangedi ) );
        map3.moveCamera(CameraUpdateFactory.newLatLngZoom(wangedi,11));

        LatLng samanala = new LatLng ( 6.6802136,80.7974273    );
        map4.addMarker ( new MarkerOptions ( ).position ( samanala ).title ( "Samanala Wewa Dam" ) );
        map4.moveCamera ( CameraUpdateFactory.newLatLng (samanala ) );
        map4.moveCamera(CameraUpdateFactory.newLatLngZoom(samanala,11));

        LatLng bamabara = new LatLng ( 6.6802136,80.7974273    );
        map5.addMarker ( new MarkerOptions ( ).position ( bamabara ).title ( "bambarakanda Falls" ) );
        map5.moveCamera ( CameraUpdateFactory.newLatLng (bamabara ) );
        map5.moveCamera(CameraUpdateFactory.newLatLngZoom(bamabara,11));

        LatLng havagala = new LatLng ( 6.7239379,80.7318733   );
        map6.addMarker ( new MarkerOptions ( ).position ( havagala ).title ( "Havagala Mountain peak") );
        map6.moveCamera ( CameraUpdateFactory.newLatLng (havagala ) );
        map6.moveCamera(CameraUpdateFactory.newLatLngZoom(havagala,11));

        LatLng surathali = new LatLng ( 6.7457967,80.8265876   );
        map7.addMarker ( new MarkerOptions ( ).position ( surathali ).title ( "Surathali Waterfalls") );
        map7.moveCamera ( CameraUpdateFactory.newLatLng (surathali ) );
        map7.moveCamera(CameraUpdateFactory.newLatLngZoom(surathali,11));




        mMap1.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,Landmark_detail01.class);
                startActivity(intent);
            }


        });


        map2.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,lanmark_detail2.class);
                startActivity(intent);
            }


        });

        map3.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,lanmark_detail3.class);
                startActivity(intent);
            }


        });

        map4.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,lanmark_detail4.class);
                startActivity(intent);
            }


        });


        map5.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,lanmark_detail5.class);
                startActivity(intent);
            }


        });

        map6.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity2.this,lanmark_detail6.class);
                startActivity(intent);
            }


        });

//        map7.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                Intent intent=new Intent(MapsActivity2.this,la.class);
//                startActivity(intent);
//            }
//
//
//        });


    }
}
