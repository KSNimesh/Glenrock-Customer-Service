package com.example.ksnimesh.theglenrock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
                    viewHolder.txt_OrdeeStatus.setText( convertCodeToStatus(model.getStatus()));
                    viewHolder.txt_OrderAdress.setText( model.getAddress() );
                    viewHolder.txt_OrderPackage.setText( model.getCustomer_Name() );


            }
        };
        recyclerView.setAdapter( adapter );
    }

    private String convertCodeToStatus(String status) {
        if(status.equals( "0" )){
          return  "Placed";
        }
        else if(status.equals( "1" )) {
            return "On my way";
        }
        else
        {return "Issued Your Order";}
    }
}
