package com.example.ctadmin.fabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ctadmin on 19-03-2017.
 */

public class Details extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_main);
        ImageButton gotoButton = (ImageButton) findViewById(R.id.donorbutton);


        gotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(Details.this, Donor.class);
                startActivity(gotoIntent);
            }
        });
        ImageButton gotoButton1 = (ImageButton) findViewById(R.id.receiverbutton);


        gotoButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(Details.this, Receiver.class);
                startActivity(gotoIntent);
            }
        });

    }
}
