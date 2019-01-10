package com.example.ksnimesh.theglenrock.Tabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ksnimesh.theglenrock.R;


public class Tab2 extends Fragment {


public Tab2(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_tab2 ,container ,false );

        Button facebook = (Button) view.findViewById( R.id.facebookBtn );
        facebook.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openfacebook( );
            }
        } );

        Button Tripadvisor = (Button) view.findViewById( R.id.TripadddBtn );
        Tripadvisor.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                opentripad( );
            }
        } );

        Button Insta = (Button) view.findViewById( R.id.InstagramBtn );
        Insta.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openinsta( );
            }
        } );


        Button Twiter = (Button) view.findViewById( R.id.Twittwerntn );
        Twiter.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                opentwitter( );
            }
        } );

        return view;
    }

    public void openfacebook(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://web.facebook.com/TheGlenrock/?ref=br_rs"));
        startActivity(intent);

    }

    public void opentripad(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.tripadvisor.com/Hotel_Review-g1061125-d8795324-Reviews-The_glenrock-Belihuloya_Sabaragamuwa_Province.html"));
        startActivity(intent);

    }

    public void openinsta(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/explore/locations/1034098239/the-glenrock/"));
        startActivity(intent);

    }

    public void opentwitter(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/the_glenrock?lang=en"));
        startActivity(intent);

    }


    public interface OnFragmentInteractionListener {
    }
}
