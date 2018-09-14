package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.Model.User;
import com.google.android.gms.common.SignInButton;

public class Reservation extends AppCompatActivity {
 Button btnSignIn,btnSignUp;
 EditText PasswordNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        PasswordNo= (EditText)findViewById(R.id.passwordNo);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User user1 = new User();
//                if(user1.getPassword().equals(PasswordNo.getText().toString())){
//                    Toast.makeText(Reservation.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();
//                }
                Intent SignIn=new Intent(Reservation.this,Sign_In.class);
                startActivity(SignIn);
            }
        });

    }

}
