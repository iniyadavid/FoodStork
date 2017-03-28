package com.example.ctadmin.fabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ctadmin on 19-03-2017.
 */

public class Receiver extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.receiverpage);
        ImageButton gotoButton = (ImageButton) findViewById(R.id.registerbutton1);
        gotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(Receiver.this, ReceiverRegistration.class);
                startActivity(gotoIntent);
            }
        });

      


    }

}
