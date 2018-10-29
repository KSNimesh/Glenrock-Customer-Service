package com.example.ksnimesh.theglenrock;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;


import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ksnimesh.theglenrock.HomeFragment.FragmenmtHome;
import com.example.ksnimesh.theglenrock.HomeFragment.FragmentContact;
import com.example.ksnimesh.theglenrock.HomeFragment.FragmentEvent;

public class MainActivity extends AppCompatActivity {
//private Button about_hotel;
//private Button reserve;
//private Button Travel;
//private Button Facility;
//private Button Connectivity;

    private static int SPLASH_TIME_OUT = 3000;

// exit permissiom


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

//
//        new android.os.Handler( ).postDelayed( new Runnable( ) {
//            @Override
//            public void run() {
//                Intent homeintent = new Intent( MainActivity.this,WelcomeScreen.class );
//                startActivity( homeintent );
//                finish( );
//            }
//
//        },SPLASH_TIME_OUT);
//
//
//





        getSupportFragmentManager( ).beginTransaction( ).replace( R.id.fragment_container ,new FragmenmtHome( ) ).commit( );
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottom_navigation );
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener( ) {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment Selectmen = null;
                if (menuItem.getItemId( ) == R.id.nav_home) {

                    Selectmen = new FragmenmtHome( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container ,Selectmen );
                    fragmentTransaction.commit( );


                } else if (menuItem.getItemId( ) == R.id.nav_event) {

                    Selectmen = new FragmentEvent( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container ,Selectmen );
                    fragmentTransaction.commit( );

                } else if (menuItem.getItemId( ) == R.id.nav_contact) {
                    Selectmen = new FragmentContact( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container ,Selectmen );
                    fragmentTransaction.commit( );
                }


                return true;
            }
        } );






    }


}



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








