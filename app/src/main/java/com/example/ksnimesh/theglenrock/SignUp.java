package com.example.ksnimesh.theglenrock;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText edtRoom,edtPackage,edtPassword;
    private String Room,pack,password;
    Button  btmsSignUp;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPackage=(EditText) findViewById( R.id.Roompack );
        edtPassword=(EditText) findViewById( R.id.passwordNo );
        edtRoom=(EditText) findViewById( R.id.RoomNo );

        btmsSignUp=(Button)findViewById( R.id.btnSignUp );

        //init Firebase
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference table_User= database.getReference("User");
        btmsSignUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mdialog =new ProgressDialog(SignUp.this);
                mdialog.setMessage("Please waiting...");
                mdialog.show();

                //validation
                register();

            table_User.addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //checking ready
                    if(dataSnapshot.child(edtPackage.getText().toString()).exists()){
                    mdialog.dismiss();
                        //Toast.makeText( SignUp.this,"package is already register",Toast.LENGTH_SHORT ).show();
                        return;
                    }
                    else {
                    mdialog.dismiss();
                    User user=new  User(edtRoom.getText().toString(),edtPassword.getText().toString());
                    table_User.child( edtPackage.getText().toString() ).setValue(user);
                        Toast.makeText( SignUp.this,"Sign up Successfully",Toast.LENGTH_SHORT ).show();
                        finish();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            } );

            }
        } );

    }
    public boolean register(){
        intialize();
        Validate();

        if(!Validate()){
            Toast.makeText( this,"SignUp has faild",Toast.LENGTH_SHORT ).show();
            }
            else{
            omSignupsuccess();
        }
        return false;
    }

    public void omSignupsuccess(){
        //TODO what will go after the valid input;

    }
    public boolean Validate(){
            Boolean valid=true;
            if(pack.isEmpty()||pack.length()>32){
               // edtPackage.setError("Please Enter Valid Package");
                valid=false;
                }

        if(Room.isEmpty()||Room.length()>32){
           // edtRoom.setError("Please Enter Valid Package");
            valid=false;
        }

        return false;
    }
    public boolean intialize(){
        Room=edtRoom.getText().toString().trim();
        pack=edtRoom.getText().toString().trim();


        return false;
    }

}
