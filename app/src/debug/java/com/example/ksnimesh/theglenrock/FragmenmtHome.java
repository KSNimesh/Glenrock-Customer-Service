package com.example.ksnimesh.theglenrock;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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

        return view;



    }

    public void openabout_hotel() {
        Intent intent = new Intent( getActivity(),about_hotel.class);
        startActivity( intent );
    }




}








