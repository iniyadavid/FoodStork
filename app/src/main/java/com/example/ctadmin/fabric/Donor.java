package com.example.ctadmin.fabric;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ctadmin on 19-03-2017.
 */

public class Donor extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.donorpage);
        ImageButton gotoButton = (ImageButton) findViewById(R.id.registerbutton);


        gotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(Donor.this,DonorRegistration.class);
                startActivity(gotoIntent);
            }
        });
        ImageButton gotoButton1 = (ImageButton) findViewById(R.id.viewbutton);


        gotoButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(Donor.this,ViewDetails.class);
                startActivity(gotoIntent);
            }
        });

    }
}
