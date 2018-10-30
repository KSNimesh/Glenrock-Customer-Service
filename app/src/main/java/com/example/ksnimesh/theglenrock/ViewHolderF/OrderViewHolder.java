package com.example.ksnimesh.theglenrock.ViewHolderF;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.ksnimesh.theglenrock.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txt_OrderId;
    public TextView txt_OrdeeStatus;
    public TextView txt_OrderPackage;
    public TextView txt_OrderAdress;

    private AdapterView.OnItemClickListener itemClickListener;




     public OrderViewHolder(@NonNull View itemView) {
        super( itemView );
         txt_OrderId= (TextView)itemView.findViewById( R.id.order_id );
         txt_OrderAdress= (TextView)itemView.findViewById( R.id.order_address );
         txt_OrdeeStatus= (TextView)itemView.findViewById( R.id.order_status );
         txt_OrderPackage= (TextView)itemView.findViewById( R.id.order_package );

         itemView.setOnClickListener( this );


    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onItemClick(null, view, getAdapterPosition(), view.getId());

    }
}
