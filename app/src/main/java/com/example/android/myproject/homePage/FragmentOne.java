package com.example.android.myproject.homePage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.myproject.Abbreviations.AbbreviationsCategoryFragmentOne;
import com.example.android.myproject.AboutFood.AboutFoodCategoryFragmentOne;
import com.example.android.myproject.Businness.Business;
import com.example.android.myproject.DescribingPeople.DescribingPeople;
import com.example.android.myproject.Exclamation.ExclamationCategoryFragmentOne;
import com.example.android.myproject.PhrasesAnimals.animalCategoryFragmentOne;
import com.example.android.myproject.R;
import com.example.android.myproject.expressingMistakes.MistakesActivity;
import com.example.android.myproject.Models.featuresItemList;
import com.example.android.myproject.Models.myListAdapter;
import com.example.android.myproject.proverbs.proverbsActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentOne extends Fragment {

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        final ArrayList<featuresItemList> fragmentOne = new ArrayList<featuresItemList>();


        fragmentOne.add(new featuresItemList(R.drawable.ic_mistake, "Expressing mistakes"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_people2, "Describing people"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_animal, "Phrases involving animals "));
        fragmentOne.add(new featuresItemList(R.drawable.ic_business, "Business"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_exclamation, "Exclamation"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_abbreviation, "Abbreviations"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_proverb, "Proverbs"));
        fragmentOne.add(new featuresItemList(R.drawable.ic_food, "phrases about  food"));
        //fragmentOne.add(new featuresItemList("test category"));


        myListAdapter myAdapter = new myListAdapter(getContext(), fragmentOne);

        ListView listView = (ListView) view.findViewById(R.id.fragmentOneCategoryList);
        listView.setAdapter(myAdapter);
        // setp 2
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                featuresItemList list = fragmentOne.get(i);
                if (i == 0) {
                    Intent color = new Intent(view.getContext(), MistakesActivity.class);
                    startActivity(color);
                }
                if (i == 1) {
                    Intent family = new Intent(view.getContext(), DescribingPeople.class);
                    startActivity(family);
                }
                if (i == 2) {
                    Intent animal = new Intent(view.getContext(), animalCategoryFragmentOne.class);
                    startActivity(animal);
                }
                if (i == 3) {
                    Intent school = new Intent(view.getContext(), Business.class);
                    startActivity(school);
                }
                if (i == 4) {
                    Intent exclamation = new Intent(view.getContext(), ExclamationCategoryFragmentOne.class);
                    startActivity(exclamation);
                }
                if (i == 5) {
                    Intent abbreviations = new Intent(view.getContext(), AbbreviationsCategoryFragmentOne.class);
                    startActivity(abbreviations);
                }
                if (i == 6) {
                    Intent house = new Intent(view.getContext(), proverbsActivity.class);
                    startActivity(house);
                }
                if (i == 7) {
                    Intent AboutFood = new Intent(view.getContext(), AboutFoodCategoryFragmentOne.class);
                    startActivity(AboutFood);
                }


            }
        });


        // end of setp 2

        return view;

    }
}











