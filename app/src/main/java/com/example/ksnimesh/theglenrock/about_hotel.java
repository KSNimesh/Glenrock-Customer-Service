package com.example.ksnimesh.theglenrock;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ksnimesh.theglenrock.AboutFragment.AboutFragment;
import com.example.ksnimesh.theglenrock.AboutFragment.AccomodationFrag;
import com.example.ksnimesh.theglenrock.AboutFragment.GalleryFragment;
import com.example.ksnimesh.theglenrock.HomeFragment.FragmenmtHome;
import com.example.ksnimesh.theglenrock.HomeFragment.FragmentContact;
import com.example.ksnimesh.theglenrock.HomeFragment.FragmentEvent;

public class about_hotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_hotel);



        getSupportFragmentManager( ).beginTransaction( ).replace( R.id.fragment_container_about ,new AboutFragment( ) ).commit( );
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottom_navigation_about );
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener( ) {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment Select = null;
                if (menuItem.getItemId( ) == R.id.nav_about) {

                    Select = new AboutFragment( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container_about ,Select );
                    fragmentTransaction.commit( );


                } else if (menuItem.getItemId( ) == R.id.nav_accomdation) {

                    Select = new AccomodationFrag( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container_about ,Select );
                    fragmentTransaction.commit( );

                } else if (menuItem.getItemId( ) == R.id.nav_gallery) {
                    Select = new GalleryFragment( );
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager( );
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
                    fragmentTransaction.replace( R.id.fragment_container_about ,Select );
                    fragmentTransaction.commit( );
                }


                return true;
            }
        } );







    }
}
