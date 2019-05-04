package com.example.android.myproject.Businness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.myproject.DescribingPeople.DescribingPeople;
import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.R;
import com.example.android.myproject.expressingMistakes.MistakesActivity;
import com.example.android.myproject.expressingMistakes.MistakesHolder;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class Business extends AppCompatActivity {


    private ListView listView2;
    private ArrayList<the_words_class> arrayList;
    private ArrayAdapter<the_words_class> arrayAdapter;

    // use this edit text for the filter.
    // private EditText MistakesFilter;
    private MaterialSearchBar BusinessFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // to be used in the filter.
        BusinessFilter = (MaterialSearchBar) findViewById(R.id.main_search);


        listView2 = (ListView) findViewById(R.id.main_listView);
        arrayList = new ArrayList<>();

        // when adding the raw file for the audio make changes here

        arrayList.add(new the_words_class("A dime a dozen",
                "صفة للتعبير عن شيء متوفر بكثرة ورخيص جدا ( ليس نادر )",
                "So plentiful as to be nearly worthless/ extremely cheap ",
                "Great looks and awful personality ? People like him are a dime a dozen",
                R.raw.adimeadozen, R.raw.adimeadozenexample, R.raw.adimeadozenmeaning));


        arrayList.add(new the_words_class("Beg , borrow or steal",
                "استخدام جميع الحيل اللازمة للحصول على شيء ما",
                "To do whatever is necessary to get something",
                "I don't care if you have to beg , borrow , or steal to get it, I want that car now! "
                , R.raw.begborroworsteal, R.raw.begborroworstealexample, R.raw.begborroworstealmeaning));


        arrayList.add(new the_words_class("Cold , hard cash",
                "الأوراق النقدية ( ليس الشيك ولا بطاقة ائتمان )",
                "Cash , not checks or credit",
                "Sorry, we don't take cards. Just cold, hard cash"
                , R.raw.coldhardcash, R.raw.coldhardcashexample, R.raw.coldhardcashmeaning));


        arrayList.add(new the_words_class("Chip in",
                "المساهمة في شيء ما بالمال أو الرأي ، دفع جزء من التكاليف ( جمعية مثلا )"
                , "Contribute something ( money , advice,etc) pay for part of something along with others."
                , "We're planning an office party and need everyone to chip in."
                , R.raw.chipin, R.raw.chipinexample, R.raw.chipinmeaning));


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
                Intent intent = new Intent(Business.this, BusinessHolder.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }); // end of  setOnItemClickListener


        // add text changer listener ,the filter process take place here :

        // giving the Search some features "

        BusinessFilter.setHint("Search");
        BusinessFilter.setCardViewElevation(10);
        BusinessFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (Business.this).arrayAdapter.getFilter().filter(s);

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


