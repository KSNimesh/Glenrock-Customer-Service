package com.example.ksnimesh.theglenrock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.ksnimesh.theglenrock.Database.Database;
import com.example.ksnimesh.theglenrock.Model.Order;
import com.example.ksnimesh.theglenrock.ViewHolderF.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity  {

    RecyclerView recylerView;
    RecyclerView.LayoutManager LayoutManager;

    FirebaseDatabase database;
    DatabaseReference request;

    TextView txtTotalPrice;
    Button btnPlace;

    List<Order> cart=new ArrayList <> (  );
    CartAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cart );

        database= FirebaseDatabase.getInstance ();
        request=database.getReference ("Requests");

        recylerView = (RecyclerView) findViewById ( R.id.listCart );
        recylerView.setHasFixedSize ( true );
        LayoutManager = new LinearLayoutManager ( this );
        recylerView.setLayoutManager ( LayoutManager );

        txtTotalPrice=(TextView)findViewById ( R.id.total );
        btnPlace=(Button)findViewById ( R.id.btnPlaceOrder );
        
        loadListFood();

    }

public void loadListFood() {
        cart=new Database ( this ).getCarts ();
        adapter=new CartAdapter (cart,this );
        recylerView.setAdapter ( adapter );

        //calculating total price

        int total=0;
        for(Order order:cart){
            total += (Integer.parseInt ( order.getPrice () ))*(Integer.parseInt ( order.getQuantity () ));

            Locale locale=new Locale ( "en","US" );
            NumberFormat fmt= NumberFormat.getCurrencyInstance (locale);

            txtTotalPrice.setText ( fmt.format ( total ) );
        }

    }
}






