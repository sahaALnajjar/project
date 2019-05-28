package com.example.android.myproject.email;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.myproject.R;

public class EmailActivity extends AppCompatActivity {

    // in case the app crashes  add this activity to the manifest file .

    // take object from the edit text you made they are 3  ! in activity_email.xml
    private EditText mEmailAddressText;
    private EditText mEmailSubjectText;
    private EditText mEmailMessageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

// this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // initialization of the edit text so i can use them to retrieve the information
        mEmailAddressText = findViewById(R.id.text_email_address);
        mEmailSubjectText = findViewById(R.id.email_subject);
        mEmailMessageText = findViewById(R.id.editTextMessage);

        Button startBtn = (Button) findViewById(R.id.send_email_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    } // end of on create


// this code allows the and setup the up navigation from activity to the fragment i came from

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void sendEmail() {

        String theSenderEmail = mEmailAddressText.getText().toString();
        String subject = mEmailSubjectText.getText().toString();
        String theMessage = mEmailMessageText.getText().toString();
        String[] to = {"shadow8evil@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to); // recipient email addresses
        emailIntent.putExtra(Intent.EXTRA_CC, theSenderEmail); // not sure about this one
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);// working as expected
        emailIntent.putExtra(Intent.EXTRA_TEXT, theMessage);// working as expected

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "mail sent ");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(EmailActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


}// end of Email activity








