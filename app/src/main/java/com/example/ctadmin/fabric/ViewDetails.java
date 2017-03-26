package com.example.ctadmin.fabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by ctadmin on 20-03-2017.
 */

public class ViewDetails extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewhomes);
        Button gotoButton = (Button) findViewById(R.id.donateButton1);
        gotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent gotoIntent = new Intent(ViewDetails.this, ConfirmDonation.class);
                gotoIntent.putExtra("mystring", "Christ Faith Home for Children");
                startActivity(gotoIntent);
            }
        });

        Button gotoButton1 = (Button) findViewById(R.id.donateButton2);
        gotoButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent gotoIntent = new Intent(ViewDetails.this, ConfirmDonation.class);
                gotoIntent.putExtra("mystring", "Nethaji Mercy Home");
                startActivity(gotoIntent);
            }
        });

    }
}
