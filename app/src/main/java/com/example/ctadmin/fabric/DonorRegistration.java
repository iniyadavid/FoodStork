package com.example.ctadmin.fabric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ctadmin.fabric.data.DonorDetailsContract;
import com.example.ctadmin.fabric.data.DonorDetailsDBHelper;
import static com.example.ctadmin.fabric.data.DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_NAME;
import static com.example.ctadmin.fabric.data.DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_ADDRESS;
import static com.example.ctadmin.fabric.data.DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_CONTACT;
import static com.example.ctadmin.fabric.data.DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_EMAIL;

/**
 * Created by ctadmin on 20-03-2017.
 */

public class DonorRegistration extends AppCompatActivity {
    DonorDetailsDBHelper dbHelper;
    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.donor_registration);
        dbHelper = new DonorDetailsDBHelper(this);
        final Button button = (Button) findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText samplePersonEditTextView = (EditText) findViewById(R.id.personEditText);
                String name = samplePersonEditTextView.getText().toString();
                EditText samplePersonEditTextView1 = (EditText) findViewById(R.id.addressView);
                String address= samplePersonEditTextView1.getText().toString();
                EditText samplePersonEditTextView2 = (EditText) findViewById(R.id.contactView);
                Integer contact= Integer.parseInt(samplePersonEditTextView2.getText().toString());
                EditText samplePersonEditTextView3 = (EditText) findViewById(R.id.emailView);
                String email= samplePersonEditTextView3.getText().toString();

                insertDetails(name,address,contact,email);
                readDetails(name);

                    Intent gotoIntent = new Intent(DonorRegistration.this, Donor.class);
                    startActivity(gotoIntent);

            }
        });



    }
    public void insertDetails(String name, String address, int contact, String email) {
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_DONOR_NAME, name);
            values.put(COLUMN_DONOR_ADDRESS, address);
            values.put(COLUMN_DONOR_CONTACT, contact);
            values.put(COLUMN_DONOR_EMAIL, email);

            db.insert(DonorDetailsContract.DonorDetailsEntry.TABLE_NAME, "null", values);
            Toast.makeText(this, "Registration Successful!",
                    Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT);
            toast.show();


        }

    }
    public void readDetails(String donorname) {
        db = dbHelper.getReadableDatabase();
        String whereClause = COLUMN_DONOR_NAME + " = ?";
        String[] selectionArgs = {donorname};
        String result = "";
        StringBuilder sb = new StringBuilder();
        String[] projection = {
                COLUMN_DONOR_NAME,
                COLUMN_DONOR_ADDRESS,COLUMN_DONOR_CONTACT,COLUMN_DONOR_EMAIL};
        Cursor c = db.query(
                DonorDetailsContract.DonorDetailsEntry.TABLE_NAME,
                projection,
                whereClause,
                selectionArgs,
                null,
                null,
                null);
        c.moveToFirst();
        if (c != null) {
            do {
                for (int i = 0; i < c.getColumnCount(); i++) {
                    result = sb.append(" " + c.getString(i)).toString();
                }
            } while (c.moveToNext());

            Log.v("Result of query ", result);

        }
        c.close();
    }
}
