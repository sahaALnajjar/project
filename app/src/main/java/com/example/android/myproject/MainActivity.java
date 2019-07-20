package com.example.android.myproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.myproject.Models.myViewPagerAdapter;
import com.example.android.myproject.homePage.FragmentOne;
import com.example.android.myproject.homePage.FragmentThree;
import com.example.android.myproject.homePage.FragmentTwo;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // //Set the content of the activity to use the activity_main.xml layout file
        // Find the view pager that will allow the user to swipe between fragments
        // you can fine id.MyViewPager in activity main.xml under viewPager View

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);

            viewPager.setPageTransformer(true , new DepthPageTransformer());
            viewPager.setPageTransformer(true , new ZoomOutPageTransformer());
        }
        // Create an adapter that knows which fragment should be shown on each page
        //  myViewPagerAdapter adapter = new myViewPagerAdapter(getSupportFragmentManager());
        //  add the icon to the tap layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.myTaps);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_engine);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_menu_button_of_three_horizontal_lines);


    } // end of onCreate method

    //  this method will add my fragments to the viewPager so i can see them on the screen
    private void setupViewPager(ViewPager viewPager) {
        myViewPagerAdapter adapter = new myViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne());
        adapter.addFragment(new FragmentTwo());
        adapter.addFragment(new FragmentThree());
//  the more you add the more taps you have but you need to create the class and xml file for the new fragments .
        viewPager.setAdapter(adapter);
    }
}// end of main


