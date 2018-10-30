package com.example.ksnimesh.theglenrock;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.FoodOrder.FoodCommon;
import com.example.ksnimesh.theglenrock.Model.User;
import com.google.android.gms.signin.SignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {
        EditText edtPacakage_No,edtPassword_No;
        Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        edtPassword_No= (EditText)findViewById(R.id.Password_No);
        edtPacakage_No= (EditText)findViewById(R.id.Package_No);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        //init Firebase
       final FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference table_User= database.getReference("User");


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final ProgressDialog mdialog =new ProgressDialog(Sign_In.this);
               mdialog.setMessage("Please waiting...");
                mdialog.show();


                table_User.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //Check if user not exist in database
                        if (dataSnapshot.child(edtPacakage_No.getText().toString()).exists()) {
                            //getting user infomation
                          mdialog.dismiss();
                            User user = dataSnapshot.child(edtPacakage_No.getText().toString()).getValue(User.class);
                            user.setPackage_No ( edtPacakage_No.getText ().toString () );
                            if (user.getPassword().equals(edtPassword_No.getText().toString())) {
                               Toast.makeText(Sign_In.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();


                                Intent FoodnavHome=new Intent( Sign_In.this, com.example.ksnimesh.theglenrock.FoodnavHome.class );
                                FoodCommon.currentUser=user;
                                startActivity( FoodnavHome );
                                finish();


                            } else {
                                mdialog.dismiss();

                                Toast.makeText(Sign_In.this, "Wrong Password !!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            mdialog.dismiss();
                            Toast.makeText(Sign_In.this, "Package_No not exist in Database!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
