package com.example.ksnimesh.theglenrock;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
//private Button about_hotel;
//private Button reserve;
//private Button Travel;
//private Button Facility;
//private Button Connectivity;

    private static int SPLASH_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);





        BottomNavigationView bottomNavigationView =(BottomNavigationView)findViewById( R.id.bottom_navigation );
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener( ) {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment Selectmen=null;
             if(menuItem.getItemId()== R.id.nav_home) {

                 Selectmen=new FragmenmtHome();
                 android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                 android.support.v4.app.FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                 fragmentTransaction.replace( R.id.fragment_container,Selectmen );
                 fragmentTransaction.commit();


             }

                else if(menuItem.getItemId()== R.id.nav_event) {

                 Selectmen=new FragmentEvent();
                 android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                 android.support.v4.app.FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                 fragmentTransaction.replace( R.id.fragment_container,Selectmen );
                 fragmentTransaction.commit();

                }

             else if(menuItem.getItemId()== R.id.nav_contact) {
                 Selectmen=new FragmentContact();
                 android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                 android.support.v4.app.FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                 fragmentTransaction.replace( R.id.fragment_container,Selectmen );
                 fragmentTransaction.commit();
             }





                return true;
            }
        } );

//        about_hotel=(Button)findViewById(R.id.about_hotel);
//        about_hotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openabout_hotel();
//            }
//        });
//
//        reserve=(Button)findViewById(R.id.reservation);
//        reserve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openreservation();
//            }
//        });
//
//       Travel =(Button)findViewById(R.id.travel_guide);
//       Travel.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               opentravel();
//           }
//       });
//
//        Facility =(Button)findViewById(R.id.facilities);
//        Facility.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openfacility();
//            }
//        });
//
//
//        Connectivity =(Button)findViewById(R.id.Connectivity);
//        Connectivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openconnectivity();
//            }
//        });




    }
//    public void openabout_hotel(){
//        Intent intent=new Intent(this,about_hotel.class);
//        startActivity(intent);
//    }
//    public void openreservation(){
//        Intent intent= new Intent(this,Reservation.class);
//        startActivity(intent);
//    }
//    public void opentravel(){
//        Intent intent=new Intent(this,Travel_Guide.class);
//        startActivity(intent);
//
//    }
//    public void openfacility(){
//        Intent intent=new Intent(this,Facilities.class);
//        startActivity(intent);
//
//    }
//    public void openconnectivity(){
//        Intent intent=new Intent(this,Connectivity.class);
//        startActivity(intent);
//
//    }





}


