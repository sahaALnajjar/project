package com.example.android.myproject.phrasesAnimals;

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
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class animalCategoryFragmentOne extends AppCompatActivity {

    private ListView listViewAnimal;

    private ArrayList<the_words_class> arrayListAnimal;

    private ArrayAdapter<the_words_class> arrayAdapter3;

    // use this edit text for the filter.
    // private EditText animalfilter;
    private MaterialSearchBar animalfilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // make sure you change the list name when you copy and paste it will case null and crushing the app !! great job so far me @


        // to be used in the filter.
        // make sure you change (R.id.animalsearch); when you copy and paste .
        animalfilter = (MaterialSearchBar) findViewById(R.id.main_search);

        listViewAnimal = (ListView) findViewById(R.id.main_listView);

        arrayListAnimal = new ArrayList<>();


        //  when adding the raw file for the audio make changes here

        arrayListAnimal.add(new the_words_class("You're barking up the wrong tree", "انت تلوم الشخص الخطأ / تضيع جهودك بالبحث في الطريق الخطأ", "You're blaming the wrong person", "If you think I had anything to do with the scandal you're barking " +
                "\n" + " up the wrong tree.Don't waste your time.", R.raw.yourebarkingupthewrongtree, R.raw.yourebarkingupthewrongtreeexample, R.raw.yourebarkingupthewrongtreemeaning));


        arrayListAnimal.add(new the_words_class("You can't teach an old dog new tricks"
                , "من الصعب جعل شخص ما يغير طريقته في فعل الأشياء بعد ماعتاد على فعلها بطريقة معينة لفتره طويلة"
                , "It is difficult to make someone change the way they do something when they have been doing it the same way for a long time."
                , "Person 1 : Don't waste your time trying to teach your grandfather how to program! " +
                "Person2: why ?" +
                "Person1: Because he's 85 and you cant teach an old dog new tricks"
                , R.raw.youcantteachanolddognewtricks, R.raw.youcantteachanolddognewtricksexample, R.raw.youcantteachanolddognewtricksmeaning));


        arrayListAnimal.add(new the_words_class("When pings fly"
                , "عبارة تقال للشيء الذي يستحيل حدوثه"
                , "A phrase meaning : it will never happen"
                , "Person 1 : Tomorrow I will ask for a raise." + "\n\n"
                + "Person 2 : Yeah , and maybe pigs will fly", R.raw.whenpigsfly, R.raw.whenpigsflyexample, R.raw.whenpigsflymeaning));

        arrayListAnimal.add(new the_words_class("Top dog"
                , "أهم أو أقوى شخص في المجموعة"
                , "The most important or powerful person in a group"
                , "When you become top dog . No more waiting in line.You'll be first for everything"
                , R.raw.topdog, R.raw.topdogexample, R.raw.topdogmeaning));


        arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListAnimal);


        listViewAnimal.setAdapter(arrayAdapter3);


        listViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                the_words_class tem = arrayListAnimal.get(position);
                //  also make sure to add it here .
                String theWordAnimal = tem.getThe_word_text();
                String arabicWordAnimal = tem.getThe_word_in_arabic();
                String englishwordAnimal = tem.getThe_text_in_english();
                String exampleEnglishAnimal = tem.getThe_example_english();
                int audioAnimal = tem.getmAudioId();
                int exampleAudio = tem.getExampleAudio();
                int englishAudio = tem.getEnglishAudio();

                // will use this to send the data to the MistakesHolder.
                Bundle bundleFamily = new Bundle();
                bundleFamily.putString("theWordAnimal", theWordAnimal);
                bundleFamily.putString("arabicWordAnimal", arabicWordAnimal);
                bundleFamily.putString("englishwordAnimal", englishwordAnimal);
                bundleFamily.putString("exampleEnglishAnimal", exampleEnglishAnimal);
                bundleFamily.putInt("audioAnimal", audioAnimal);
                bundleFamily.putInt("ExampleAudio", exampleAudio);
                bundleFamily.putInt("EnglishAudio", englishAudio);

                // send the bundles using intnent , use put extras .

                Intent intentFamily = new Intent(animalCategoryFragmentOne.this, animalHolder.class);
                intentFamily.putExtras(bundleFamily);
                startActivity(intentFamily);

//                String complete = theWord + "\n" + arabicWord +"\n" + englishword +"\n" + exampleEnglish ;
//                Toast.makeText(MistakesActivity.this ,complete ,Toast.LENGTH_LONG).show();

            }
        });


        // add text changer listener ,the filter process take place here :
        animalfilter.setHint("Search");
        animalfilter.setCardViewElevation(10);
        animalfilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (animalCategoryFragmentOne.this).arrayAdapter3.getFilter().filter(s);

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


}// end of class describing_people

