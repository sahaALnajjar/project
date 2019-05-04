package com.example.android.myproject.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.myproject.Models.featuresItemList;
import com.example.android.myproject.Models.myListAdapter;
import com.example.android.myproject.R;

import java.util.ArrayList;

public class quizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ArrayList<featuresItemList> quizList = new ArrayList<featuresItemList>();


        quizList.add(new featuresItemList(R.drawable.ic_quiz2, "Simple"));
        quizList.add(new featuresItemList(R.drawable.ic_test3, "Beginner"));


        myListAdapter myAdapter = new myListAdapter(this, quizList);

        ListView listView = (ListView) findViewById(R.id.quizList);

        listView.setAdapter(myAdapter);

        // setp 2
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Get the {@link Word} object at the given position the user clicked on

                featuresItemList list = quizList.get(i);


                if (i == 0) {
                    Intent color = new Intent(view.getContext(), SimpleQuizActivity.class);
                    startActivity(color);
                }
                if (i == 1) {
                    Intent family = new Intent(view.getContext(), BeginnerQuizActivity.class);
                    startActivity(family);
                }


            }
        });


    }// end of on create method


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
