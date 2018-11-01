package com.example.ksnimesh.theglenrock;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.Database.Database;
import com.example.ksnimesh.theglenrock.FoodOrder.FoodCommon;
import com.example.ksnimesh.theglenrock.Model.Order;
import com.example.ksnimesh.theglenrock.Model.Request;
import com.example.ksnimesh.theglenrock.ViewHolderF.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity  {

    RecyclerView recylerView;
    RecyclerView.LayoutManager LayoutManager;

    FirebaseDatabase database;
    DatabaseReference requests;

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
        requests=database.getReference ("Requests");

        recylerView = (RecyclerView) findViewById ( R.id.listCart );
        recylerView.setHasFixedSize ( true );
        LayoutManager = new LinearLayoutManager ( this );
        recylerView.setLayoutManager ( LayoutManager );

        txtTotalPrice=(TextView)findViewById ( R.id.total );
        btnPlace=(Button)findViewById ( R.id.btnPlaceOrder );

        btnPlace.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                if(cart.size()>0)
                    showAlertDialog();
                else
                    Toast.makeText( Cart.this,"Your cart Is empty..!!",Toast.LENGTH_SHORT ).show();


            }
        } );
        
        loadListFood();

    }

    private void showAlertDialog() {

        AlertDialog.Builder alertDiaglog = new AlertDialog.Builder( Cart.this );
        alertDiaglog.setTitle( "One More Step..!" );
        alertDiaglog.setMessage( "Enter your Name:" );

        final EditText edtAddress =new EditText( Cart.this );

         LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
        );

         edtAddress.setLayoutParams( lp );
         alertDiaglog.setView( edtAddress );
         alertDiaglog.setIcon( R.drawable.ic_shopping_cart_black_24dp );

         alertDiaglog.setPositiveButton( "Yes" ,new DialogInterface.OnClickListener(){

             @Override
             public void onClick(DialogInterface dialogInterface, int i){

                  Request request =new Request(
                    FoodCommon.currentUser.getPackage_No(),
                    FoodCommon.currentUser.getRoom_NO(),
                          edtAddress.getText().toString(),
                    txtTotalPrice.getText().toString(),
                    cart


                  );
                  //submitting firebase to that

                  requests.child( String.valueOf( System.currentTimeMillis() ) ).setValue( request );
                  new Database( getBaseContext() ).cleanCart();
                 Toast.makeText( Cart.this,"Thank your ,Order Placed.." ,Toast.LENGTH_SHORT).show();
                 finish();

             }
                 } );

         alertDiaglog.setNegativeButton( "No" ,new DialogInterface.OnClickListener( ) {
             @Override
             public void onClick(DialogInterface dialog ,int which) {
                 dialog.dismiss();
             }
         } );

         alertDiaglog.show();

    }

    public void loadListFood() {
        cart=new Database ( this ).getCarts ();
        adapter=new CartAdapter (cart,this );
        adapter.notifyDataSetChanged();
        recylerView.setAdapter ( adapter );

        //calculating total price

        int total=0;
        for(Order order:cart){
            total += (Integer.parseInt ( order.getPrice () ))*(Integer.parseInt ( order.getDiscount () ));

            Locale locale=new Locale ( "en","US" );
            NumberFormat fmt= NumberFormat.getCurrencyInstance (locale);

            txtTotalPrice.setText ( fmt.format ( total ) );
        }

    }
//adding delete orders
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle().equals( FoodCommon.DELETE ))
            deleteCart(item.getOrder());
        return true;
    }

    private void deleteCart(int position) {

        cart.remove( position );
        new Database( this ).cleanCart();

        for(Order item:cart)
            new Database( this ).addToCart( item );

        loadListFood();





    }
}






