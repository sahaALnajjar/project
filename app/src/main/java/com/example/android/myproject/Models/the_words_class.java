package com.example.android.myproject.Models;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Msi1 on 1/6/2019.
 */


// this class ( custom object ) will help me add the features to the listview
// so i will create image variable and text variable and use this class to add them to the main activity

// important read it :

// everything here will be used to fill the recyclerview later .


public class the_words_class {
    // using these variables you can add the text for the listview layout you made it
    // each item will contain text  then you can handle the onclicklistener
    private String the_word_text;
    private String the_word_in_arabic;
    private String the_text_in_english;
    private String the_example_english;
    // this for the audio raw files .
    private int mAudioId;
    // this for example english audio
    private int ExampleAudio;
    // this for text English audio
    private int EnglishAudio;



    //  this contractor will be used to add audio for the word , the example and the text in english
    public the_words_class(String the_word_text, String the_word_in_arabic, String the_text_in_english,
                           String the_example_english, int mAudioId, int exampleAudio, int englishAudio) {
        this.the_word_text = the_word_text;
        this.the_word_in_arabic = the_word_in_arabic;
        this.the_text_in_english = the_text_in_english;
        this.the_example_english = the_example_english;
        this.mAudioId = mAudioId;
        ExampleAudio = exampleAudio;
        EnglishAudio = englishAudio;
    }

    public the_words_class(String the_word_text) {
        this.the_word_text = the_word_text;
    }

    public the_words_class(String the_word_text, String the_word_in_arabic, String the_text_in_english, String the_example_english) {
        this.the_word_text = the_word_text;
        this.the_word_in_arabic = the_word_in_arabic;
        this.the_text_in_english = the_text_in_english;
        this.the_example_english = the_example_english;
    }

    public the_words_class(String the_word_text, String the_word_in_arabic, String the_text_in_english,
                           String the_example_english, int mAudioId) {
        this.the_word_text = the_word_text;
        this.the_word_in_arabic = the_word_in_arabic;
        this.the_text_in_english = the_text_in_english;
        this.the_example_english = the_example_english;
        this.mAudioId = mAudioId;
    }


    public String getThe_word_text() {
        return the_word_text;
    }

    public void setThe_word_text(String the_word_text) {
        this.the_word_text = the_word_text;
    }

    public String getThe_word_in_arabic() {
        return the_word_in_arabic;
    }

    public void setThe_word_in_arabic(String the_word_in_arabic) {
        this.the_word_in_arabic = the_word_in_arabic;
    }

    public String getThe_text_in_english() {
        return the_text_in_english;
    }

    public void setThe_text_in_english(String the_text_in_english) {
        this.the_text_in_english = the_text_in_english;
    }

    public String getThe_example_english() {
        return the_example_english;
    }

    public void setThe_example_english(String the_example_english) {
        this.the_example_english = the_example_english;
    }

    public int getmAudioId() {
        return mAudioId;
    }

    public void setmAudioId(int mAudioId) {
        this.mAudioId = mAudioId;
    }

    public int getExampleAudio() {
        return ExampleAudio;
    }

    public void setExampleAudio(int exampleAudio) {
        ExampleAudio = exampleAudio;
    }

    public int getEnglishAudio() {
        return EnglishAudio;
    }

    public void setEnglishAudio(int englishAudio) {
        EnglishAudio = englishAudio;
    }

    // this method will display only the word in the list .
    @Override
    public String toString() {
        return the_word_text;
    }


}
