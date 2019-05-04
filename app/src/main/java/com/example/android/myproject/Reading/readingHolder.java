package com.example.android.myproject.Reading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.myproject.R;

public class readingHolder extends AppCompatActivity {

    private TextView the_story_name;
    private TextView the_story_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_grammar_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        the_story_name = (TextView) findViewById(R.id.the_nameHere);
        the_story_body = (TextView) findViewById(R.id.the_TextHere);


        // receive the Bundles from MistakesActivity
        Bundle bundle = getIntent().getExtras();


        String theStoryName = bundle.getString("theStoryName");
        String theStoryText = bundle.getString("theStoryText");


        // now set the data you received to the textviews you have made .
        the_story_name.setText(theStoryName);
        the_story_body.setText(theStoryText);


    }// end of onCreate


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


}
