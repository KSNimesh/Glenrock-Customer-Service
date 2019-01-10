package com.example.ksnimesh.theglenrock.HomeFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import com.example.ksnimesh.theglenrock.Connectivity;
import com.example.ksnimesh.theglenrock.Connectivity;
import com.example.ksnimesh.theglenrock.Connectivitys;
import com.example.ksnimesh.theglenrock.Facilities;
import com.example.ksnimesh.theglenrock.R;
import com.example.ksnimesh.theglenrock.Reservation;
import com.example.ksnimesh.theglenrock.Travel_Guide;
import com.example.ksnimesh.theglenrock.about_hotel;


public class FragmenmtHome extends Fragment {
//
//    private Button about_hotel;
    private Button reserve;
    private Button Travel;
    private Button Facility;
    private Button Connectivity;


    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate( R.layout.fragment_fragmenmt_home ,container ,false );
        Button about_hotel=(Button)view.findViewById( R.id.about_hotels );
        about_hotel.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openabout_hotel();
            }
        } );



        Button reserve=(Button)view.findViewById( R.id.reservation );
        reserve.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openReserevation();
            }
        } );


        Button Travel=(Button)view.findViewById( R.id.travel_guide );
        Travel.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                opentravel();
            }
        } );



//        Button facilities=(Button)view.findViewById( R.id.facilities );
//        facilities.setOnClickListener( new View.OnClickListener( ) {
//            @Override
//            public void onClick(View v) {
//                openfacilities();
//            }
//        } );




        Button connect=(Button)view.findViewById( R.id.Connectivity );
        connect.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openconnect();
            }
        } );



        return view;



    }

    public void openabout_hotel() {
        Intent intent = new Intent( getActivity(),about_hotel.class);
        startActivity( intent );
    }

    public void openReserevation() {
        Intent intent = new Intent( getActivity(),Reservation.class);
        startActivity( intent );
    }


    public void opentravel() {
        Intent intent = new Intent( getActivity(),Travel_Guide.class);
        startActivity( intent );
    }


//    public void openfacilities() {
//        Intent intent = new Intent( getActivity(),Facilities.class);
//        startActivity( intent );
//    }


    public void openconnect() {
        Intent intent = new Intent( getActivity(),Connectivity.class);
        startActivity( intent );
    }


}








