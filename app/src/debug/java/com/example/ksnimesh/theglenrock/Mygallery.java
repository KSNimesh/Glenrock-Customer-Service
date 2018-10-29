package com.example.ksnimesh.theglenrock;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ksnimesh.theglenrock.AboutFragment.ImageAdapter;


public class Mygallery extends AppCompatActivity {

    @Override
    public void onCreate( Bundle saveInstanceState ) {
        super.onCreate( saveInstanceState );
        setContentView( R.layout.activity_mygallery );


//
        GridView gridView =(GridView)findViewById(R.id.girdView  );
        gridView.setAdapter( new ImageAdapter( this));


        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView <?> parent ,View view ,int position ,long id) {
                Intent i = new Intent( getApplicationContext(), FullImage.class );
                i.putExtra( "id",position );
                startActivity( i );
            }
        } );


    }





    }

