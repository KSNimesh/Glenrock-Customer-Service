package com.example.ksnimesh.theglenrock;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GoogleMap mMap2;
    private GoogleMap mMap3;
    private  GoogleMap mMap4;
    private GoogleMap mMap5;
    private GoogleMap mMap6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_maps3 );
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
        mMap = googleMap;
        mMap2= googleMap;
        mMap3= googleMap;
        mMap4= googleMap;
        mMap5= googleMap;
        mMap6= googleMap;


        // Add a marker in Sydney and move the camera
        LatLng cofs = new LatLng ( 6.636254,80.7007038     );
        mMap.addMarker ( new MarkerOptions ( ).position ( cofs ).title ( "Corporative Filling Station" ) );
        mMap.moveCamera ( CameraUpdateFactory.newLatLng (cofs ) );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cofs,10));

        LatLng IOC = new LatLng ( 6.6467955,80.7009161   );
        mMap2.addMarker ( new MarkerOptions ( ).position ( IOC ).title ( "IOC Filling Station" ) );
        mMap2.moveCamera ( CameraUpdateFactory.newLatLng (IOC ) );
        mMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(IOC,10));

        LatLng HLW = new LatLng ( 6.650796, 80.701340   );
        mMap3.addMarker ( new MarkerOptions ( ).position ( HLW ).title ( "HLW Filling Station" ) );
        mMap3.moveCamera ( CameraUpdateFactory.newLatLng (HLW ) );
        mMap3.moveCamera(CameraUpdateFactory.newLatLngZoom(HLW,10));

        LatLng Cepetco = new LatLng ( 6.721225, 80.786159 );
        mMap4.addMarker ( new MarkerOptions ( ).position ( Cepetco ).title ( "Cepetco Fuel Mart" ) );
        mMap4.moveCamera ( CameraUpdateFactory.newLatLng (Cepetco) );
        mMap4.moveCamera(CameraUpdateFactory.newLatLngZoom(Cepetco,10));

        LatLng PFS = new LatLng ( 6.7612908,80.8851867);
        mMap5.addMarker ( new MarkerOptions ( ).position ( PFS ).title ( "Premaratne Fuel Mart" ) );
        mMap5.moveCamera ( CameraUpdateFactory.newLatLng (PFS ) );
        mMap5.moveCamera(CameraUpdateFactory.newLatLngZoom(PFS,10));


        LatLng Cep = new LatLng ( 6.768293, 80.959840);
        mMap6.addMarker ( new MarkerOptions ( ).position ( Cep ).title ( "Ceypetco Filling Station" ) );
        mMap6.moveCamera ( CameraUpdateFactory.newLatLng (Cep ) );
        mMap6.moveCamera(CameraUpdateFactory.newLatLngZoom(Cep,10));




    }
}
