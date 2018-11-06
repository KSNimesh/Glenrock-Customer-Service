package com.example.ksnimesh.theglenrock;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.ksnimesh.theglenrock.FoodOrder.FoodCommon;
import com.example.ksnimesh.theglenrock.Model.Request;
import com.example.ksnimesh.theglenrock.ViewHolderF.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class OrderStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public  RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request,OrderViewHolder>adapter;

    FirebaseDatabase database;
    DatabaseReference requests;
   // MaterialSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_status );

        database= FirebaseDatabase.getInstance();
        requests=database.getReference("Requests");


        recyclerView = (RecyclerView) findViewById ( R.id.listOrders );
        recyclerView.setHasFixedSize ( true );
        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager ( layoutManager );

//
//        if(getIntent()==null)
//        {  loadOders( FoodCommon.currentUser.getPackage_No());}
//        else {
//
//            loadOders( getIntent().getStringExtra( "PackageNumber" ) );
//        }
//

        //latee code have big codes


        loadOders( FoodCommon.currentUser.getPackage_No());

    }

    private void loadOders(String packageNo) {
        adapter=new FirebaseRecyclerAdapter <Request, OrderViewHolder>(
                Request.class,R.layout.order_layout,OrderViewHolder.class,
                requests.orderByChild( "packageNo" ).equalTo(packageNo  )
        ) {
            @Override
            protected void populateViewHolder(OrderViewHolder viewHolder ,Request model ,int position) {
                    viewHolder.txt_OrderId.setText( adapter.getRef( position ).getKey() );
                    viewHolder.txt_OrdeeStatus.setText( FoodCommon.convertCodeToStatus(model.getStatus()));
                    viewHolder.txt_OrderAdress.setText( model.getAddress() );
                    viewHolder.txt_OrderPackage.setText( model.getCustomer_Name() );


            }
        };
        recyclerView.setAdapter( adapter );
    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        if(item.getTitle().equals( FoodCommon.UPDATE )){
//
//            showUpdateDialoag(adapter.getRef( item.getOrder() ).getKey(),adapter.getItem( item.getOrder() ));
//        }
//
//        else if(item.getTitle().equals( FoodCommon.DELETE )){
//            deleteOrder(adapter.getRef( item.getOrder() ).getKey());
//        }
//
//        return super.onContextItemSelected( item );
//    }
//
//    private void deleteOrder(String key) {
//        requests.child( key ).removeValue();
//    }
//
//    private void showUpdateDialoag(String key ,final Request item) {
//
//        final AlertDialog.Builder alertDialog = new AlertDialog.Builder( OrderStatus.this );
//        alertDialog.setTitle( "Update Order" ) ;
//        alertDialog.setMessage( "Please choose status" );
//
//        LayoutInflater inflater = this.getLayoutInflater();
//        //final View view =inflater.inflate(R.layout.update_order_layout,null);
//
//        //spinner = (MaterialSpinner)view.findViewById( R.id.statusSpinner );
//       // spinner.setItems( "Placed","On My Way","Issued Your Order" );
//      //  alertDialog.setView( view );
//
//        final  String localKey=key;
//        alertDialog.setPositiveButton( "Yes" ,new DialogInterface.OnClickListener( ) {
//            @Override
//            public void onClick(DialogInterface dialog ,int which) {
//                dialog.dismiss();
//              //  item.setStatus( String.valueOf( spinner.getSelectedIndex() ) );
//                requests.child( localKey ).setValue(item  );
//
//
//            }
//        } );
//
//        alertDialog.setNegativeButton( "No" ,new DialogInterface.OnClickListener( ) {
//            @Override
//            public void onClick(DialogInterface dialog ,int which) {
//                dialog.dismiss();
//            }
//        } );
//        alertDialog.show();
//
//    }


}
