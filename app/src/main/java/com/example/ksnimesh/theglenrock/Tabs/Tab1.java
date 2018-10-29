package com.example.ksnimesh.theglenrock.Tabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksnimesh.theglenrock.FeedBack;
import com.example.ksnimesh.theglenrock.Mygallery;
import com.example.ksnimesh.theglenrock.R;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.support.constraint.Constraints.TAG;

public class Tab1 extends Fragment {

//    public Tab1(){};
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View tab1=inflater.inflate( R.layout.fragment_tab1 ,container,false);
//
//        return tab1;
//    }
//
//    public interface OnFragmentInteractionListener {
//    }


//    private Activity activity;
//    private int contentView;
//
//    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate( R.layout.fragment_tab1 ,container ,false );
//
//
//        final EditText your_name = (EditText) view.findViewById( R.id.your_name );
//        final EditText your_email = (EditText) view.findViewById( R.id.your_email );
//        final EditText your_subject = (EditText) view.findViewById( R.id.your_subject );
//        final EditText your_message = (EditText) view.findViewById( R.id.your_message );
//
//
//        Button email = (Button) view.findViewById( R.id.post_message );
//        email.setOnClickListener( new View.OnClickListener( ) {
//            @Override
//            public void onClick(View v) {
//
//                String name = your_name.getText( ).toString( );
//                String email = your_email.getText( ).toString( );
//                String subject = your_subject.getText( ).toString( );
//                String message = your_message.getText( ).toString( );
//                if (TextUtils.isEmpty( name )) {
//                    your_name.setError( "Enter Your Name" );
//                    your_name.requestFocus( );
//                    return;
//                }
//
//                Boolean onError = false;
//                if (!isValidEmail( email )) {
//                    onError = true;
//                    your_email.setError( "Invalid Email" );
//                    return;
//                }
//
//                if (TextUtils.isEmpty( subject )) {
//                    your_subject.setError( "Enter Your Subject" );
//                    your_subject.requestFocus( );
//                    return;
//                }
//
//                if (TextUtils.isEmpty( message )) {
//                    your_message.setError( "Enter Your Feedback" );
//                    your_message.requestFocus( );
//                    return;
//                }
//
//                Intent sendEmail = new Intent( android.content.Intent.ACTION_SEND );
//
//                /* Fill it with Data */
//                sendEmail.setType( "plain/text" );
//                sendEmail.putExtra( android.content.Intent.EXTRA_EMAIL ,new String[]{"glenrockhotel@gmail.com"} );
//                sendEmail.putExtra( android.content.Intent.EXTRA_SUBJECT ,subject );
//                sendEmail.putExtra( android.content.Intent.EXTRA_TEXT ,
//                        "name:" + name + '\n' + "Email ID:" + email + '\n' + "Message:" + '\n' + message );
//
//                /* Send it off to the Activity-Chooser */
//                startActivity( Intent.createChooser( sendEmail ,"Send mail..." ) );
//
//
//            }
//        } );
//
//        return view;
//    }
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        //Get a Tracker (should auto-report)
//
//
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//    }
//
//
//    // validating email id
//
//    private boolean isValidEmail(String email) {
//        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//
//    public void setContentView(int contentView) {
//        this.contentView = contentView;
//    }
//
//    public interface OnFragmentInteractionListener {
//    }



    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container ,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_tab1 ,container ,false );

//Ratinf Smiles //////////////////////////

        SmileRating smileRating = (SmileRating)view.findViewById(R.id.smile_rating);

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley,boolean reselected) {
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText( getActivity(),"BAD", Toast.LENGTH_SHORT ).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getActivity(),"Good", Toast.LENGTH_SHORT ).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText( getActivity(),"Great", Toast.LENGTH_SHORT ).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText( getActivity(),"Okay", Toast.LENGTH_SHORT ).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getActivity(),"TERRIBLE", Toast.LENGTH_SHORT ).show();
                        break;
                }
            }
        });


        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                Toast.makeText( getActivity()," Selected rating", Toast.LENGTH_SHORT ).show();


            }
        });


//////////////////feedback button

        Button about_hotel = (Button) view.findViewById( R.id.feedbackz );
        about_hotel.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openfeedback( );
            }
        } );





        return view;
    }



    public void openfeedback() {
        Intent intent = new Intent( getActivity(),FeedBack.class);
        startActivity( intent );
    }

    public interface OnFragmentInteractionListener {
    }
}