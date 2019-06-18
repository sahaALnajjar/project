package com.example.android.myproject.expressingMistakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.myproject.R;
import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.detailsHolder;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class MistakesActivity extends AppCompatActivity {

    private ListView listView2;
    private ArrayList<the_words_class> arrayList;
    private ArrayAdapter<the_words_class> arrayAdapter;

    // use this edit text for the filter.
    //  private EditText MistakesFilter;
    private MaterialSearchBar MistakesFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // to be used in the filter.
        MistakesFilter = (MaterialSearchBar) findViewById(R.id.main_search);


        listView2 = (ListView) findViewById(R.id.main_listView);
        arrayList = new ArrayList<>();
        //  when adding the raw file for the audio make changes here

        arrayList.add(new the_words_class("To be out of line",
                "سلوك غير لائق او تصرف غير مناسب",
                "To display inappropriate or improper behavior",
                "what you said was out of line! I demand an apology",
                R.raw.tobeoutofline, R.raw.tobeoutoflineexample, R.raw.tobeoutoflinemeaning));


        arrayList.add(new the_words_class("Dud", "شي غير فعال ، مخيب للآمال ، وهمي"
                , "something that is disappointingly ineffective",
                "I had to return the new light bulb because it was a dud",
                R.raw.dud, R.raw.dudexample, R.raw.dudmeaning));


        arrayList.add(new the_words_class("to draw a blank",
                "الفشل في تذكر شيء ما", "To fail to remember something",
                "I'm drawing a blank right now...can you ask me about it later?",
                R.raw.drawablank, R.raw.drawablankexample, R.raw.drawablankmeaning));


        arrayList.add(new the_words_class("Fall from grace", "فقدان الاحترام أو الهيبة",
                "Loss of status , respect or prestige",
                "The politician fell from grace when the scandal leaked",
                R.raw.fallfromgrace, R.raw.fallfromgraceexample, R.raw.fallfromgracemeaning));


        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView2.setAdapter(arrayAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                the_words_class tem = arrayList.get(position);
                //  also make sure to add it here .
                // add the data from the list to the String and send the String using bundle .
                String theWord = tem.getThe_word_text();
                String arabicWord = tem.getThe_word_in_arabic();
                String englishword = tem.getThe_text_in_english();
                String exampleEnglish = tem.getThe_example_english();
                int audio = tem.getmAudioId();
                int exampleAudio = tem.getExampleAudio();
                int englishAudio = tem.getEnglishAudio();

                // will use this to send the data to the MistakesHolder.
                Bundle bundle = new Bundle();
                bundle.putString("TheWord", theWord);
                bundle.putString("TheWordArabic", arabicWord);
                bundle.putString("TheWordEnglish", englishword);
                bundle.putString("theExample", exampleEnglish);
                bundle.putInt("voice", audio);
                bundle.putInt("ExampleAudio", exampleAudio);
                bundle.putInt("EnglishAudio", englishAudio);

                // send the bundles using intnent , use put extras .
                Intent intent = new Intent(MistakesActivity.this, detailsHolder.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }); // end of  setOnItemClickListener


        //  add text changer listener ,the filter process take place here :

        // giving the Search some features "

        MistakesFilter.setHint("Search");
        MistakesFilter.setCardViewElevation(10);
        MistakesFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (MistakesActivity.this).arrayAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        MistakesFilter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // reference the context of this page
//                (MistakesActivity.this).arrayAdapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


    }// end of on create

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


    public void searchNow(View view) {


        // add text changer listener ,the filter process take place here :

//        MistakesFilter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // reference the context of this page
//                (MistakesActivity.this).arrayAdapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


    }
}// end of class colorCategoryFragmentOne


