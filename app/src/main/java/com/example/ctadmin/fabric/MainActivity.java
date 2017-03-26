package com.example.ctadmin.fabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "ZA4g4l6Jyx1KgKybh5IopkE6u";
    private static final String TWITTER_SECRET = "cdTq2VPeyBodOKoA8V94wcEUwHm4DNZm4CS7Nj3k1qe25pxFGL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
        setContentView(R.layout.activity_main);
        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
                Button gotoButton = (Button) findViewById(R.id.gotoButton);


                gotoButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent gotoIntent = new Intent(MainActivity.this, Details.class);
                        startActivity(gotoIntent);
                    }
                });
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });
        /*Button gotoButton = (Button) findViewById(R.id.gotoButton);


        gotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(MainActivity.this, Details.class);
                startActivity(gotoIntent);
            }
        }); */

    }
}
