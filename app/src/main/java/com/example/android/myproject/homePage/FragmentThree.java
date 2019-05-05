package com.example.android.myproject.homePage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.myproject.email.EmailActivity;
import com.example.android.myproject.favorite.FavoriteActivity;
import com.example.android.myproject.grammar.grammarActivity;
import com.example.android.myproject.R;
import com.example.android.myproject.reading.readingActivity;
import com.example.android.myproject.spelling.SpellActivity;
import com.example.android.myproject.video.VideoActivity;
import com.example.android.myproject.Models.featuresItemList;
import com.example.android.myproject.Models.myListAdapter;
import com.example.android.myproject.quiz.quizActivity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {


    // private ArrayList<featuresItemList >  featuresitems;


    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);


        final ArrayList<featuresItemList> featuresitems = new ArrayList<featuresItemList>();

        //  featuresitems = new ArrayList<>();

        featuresitems.add(new featuresItemList(R.drawable.ic_email, "Email"));
        featuresitems.add(new featuresItemList(R.drawable.ic_favourite, "Favorite"));
        featuresitems.add(new featuresItemList(R.drawable.ic_video_player, "Tutorial Videos"));
        featuresitems.add(new featuresItemList(R.drawable.ic_pen, "spelling"));
        featuresitems.add(new featuresItemList(R.drawable.ic_test2, "Quiz"));
        featuresitems.add(new featuresItemList(R.drawable.ic_grammar, "grammar"));
        featuresitems.add(new featuresItemList(R.drawable.ic_reading, "reading"));


        myListAdapter myAdapter = new myListAdapter(getContext(), featuresitems);

        ListView listView = (ListView) view.findViewById(R.id.fragmentOneCategoryList);

        listView.setAdapter(myAdapter);

        // setp 2
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Get the {@link Word} object at the given position the user clicked on

                featuresItemList word = featuresitems.get(i);

                if (i == 0) {
                    Intent intentEmail = new Intent(view.getContext(), EmailActivity.class);
                    startActivity(intentEmail);
                }
                if (i == 1) {
                    Intent intentFavorite = new Intent(view.getContext(), FavoriteActivity.class);
                    startActivity(intentFavorite);
                }
                if (i == 2) {
                    Intent intentVideo = new Intent(view.getContext(), VideoActivity.class);
                    startActivity(intentVideo);
                }
                if (i == 3) {
                    Intent intentSpell = new Intent(view.getContext(), SpellActivity.class);
                    startActivity(intentSpell);
                }
                if (i == 4) {
                    Intent intentQuiz = new Intent(view.getContext(), quizActivity.class);
                    startActivity(intentQuiz);
                }
                if (i == 5) {
                    Intent intentGrammar = new Intent(view.getContext(), grammarActivity.class);
                    startActivity(intentGrammar);
                }
                if (i == 6) {
                    Intent intentReading = new Intent(view.getContext(), readingActivity.class);
                    startActivity(intentReading);
                }


            }
        });
        // end of setp 2


        return view;

    }


}

