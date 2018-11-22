package com.example.ksnimesh.theglenrock;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

//public class Social_Media extends AppCompatActivity {
//  Button fb,insta,tripadvisor;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_social__media );





        public class GooglePlusDash extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener{
            private GoogleApiClient googleApiClient;
            SignInButton btnSignIn;
            @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.google_plus_dash);

                btnSignIn=(SignInButton)findViewById(R.id.btnSignIn);


                btnSignIn.setOnClickListener(this);


                GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
                googleApiClient=new GoogleApiClient.Builder(this)
                        .enableAutoManage(this,this)
                        .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                        .build();
                btnSignIn.setSize(SignInButton.SIZE_STANDARD);
                btnSignIn.setScopes(gso.getScopeArray());
            }
            private void signIn(){
                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if(requestCode==RC_SIGN_IN){
                    GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                    handleSignResult(result);
                }
            }
            private void handleSignResult(GoogleSignInResult result){
                Log.v("@@@WWe",TAG+" "+result.isSuccess());
                if(result.isSuccess()){
                    GoogleSignInAccount account=result.getSignInAccount();
                    Log.v("@@@WWe",TAG+ "Name : "+account.getDisplayName());
                    String name = account.getDisplayName();
                    String email = account.getEmail();
                    String image=account.getPhotoUrl().toString();

                    Glide.with(GooglePlusDash.this).load(image).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(ivProfilePic);
                    updateUi(true);
                }
            }
            @Override
            public void onClick(View view) {
                int id = view.getId();

                switch (id) {
                    case R.id.btnSignIn:
                        signIn();
                        break;
                }
            }
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Log.v("@@@WWE",TAG+" Connection Failed  "+connectionResult);
            }
        }


    }
}
