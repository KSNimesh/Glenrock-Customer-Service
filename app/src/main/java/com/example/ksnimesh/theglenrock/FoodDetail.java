package com.example.ksnimesh.theglenrock;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ksnimesh.theglenrock.Database.Database;
import com.example.ksnimesh.theglenrock.Model.Foods;
import com.example.ksnimesh.theglenrock.Model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {
    TextView food_namea,food_pricea,food_descriptiona;
    ImageView food_imagea;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    String foodId="";


    FirebaseDatabase database;
    DatabaseReference foods;

    Foods CurrentFood;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_food_detail );
        //firebase

        database=FirebaseDatabase.getInstance ();
        foods=database.getReference ("Foods");

        numberButton= (ElegantNumberButton)findViewById ( R.id.number_button );

        //cart button
        btnCart=(FloatingActionButton)findViewById ( R.id.btncart );
        btnCart.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                new Database (  getBaseContext ()).addToCart ( new Order (
                        foodId,
                        CurrentFood.getName (),
                        CurrentFood.getPrice (),
                        CurrentFood.getDiscount (),
                        numberButton.getNumber ()


                ) );

                Toast.makeText ( FoodDetail.this,"Added to Cart ",Toast.LENGTH_SHORT ).show ();
            }
        } );




        food_descriptiona=(TextView)findViewById ( R.id.food_descriptionq );
        food_namea=(TextView)findViewById ( R.id.food_nameq );
        food_pricea=(TextView)findViewById ( R.id.food_priceq );
        food_imagea= (ImageView) findViewById ( R.id.img_food );

        collapsingToolbarLayout =(CollapsingToolbarLayout)findViewById ( R.id.collasping );
        collapsingToolbarLayout.setExpandedTitleTextAppearance ( R.style.ExpandedAppbar );
        collapsingToolbarLayout.setCollapsedTitleTextAppearance ( R.id.CollapsedAppbar );

        //Getting Food Id from intent

        if (getIntent ()!=null){
            foodId=getIntent ().getStringExtra ( "FoodId" );
            if (!foodId.isEmpty ()&& foodId!=null){

                getDetailFood(foodId);
            }

        }

    }

    private void getDetailFood(String foodId) {
        foods.child ( foodId ).addValueEventListener ( new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CurrentFood = dataSnapshot.getValue ( Foods.class );

                Picasso.with ( getBaseContext ( ) ).load ( CurrentFood.getImage () )
                        .into ( food_imagea);


                            collapsingToolbarLayout.setTitle ( CurrentFood.getName ( ) );

                food_pricea.setText ( CurrentFood.getPrice ( ) );
                food_namea.setText ( CurrentFood.getName ( ) );
                food_descriptiona.setText ( CurrentFood.getDescription ( ) );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        } );


    }
}
