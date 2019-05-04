package com.example.android.myproject.DescribingPeople;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myproject.Models.the_words_class;
import com.example.android.myproject.R;
import com.example.android.myproject.expressingMistakes.MistakesHolder;

public class PeopleHolder extends AppCompatActivity {


    private TextView the_word_textView;
    private TextView text_in_arabic;
    private TextView text_in_english;
    private TextView example_in_english;
    private ImageView bookmark;
    private ImageView addToFavorite;
    private ImageView playSound;
    private ImageView playsoundEnglish;
    private ImageView playsoundExample;


    private MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    // start of onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_main_holder);
        // setContentView(R.layout.people_holder);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        the_word_textView = (TextView) findViewById(R.id.the_word_textview);
        text_in_arabic = (TextView) findViewById(R.id.text_in_arabic);
        text_in_english = (TextView) findViewById(R.id.text_in_english);
        example_in_english = (TextView) findViewById(R.id.example_in_english);

        // the images to be added later .

        bookmark = (ImageView) findViewById(R.id.imageView_bookmark_readIt);
        addToFavorite = (ImageView) findViewById(R.id.imageView_addTofavorite);

        playsoundEnglish = (ImageView) findViewById(R.id.imageView_play_soundEnglish);
        playsoundExample = (ImageView) findViewById(R.id.imageView_play_soundExample);

        playSound = (ImageView) findViewById(R.id.imageView_play_sound);


        // receive the Bundles from MistakesActivity
        Bundle bundle = getIntent().getExtras();


        String theWordfamily = bundle.getString("TheWordFamily");
        String arabicWordfamily = bundle.getString("TheWordArabicFamily");
        String englishwordfamily = bundle.getString("TheWordEnglishFamily");
        String exampleEnglishfamily = bundle.getString("theExampleFamily");
        final int audiofamily = bundle.getInt("voiceFamily");
        final int exampleAudio = bundle.getInt("ExampleAudio");
        final int englishAudio = bundle.getInt("EnglishAudio");

        // now set the data you received to the textviews you have made .
        the_word_textView.setText(theWordfamily);
        text_in_arabic.setText(arabicWordfamily);
        text_in_english.setText(englishwordfamily);
        example_in_english.setText(exampleEnglishfamily);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file

                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(PeopleHolder.this, audiofamily);

                    // Start the audio file
                    mediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


        // the english text should play sound .

        playsoundExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file

                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(PeopleHolder.this, exampleAudio);

                    // Start the audio file
                    mediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        // this for the text in english it should play sound

        playsoundEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(PeopleHolder.this, englishAudio);

                    // Start the audio file
                    mediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


        // this code is going to help me check and uncheck just like the function of the like button on facebook
        // anyway i need to find a way to save this change once i leave this page .
        //  find a way to get shared preference works here .

        bookmark.setOnClickListener(new View.OnClickListener() {
            private boolean fun = true;

            public void onClick(View v) {
                if (fun) {
                    bookmark.setImageResource(R.drawable.ic_bookmarked_blue);
                    fun = false;
                } else {
                    fun = true;
                    bookmark.setImageResource(R.drawable.ic_bookmark);
                    //Toast.makeText(getApplicationContext(), "Changed", Toast.LENGTH_LONG).show();
                }
            }
        });


        // this code is going to help me check and uncheck just like the function of the like button on facebook
        // anyway i need to find a way to save this change once i leave this page .
        //  find a way to get shared preference works here .
        addToFavorite.setOnClickListener(new View.OnClickListener() {
            private boolean fun = true;

            public void onClick(View v) {
                if (fun) {
                    addToFavorite.setImageResource(R.drawable.ic_added_favorite);
                    Toast.makeText(getApplicationContext(), "added to favorite", Toast.LENGTH_LONG).show();
                    fun = false;

//                    //  also make sure to add it here .
//                    String favoriteadding = the_word_textView.getText().toString();
//
//                    // will use this to send the data to the MistakesHolder.
//                    Bundle BundleFavorite = new Bundle();
//                    BundleFavorite.putString( "BundleFavorite",favoriteadding);


                } else {
                    fun = true;
                    addToFavorite.setImageResource(R.drawable.ic_addto_favorite);
                    Toast.makeText(getApplicationContext(), "removed from favorite", Toast.LENGTH_LONG).show();

//                    //  also make sure to add it here .
//                    String favoriteadding = the_word_textView.getText().toString();
//
//                    // will use this to send the data to the MistakesHolder.
//                    Bundle BundleFavorite = new Bundle();
//                    BundleFavorite.putString( "BundleFavorite",favoriteadding);


                }

            }
        });


        //fine a way to get the part above works as planned .


    }// end of onCreate


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


    @Override
    protected void onStop() {
        super.onStop();

        //when activity is stopped , release the media player resourse because we wont
        //be playing any more sound
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            // Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}// end of Colors holer