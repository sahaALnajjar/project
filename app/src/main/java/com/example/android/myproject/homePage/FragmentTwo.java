package com.example.android.myproject.homePage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.myproject.Models.featuresItemList;
import com.example.android.myproject.Models.myListAdapter;
import com.example.android.myproject.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    private MaterialSearchBar FragmentTwoFilter;


    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_fragment_two, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);

// to be used in the filter.
        FragmentTwoFilter = (MaterialSearchBar) view.findViewById(R.id.fragmentTwoSearch);


        final ArrayList<featuresItemList> fragmentTwo = new ArrayList<featuresItemList>();


        myListAdapter myAdapter = new myListAdapter(getContext(), fragmentTwo);

        ListView listView = (ListView) view.findViewById(R.id.fragmentTwolist);
        listView.setAdapter(myAdapter);

        // giving the Search some features "

        FragmentTwoFilter.setHint("Search");
        FragmentTwoFilter.setCardViewElevation(10);
        FragmentTwoFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                //  (FragmentTwo.this).FragmentTwoFilter.

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;

    }


}
