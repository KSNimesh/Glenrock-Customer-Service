package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.Model.Foods;
import com.example.ksnimesh.theglenrock.ViewHolderF.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Foodlist extends AppCompatActivity {

    String categoryId="";
    RecyclerView recyclerView;
    RecyclerView recycler_food;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter <Foods, FoodViewHolder> adapter;
   // String categoryId = "";

    FirebaseDatabase database;
    DatabaseReference foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_foodlist );

        database = FirebaseDatabase.getInstance ();
        foodList = database.getReference ( "Foods" );

        recyclerView = (RecyclerView) findViewById ( R.id.Recycler_food );
        recyclerView.setHasFixedSize ( true );
        layoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager ( layoutManager );




        //get intent here
        if (getIntent () != null) {
            categoryId = getIntent ().getStringExtra ( "CategoryId" );
            if (!categoryId.isEmpty () && categoryId != null) {

                loadLitsFood ( categoryId );
            }
        }


    }


    private boolean loadLitsFood(String categoryId) {
        adapter  = new FirebaseRecyclerAdapter <Foods, FoodViewHolder> ( Foods.class ,
                R.layout.food_items ,
                FoodViewHolder.class ,
                foodList.orderByChild ( "MenuID" ).equalTo ( categoryId ) ) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder , Foods model , int position) {
              viewHolder.food_name.setText ( model.getName () );
                Picasso.with ( getBaseContext ()).load(model.getImage () )
                        .into ( viewHolder.food_image );




                final Foods local=model;

                viewHolder.setItemClickListener( new AdapterView.OnItemClickListener () {
                    @Override
                    public void onItemClick(AdapterView <?> parent , View view , int position , long id) {
                       // Toast.makeText ( Foodlist.this , "" + local.getName ( ) , Toast.LENGTH_SHORT ).show ( );
                        Intent foodDetail=new Intent ( Foodlist.this,FoodDetail.class );
                        foodDetail.putExtra ( "FoodId",adapter.getRef ( position ).getKey () );
                        startActivity ( foodDetail );
                    }


                } );


                }



//            private void populateViewHolder(FoodViewHolder viewHolder , Category model , int position) {
//                RecyclerView.ViewHolder.food_name
//            }
        };
        recyclerView.setAdapter ( adapter );
        return false;
    }
}

