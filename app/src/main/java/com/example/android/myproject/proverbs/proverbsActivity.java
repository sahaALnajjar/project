package com.example.android.myproject.proverbs;

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

import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class proverbsActivity extends AppCompatActivity {

    private ListView listView2;
    private ArrayList<the_words_class> arrayList;
    private ArrayAdapter<the_words_class> arrayAdapter;

    // use this edit text for the filter.
    // private EditText MistakesFilter;
    private MaterialSearchBar proverbsFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // to be used in the filter.
        proverbsFilter = (MaterialSearchBar) findViewById(R.id.main_search);


        listView2 = (ListView) findViewById(R.id.main_listView);
        arrayList = new ArrayList<>();

        //  when adding the raw file for the audio make changes here

        arrayList.add(new the_words_class("Appearances can be deceiving"
                , "المظاهر خداعة",
                "Things can look different from the way they really are"
                , "Person 1: Those shoes look amazing on you! Person 2: Well , appearances can be deceiving! They hurt so bad! "
                , R.raw.appearances, R.raw.appearancesexample, R.raw.appearancesmeaning));


        arrayList.add(new the_words_class("Great minds think alike",
                "الأذكياء تتوارد لهم نفس الأفكار",
                "Very intelligent people tend to come up with the same ideas at the same time."
                , "Really? I had the same idea just now! Great minds think alike "
                , R.raw.greatminds, R.raw.greatmindsexample, R.raw.greatmindsmeaning));


        arrayList.add(new the_words_class("old habits die hard",
                "العادات القديمة لاتموت بسهولة", "People find it difficult to change their accustomed behavior"
                , "Even though she retired last year, she's still waking up at 6am every day. Old habits die hard."
                , R.raw.oldhabits, R.raw.oldhabitsexample, R.raw.oldhabitsmeaning));


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
                Intent intent = new Intent(proverbsActivity.this, proverbsHolder.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }); // end of  setOnItemClickListener


        // add text changer listener ,the filter process take place here :


        proverbsFilter.setHint("Search");
        proverbsFilter.setCardViewElevation(10);
        proverbsFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (proverbsActivity.this).arrayAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


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


}// end of class colorCategoryFragmentOne

