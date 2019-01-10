package com.example.ksnimesh.theglenrock.AboutFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ksnimesh.theglenrock.R;



public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_about ,container ,false );
////        TextView mtitle = (TextView)view.findViewById( R.id.abouthotely ) ;
////        TextView mmassages = (TextView)view.findViewById( R.id.abouthotelz ) ;
//
//        mtitle.setText( "this my title" );
//
//        StringBuilder stringBuilder=new StringBuilder(  );
//        String somemasssage= "my paragap thada ulmejka mona kawru loiwat" ;
//
//            for(int i=0; i<100; i++){
//                stringBuilder.append( somemasssage );
//
//                mmassages.setText( stringBuilder.toString() );
//            }


        return view;
    }


    }




