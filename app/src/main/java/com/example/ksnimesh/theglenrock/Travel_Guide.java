package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.bloder.magic.view.MagicButton;

public class Travel_Guide extends AppCompatActivity {
    private Button maps;
    private Button maps2;
    MagicButton map3;
    MagicButton map4;
    MagicButton map5;
    MagicButton mapATM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_travel__guide );

//        maps = (Button) findViewById ( R.id.btnMap );
//        maps.setOnClickListener ( new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View v) {
//                Openmap ( );
//            }
//        } );

        //new
        map3 = (MagicButton) findViewById ( R.id.magic_button );
        map3.setMagicButtonClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                openmaps2 ( );
            }
        } );

        map4 = (MagicButton) findViewById ( R.id.magic_button2 );
        map4.setMagicButtonClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Openmap ( );
            }
        } );

        map5 = (MagicButton) findViewById ( R.id.magic_button3 );
        map5.setMagicButtonClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Openmap3 ( );
            }
        } );

        mapATM = (MagicButton) findViewById ( R.id.magic_button4 );
        mapATM.setMagicButtonClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Openmap4 ( );
            }
        } );


    }

    public void Openmap() {
        Intent intent = new Intent ( this , MapsActivity1.class );
        startActivity ( intent );

    }

    public void openmaps2() {
        Intent intent = new Intent ( this , MapsActivity2.class );
        startActivity ( intent );

    }

    public void Openmap3() {
        Intent intent = new Intent ( this , MapsActivity3.class );
        startActivity ( intent );


    }


    public void Openmap4() {
        Intent intent = new Intent ( this , MapsActivity4.class );
        startActivity ( intent );


    }
}



