package com.example.android.myproject.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.myproject.Models.featuresItemList;
import com.example.android.myproject.R;

import java.util.ArrayList;

/**
 * Created by Msi1 on 1/4/2019.
 */


public class myListAdapter extends ArrayAdapter<featuresItemList> {
    public myListAdapter(Context context, ArrayList<featuresItemList> featuresList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, featuresList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.features_list_layout, parent, false);
        }
        // Get the {@link WordAdapter} object located at this position in the list
        featuresItemList currentItems = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView avatarText = (TextView) listItemView.findViewById(R.id.avatar_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        avatarText.setText(currentItems.getImageText());
        // avatarText.setGravity(Gravity.CENTER);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.avatar_picture);
        iconView.setImageResource(currentItems.getImageResource());

        if (currentItems.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentItems.getImageResource());

            // make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the imageView
            iconView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}












