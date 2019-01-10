package com.example.ksnimesh.theglenrock.AboutFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ksnimesh.theglenrock.R;



public class AccomodationFrag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,
                             Bundle savedInstanceState) {


        View view = inflater.inflate( R.layout.fragment_accomodation ,container ,false );
//        Button Twiter = (Button) view.findViewById( R.id.Twittwerntn );
//        Twiter.setOnClickListener( new View.OnClickListener( ) {
//            @Override
//            public void onClick(View v) {
//                openspecial( );
//            }
//        } );
//
//
//        Button supiri = (Button) view.findViewById( R.id.Twittwerntn );
//        Twiter.setOnClickListener( new View.OnClickListener( ) {
//            @Override
//            public void onClick(View v) {
//                opensupiri( );
//            }
//        } );
//
//        Button semi = (Button) view.findViewById( R.id.Twittwerntn );
//        Twiter.setOnClickListener( new View.OnClickListener( ) {
//            @Override
//            public void onClick(View v) {
//                opensemi( );
//            }
//        } );

        return view;
    }


//    public void openspecial() {
//        Intent intent = new Intent( getActivity(),Speciality.class);
//        startActivity( intent );
//    }
//
//    public void opensupiri() {
//        Intent intent = new Intent( getActivity(),Speciality.class);
//        startActivity( intent );
//    }
//
//    public void opensemi() {
//        Intent intent = new Intent( getActivity(),Speciality.class);
//        startActivity( intent );
//    }

}





