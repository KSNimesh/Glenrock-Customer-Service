package com.example.ksnimesh.theglenrock;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.example.ksnimesh.theglenrock.Tabs.Tab1;
import com.example.ksnimesh.theglenrock.Tabs.Tab2;
import com.example.ksnimesh.theglenrock.Tabs.Tab3;
import com.example.ksnimesh.theglenrock.Tabs.TabPageAdapter;
import com.example.ksnimesh.theglenrock.Tabs.pagerAdapter;

//public class Connectivity extends AppCompatActivity{
//   private ViewPager myViewpager;
//  private TabPageAdapter tabPageAdapter;
//  private TabLayout myTab;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_connectivity );
//
//
//        myViewpager=(ViewPager)findViewById( R.id.Main_tab_page );
//        tabPageAdapter=new TabPageAdapter( getSupportFragmentManager() );
//        myViewpager.setAdapter( tabPageAdapter );
//        myTab=(TabLayout)findViewById( R.id.Main_tabs );
//        myTab.setupWithViewPager( myViewpager );
//    }
//
//}

//
public class Connectivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,
        Tab2 .OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity);
        setTitle( "Connectivity" );

        TabLayout tabLayout=(TabLayout)findViewById( R.id.tablayout );
        tabLayout.addTab( tabLayout.newTab().setText("Feedback") );
        tabLayout.addTab( tabLayout.newTab().setText("Social Medias") );
        tabLayout.addTab( tabLayout.newTab().setText("Others") );
        tabLayout.setTabGravity( TabLayout.GRAVITY_FILL );

        final ViewPager viewPager=(ViewPager)findViewById( R.id.pager );
        final pagerAdapter adapter=new pagerAdapter( getSupportFragmentManager(),tabLayout.getTabCount() );
        viewPager.setAdapter( (adapter) );
        viewPager.setOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout) );

        tabLayout.setOnTabSelectedListener( new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );

    }


}
