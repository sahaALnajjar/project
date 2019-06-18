package com.example.android.myproject.describingPeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.R;
import com.example.android.myproject.detailsHolder;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class DescribingPeople extends AppCompatActivity {


    private ListView listViewFamily;

    private ArrayList<the_words_class> arrayListFamily;

    private ArrayAdapter<the_words_class> arrayAdapter2;

    // use this edit text for the filter.
    // private EditText familyfilter;

    private MaterialSearchBar familyfilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);
        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // to be used in the filter.
        familyfilter = (MaterialSearchBar) findViewById(R.id.main_search);

        // make sure you change the list name when you copy and paste it will case null and crushing the app !! great job so far me @

        listViewFamily = (ListView) findViewById(R.id.main_listView);

        arrayListFamily = new ArrayList<>();


        //  when adding the raw file for the audio make changes here
        arrayListFamily.add(new the_words_class("Airhead",
                "شخص غبي ، غير مسؤول (يعني راسه فاضي )",
                "A stupid or irresponsible person ", "I wouldn't give that much responsibility to him. He acts like an airhead. "
                , R.raw.airhead, R.raw.airheadexample, R.raw.airheadmeaning));


        arrayListFamily.add(new the_words_class("Catfishing",
                "انتحال شخصية، أن يتظاهر أنه شخص آخر على مواقع التواصل الاجتماعي ( غالبا ليجذب الطرف الآخر إلى علاقة رومنسية)",
                "Pretending to be someone else on social media (often in order to lure someone into a relationship",
                "My friend got catfished - the cool guy she met online turned out to be her grandfather",
                R.raw.catfishing, R.raw.catfishingexample, R.raw.catfishingmeaning));


        arrayListFamily.add(new the_words_class("Goofball",
                "شخص مضحك ، غريب بشكل مضحك ، سخيف ( ليست إهانة )",
                "A goofy person , a funny or silly person",
                "we loved the class goofball, even if it meant wasting some class time and annoying the teacher.\n He was just so funny to watch",
                R.raw.goofball, R.raw.goofballexample, R.raw.goofballmeaning));


        arrayListFamily.add(new the_words_class("He's full of it",
                "أي مخطيء تماماً، كاذب ، ( يعني واحد ماعنده سالفه )",
                "He's completely wrong, false, or worthless (full of crap)",
                "The employee claims to have given us a fair portion of pizza,but I say he's full of it. Our piece was smaller than anyone else's at the restaurant",
                R.raw.fullofit, R.raw.fullofitexample, R.raw.fullofitmeaning));


        arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                arrayListFamily);

        listViewFamily.setAdapter(arrayAdapter2);


        listViewFamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                the_words_class tem = arrayListFamily.get(position);
                // also make sure to add it here .
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

                Intent intentFamily = new Intent(DescribingPeople.this, detailsHolder.class);
                intentFamily.putExtras(bundle);
                startActivity(intentFamily);

//                String complete = theWord + "\n" + arabicWord +"\n" + englishword +"\n" + exampleEnglish ;
//                Toast.makeText(MistakesActivity.this ,complete ,Toast.LENGTH_LONG).show();


            }
        });


        // giving the Search some features "

        familyfilter.setHint("Search");
        familyfilter.setCardViewElevation(10);
        familyfilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (DescribingPeople.this).arrayAdapter2.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        familyfilter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // reference the context of this page
//                (describingPeople.this).arrayAdapter2.getFilter().filter(s);
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


}// end of class describing_people

