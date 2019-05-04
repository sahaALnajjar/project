package com.example.android.myproject.favorite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.R;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {


    private ListView listViewFavorite;

    private ArrayList<the_words_class> arrayListFavorite;

    private ArrayAdapter<the_words_class> arrayAdapterFavorite;

    private TextView favorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        favorite = (TextView) findViewById(R.id.test_gone);
//
//        listViewFavorite = (ListView) findViewById(R.id.FavoriteList);
//
//        arrayListFavorite = new ArrayList<the_words_class>();
//
//        // receive the Bundles from MistakesActivity
//        Bundle bundle = getIntent().getExtras();
//
//
//        //  getting an error here
//        String theWord = bundle.getString("BundleFavorite");
//        favorite.setText(theWord);
//
//        arrayListFavorite.add(new the_words_class((String) favorite.getText()));
//
//        //     when adding the raw file for the audio make changes here
//        //    arrayListFavorite.add(new the_words_class ( "Red","احمر" ,"the color red" , "apple's color" ,R.raw.color_red));
//
//
//        arrayAdapterFavorite = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListFavorite);
//
//        listViewFavorite.setAdapter(arrayAdapterFavorite);


    } //  end of onCreate


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

} //  end of FavoriteActivity

