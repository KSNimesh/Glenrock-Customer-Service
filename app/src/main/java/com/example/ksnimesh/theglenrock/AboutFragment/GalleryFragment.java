package com.example.ksnimesh.theglenrock.AboutFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.example.ksnimesh.theglenrock.Mygallery;
import com.example.ksnimesh.theglenrock.R;


public class GalleryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,
                             Bundle savedInstanceState) {
      //  return inflater.inflate( R.layout.fragment_gallery ,container ,false );
        View view = inflater.inflate( R.layout.fragment_gallery ,container ,false );

        Button about_hotel = (Button) view.findViewById( R.id.btngallery );
        about_hotel.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openGallery( );
            }
        } );

//return view;
//
//        GridView gridView =(GridView)view.findViewById(R.id.girdView  );
//        gridView.setAdapter( new ImageAdapter( this));
//
//
return view;
    }




    public void openGallery() {
        Intent intent = new Intent( getActivity(),Mygallery.class);
        startActivity( intent );
    }

}
