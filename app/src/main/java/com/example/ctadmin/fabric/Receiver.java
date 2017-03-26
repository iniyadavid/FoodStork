package com.example.ctadmin.fabric;
import android.content.Context;
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
        final Context context = getApplicationContext();
        ImageButton button = (ImageButton) findViewById(R.id.registerbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendEmail(context, new String[]{"foodstork2017@gmail.com"}, "New Registration for Home",
                        "New Registration for Home","Dear Home,                                       " + "      Please enter details and attach a photo.                 " +


                                "                                       *Name of Charity Home:                       " +
                                "*Address:                                                       " +
                                "*Contact No:                       " +
                                "                                      *No. of people accomodated:        " +"           We thereby confirm that we would like to register our Charity home to FoodStork."
                );
            }
        });
        ImageButton button1 = (ImageButton) findViewById(R.id.viewbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendEmail(context, new String[]{"foodstork2017@gmail.com"}, "Send Goodwill",
                        "Send GoodWill","Please send Gratitude Greetings to our latest donor."
                );
            }
        });


    }
    public static void sendEmail(Context context, String[] recipientList,
                                 String title, String subject, String body) {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipientList);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(emailIntent, title));
    }
}
