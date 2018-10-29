package com.example.ksnimesh.theglenrock.Tabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ksnimesh.theglenrock.R;


public class Tab2 extends Fragment {


public Tab2(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tab2=inflater.inflate( R.layout.fragment_tab2 ,container,false);

        return tab2;
    }

    public interface OnFragmentInteractionListener {
    }
}
