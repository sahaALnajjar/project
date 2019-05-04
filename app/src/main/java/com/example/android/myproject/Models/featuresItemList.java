package com.example.android.myproject.Models;

/**
 * Created by Msi1 on 12/31/2018.
 */


public class featuresItemList {
    // using these variables you can add a an image and text for the recyclerview
    // each item will contain text and image then you can handle the onclicklistener
    private static final int NO_IMAGE_PROVIDED = -1;
    // private int ImageResource;
    private String ImageText;
    private int ImageResource = NO_IMAGE_PROVIDED;

    // create the constructor for this class " featuresItemList "
    // this constructor is what i will be using to add the list features item
    public featuresItemList(int mimageResource, String mimageText) {

        ImageResource = mimageResource;
        ImageText = mimageText;
    }

    // this constructor is made to add the text only the list
    public featuresItemList(String mimageText) {

        ImageText = mimageText;
    }

    // return whether or not there is an image for this word
    public boolean hasImage() {
        return ImageResource != NO_IMAGE_PROVIDED;
    }

    // getter for the image resource so i can add it using drawable
    public int getImageResource() {
        return ImageResource;
    }

    // so i can add the name of the feature manually
    public String getImageText() {
        return ImageText;
    }

}
