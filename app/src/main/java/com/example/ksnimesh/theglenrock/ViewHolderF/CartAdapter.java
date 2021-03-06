package com.example.ksnimesh.theglenrock.ViewHolderF;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.ksnimesh.theglenrock.FoodOrder.FoodCommon;
import com.example.ksnimesh.theglenrock.Model.Order;
import com.example.ksnimesh.theglenrock.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
   View.OnCreateContextMenuListener{

    public TextView txt_cart_name,txt_price;
    public ImageView img_cart_count;

    private AdapterView.OnItemClickListener onItemClickListener;

    public void setTxt_cart_names(TextView txt_cart_names) {
        this.txt_cart_name = txt_cart_names;
    }
 
    public CartViewHolder(@NonNull View itemView) {
        super( itemView );

        txt_cart_name=(TextView)itemView.findViewById ( R.id.cart_item_name );
        txt_price=(TextView)itemView.findViewById ( R.id.cart_item_price );
        img_cart_count=(ImageView)itemView.findViewById ( R.id.cart_item_count );

        itemView.setOnCreateContextMenuListener( this );
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onCreateContextMenu(ContextMenu contextMenu ,View v ,ContextMenu.ContextMenuInfo contextMenuInfo) {
      contextMenu.setHeaderTitle("Select action" );
       contextMenu.add( 0,0,getAdapterPosition(),FoodCommon.DELETE );
    }
}


public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{
    private List<Order> listData= new ArrayList <>( );
    private Context context;

    public CartAdapter(List <Order> listData ,Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup ,int i) {
      LayoutInflater inflater =LayoutInflater.from( context );
      View itemView =inflater.inflate( R.layout.cart_layout,viewGroup,false );
      return new CartViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder viewHolder ,int i) {
        TextDrawable drawable=TextDrawable.builder()
                .buildRound( ""+listData.get( i ).getDiscount(),Color.RED );
        viewHolder.img_cart_count.setImageDrawable( drawable );

            Locale locale= new Locale( "en","US" );
            NumberFormat fmt =NumberFormat.getCurrencyInstance(locale);
            int price=(Integer.parseInt ( listData.get ( i ).getPrice () ))*(Integer.parseInt ( listData.get ( i ).getDiscount () ));
            viewHolder.txt_price.setText( listData.get( i ).getPrice() );
            viewHolder.txt_cart_name.setText( listData.get( i ).getProductName() );



    }

    @Override
    public int getItemCount() {
        return listData.size();

    }
}

//    private List<Order> listData= new ArrayList <>( );
//
//
//    private Context context;
//
//    public CartAdapter(List <Order> listData , Context context) {
//        this.listData = listData;
//        this.context = context;
//    }
//
//
//
//    @NonNull
//    @Override
//    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
//      LayoutInflater inflater=LayoutInflater.from( context );
//      View itemView = inflater.inflate( R.layout.cart_layout , parent ,false );
//        return new CartViewHolder( itemView );
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartViewHolder holder , int position) {
//
//        TextDrawable drawable = TextDrawable.builder ().
//                buildRound ( ""+listData.get(position).getQuantity (), Color.RED );
//        holder.img_cart_count.setImageDrawable ( drawable );
//
//        Locale locale=new Locale ( "en","US" );
//        NumberFormat fmt= NumberFormat.getCurrencyInstance (locale);
//        int price=(Integer.parseInt ( listData.get ( position ).getPrice () ))*(Integer.parseInt ( listData.get ( position ).getQuantity () ));
//        holder.txt_price.setText (fmt.format (price  ));
//        holder.txt_cart_name.setText (listData.get ( position ).getProductName ());
//        holder.txt_price.setText (listData.get ( position ).getPrice ());
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return listData.size();
//    }
//}
