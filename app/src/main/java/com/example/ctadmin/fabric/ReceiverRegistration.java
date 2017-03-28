package com.example.ctadmin.fabric;

/**
 * Created by ctadmin on 28-03-2017.
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

public class ReceiverRegistration extends Activity  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver_registration);
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
    public void sendMessage1(View view) {
        Hashtable<String, String> params = new Hashtable<String, String>();
        String result = null;



        String to1 = "foodstork2017@gmail.com";
        params.put("to1", to1);


        EditText sampleEmailEditText = (EditText) findViewById(R.id.emailView1);
        String from = sampleEmailEditText.getText().toString();
        params.put("from", from);

        String subject = "New Charity Home Registration " ;
        params.put("subject", subject);

        EditText samplenameEditText = (EditText) findViewById(R.id.personEditText1);
        String namec = samplenameEditText.getText().toString();
        EditText sampleaddEditText = (EditText) findViewById(R.id.addressView1);
        String addc = sampleaddEditText.getText().toString();
        EditText samplenumEditText = (EditText) findViewById(R.id.contactView1);
        String num = samplenumEditText.getText().toString();
        EditText samplenumpplEditText = (EditText) findViewById(R.id.numpplView1);
        String numppl = samplenumpplEditText.getText().toString();



        String text ="New Registration for Charity Home:    Name of Charity Home=" + namec+
                "Address= "+addc+
                "   Contact No=" +num+
                "   Email-id=" +from+ "   No. of People Accomodated=" + numppl+ "";
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
        Toast.makeText(this, "Registration Successful! You will receive mail confirmation after your Charity Home has been added",
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Receiver.class);

        startActivity(intent);
    }
}
