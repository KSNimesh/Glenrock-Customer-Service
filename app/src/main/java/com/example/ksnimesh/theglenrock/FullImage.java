package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ksnimesh.theglenrock.AboutFragment.ImageAdapter;

public class FullImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_full_image );

        Intent i=getIntent();
        int position =i.getExtras().getInt( "id" );
        ImageAdapter adapter= new ImageAdapter( this );

        ImageView imageView =(ImageView) findViewById( R.id.ImageGallery   );
        imageView.setImageResource( adapter.images[position] );
    }
}
