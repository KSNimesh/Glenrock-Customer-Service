package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome_screen );


        new android.os.Handler( ).postDelayed( new Runnable( ) {
            @Override
            public void run() {
                Intent homeintent = new Intent( WelcomeScreen.this,MainActivity.class );
                startActivity( homeintent );
             this.   finish( );
            }

            public void finish(){


            }


        },SPLASH_TIME_OUT);





    }
}
