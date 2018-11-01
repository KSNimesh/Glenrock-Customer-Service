package com.example.ksnimesh.theglenrock.ViewHolderF;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ksnimesh.theglenrock.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MenuViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtMenuName;
    public ImageView photoView;

    private AdapterView.OnItemClickListener itemClickListener;

    public MenuViewHolder(@NonNull View itemView) {
        super( itemView );

        txtMenuName=(TextView)itemView.findViewById( R.id.menu_name);
        photoView=(ImageView)itemView.findViewById( R.id.menu_image );

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