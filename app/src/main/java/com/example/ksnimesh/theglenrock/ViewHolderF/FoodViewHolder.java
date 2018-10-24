package com.example.ksnimesh.theglenrock.ViewHolderF;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ksnimesh.theglenrock.R;

public class         FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public static ImageView imageView;
    public TextView food_name;
    public ImageView food_image;

    private AdapterView.OnItemClickListener itemClickListener;

    public FoodViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener itemClickListener) {
        super( itemView );
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(@NonNull View itemView) {
        super( itemView );


        food_name=(TextView)itemView.findViewById( R.id.food_name);
        food_image=(ImageView)itemView.findViewById( R.id.food_image );

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onItemClick(null, view, getAdapterPosition(), view.getId());


    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
