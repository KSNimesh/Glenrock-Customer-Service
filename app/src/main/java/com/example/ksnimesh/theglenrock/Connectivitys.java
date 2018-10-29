package com.example.ksnimesh.theglenrock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;

import com.example.ksnimesh.theglenrock.Tabs.Tab1;
import com.example.ksnimesh.theglenrock.Tabs.Tab2;
import com.example.ksnimesh.theglenrock.Tabs.Tab3;

import java.util.ArrayList;
import java.util.List;


public class Connectivitys extends AppCompatActivity {

    TabLayout Mytab;
    ViewPager Mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_connectivitys );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbartab );
        setSupportActionBar( toolbar );


        Mytab=(TabLayout) findViewById( R.id.MyTabs );

        Mypage=(ViewPager)findViewById( R.id.Mypages );

        Mytab.setupWithViewPager( Mypage );

        SetupViewpager( Mypage );

    }

    public void SetupViewpager (ViewPager viewPager){
        MyViewpageAdapter Adapter=new MyViewpageAdapter( getSupportFragmentManager() );

        Adapter.AddFragmentpage(new Tab1(), "Feedback" );
        Adapter.AddFragmentpage(new Tab2(), "Social Media" );
        Adapter.AddFragmentpage(new Tab3(), "Others" );

        viewPager.setAdapter( Adapter );

    }


    public class MyViewpageAdapter extends FragmentPagerAdapter{

        private  List<Fragment>MyFragment = new ArrayList <>(  );
        private List<String>MypageTitle= new ArrayList <>(  );

        public  MyViewpageAdapter(FragmentManager manager){
            super(manager);
            }

            public void AddFragmentpage(Fragment frag,String Title){

            MyFragment.add( frag );
            MypageTitle.add( Title );
            }

        @Override
        public Fragment getItem(int i){
            return MyFragment.get( i );
        }


        @Override
        public CharSequence getPageTitle(int i) {
            return MypageTitle.get( i );
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
