package com.example.ksnimesh.theglenrock;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.FoodOrder.FoodCommon;
import com.example.ksnimesh.theglenrock.Model.Category;
import com.example.ksnimesh.theglenrock.Model.Order;
import com.example.ksnimesh.theglenrock.ViewHolderF.FoodViewHolder;
import com.example.ksnimesh.theglenrock.ViewHolderF.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.jar.Attributes;

public class FoodnavHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseDatabase database;
    DatabaseReference category;

    TextView textRoomno;
    RecyclerView recyler_menu;
    RecyclerView.LayoutManager LayoutManager;
    FirebaseRecyclerAdapter<Category,MenuViewHolder> adapter;

   
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_foodnav_home );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        toolbar.setTitle( "Menu" );
        setSupportActionBar( toolbar );

        //Init firebase

        database=FirebaseDatabase.getInstance();
        category=database.getReference("Category");




        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
//                        .setAction( "Action", null ).show();

                Intent cartIntent =new Intent ( FoodnavHome.this,Cart.class );
                startActivity ( cartIntent );

            }
        } );

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );



        // Set name for user
        View headerView =navigationView.getHeaderView( 0 );
        textRoomno=(TextView)headerView.findViewById( R.id.textroomno );
        textRoomno.setText( FoodCommon.currentUser.getRoom_NO() );

        //load menu

        recyler_menu=(RecyclerView)findViewById( R.id.recycler_menu );
        recyler_menu.setHasFixedSize( true );
        LayoutManager=new LinearLayoutManager( this );
        recyler_menu.setLayoutManager( LayoutManager );

        loadMenu();



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadMenu() {

       adapter =new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.menu_item,MenuViewHolder.class,category) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Category model, int position) {
                viewHolder.txtMenuName.setText( model.getName() );
                Picasso.with( getBaseContext() ).load( model.getImage()).into( viewHolder.photoView);
                     final Category clickItem=model;
                    viewHolder.setItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //  Toast.makeText (FoodnavHome.this,""+clickItem.getName(),Toast.LENGTH_SHORT).show();
                            //get category and send new activity;
                            Intent foodList =new Intent( FoodnavHome.this,Foodlist.class );

                            foodList.putExtra("CategoryId",adapter.getRef( position ).getKey());
                            startActivity( foodList );



                        }
                    } );
//            @Override
//            protected void populateViewHolder(MenuViewHolder viewHolder, Locale.Category model, int position) {
               // viewHolder.txtMenuName.setText( model.getName() );
               // Picasso.with( getBaseContext() ).load( model.getImage()).into( RecyclerView.ViewHolder.imageView );
            }
        };
            recyler_menu.setAdapter( adapter );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.foodnav_home, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Menu) {
            // Handle the camera action
        } else if (id == R.id.nav_Cart) {
            Intent CartIntent=new Intent( FoodnavHome.this,Cart.class );
            startActivity( CartIntent );

        } else if (id == R.id.nav_Orders) {

            Intent OderIntent=new Intent( FoodnavHome.this,OrderStatus.class );
            startActivity( OderIntent );

        } else if (id == R.id.nav_Logout) {
            Intent signIn=new Intent( FoodnavHome.this,Sign_In.class );
            startActivity( signIn );

        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
