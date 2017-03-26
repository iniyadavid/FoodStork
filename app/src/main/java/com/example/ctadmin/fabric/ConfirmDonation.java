package com.example.ctadmin.fabric;

/**
 * Created by ctadmin on 25-03-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;
import android.os.AsyncTask;
import com.github.sendgrid.SendGrid;
import android.widget.Toast;

public class ConfirmDonation extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_donation);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Send an email with SendGrid's Web API, using our SendGrid Java Library
    // https://github.com/sendgrid/sendgrid-java
    private class SendEmailWithSendGrid extends AsyncTask<Hashtable<String, String>, Void, String> {

        @Override
        protected String doInBackground(Hashtable<String, String>... params) {
            Hashtable<String, String> h = params[0];
            Utils creds = new Utils();
            SendGrid sendgrid = new SendGrid(creds.getUsername(), creds.getPassword());
            sendgrid.addTo(h.get("to"));
            sendgrid.addTo(h.get("to1"));
            sendgrid.setFrom(h.get("from"));
            sendgrid.setSubject(h.get("subject"));
            sendgrid.setText(h.get("text"));
            String response = sendgrid.send();
            return response;
        }
    }

    // Called when the user clicks the Send button
    @SuppressWarnings("unchecked")
    public void sendMessage(View view) {
        Hashtable<String, String> params = new Hashtable<String, String>();
        String result = null;

        EditText sampleEmailEditText = (EditText) findViewById(R.id.emailView);
        String to = sampleEmailEditText.getText().toString();

        String to1 = "foodstork2017@gmail.com";
        params.put("to", to);
        params.put("to1", to1);


        String from = "foodstork2017@gmail.com";
        params.put("from", from);
        Intent callingIntent = getIntent();
        String str = callingIntent.getStringExtra("mystring");
        String subject = "Donation Confirmation for " + str + ".";
        params.put("subject", subject);

        EditText samplenumEditText = (EditText) findViewById(R.id.cView);
        String num = samplenumEditText.getText().toString();

        String text = "Dear Donor, Thankyou for your kind act on behalf of FoodStork. We will contact you at " + num + " for Donation Delivery soon. ";
        params.put("text", text);

        // Send the Email
        SendEmailWithSendGrid email = new SendEmailWithSendGrid();
        try {
            result = email.execute(params).get();
        } catch (InterruptedException e) {
            // TODO Implement exception handling
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Implement exception handling
            e.printStackTrace();
        }

        // Display the result of the email send
        Toast.makeText(this, "Donation Successful! You will receive mail confirmation",
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Details.class);

        startActivity(intent);
    }

}
