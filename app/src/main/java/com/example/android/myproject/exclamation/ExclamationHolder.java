package com.example.android.myproject.exclamation;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myproject.Models.SharedPrefs;
import com.example.android.myproject.R;

public class ExclamationHolder extends AppCompatActivity {


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


    //  start of onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_main_holder);

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

        final String theWord = bundle.getString("TheWord");
        String arabicWord = bundle.getString("TheWordArabic");
        String TheWordEnglish = bundle.getString("TheWordEnglish");
        String exampleEnglish = bundle.getString("theExample");
        final int audio = bundle.getInt("voice");
        final int exampleAudio = bundle.getInt("ExampleAudio");
        final int englishAudio = bundle.getInt("EnglishAudio");

        // now set the data you received to the textviews you have made .
        the_word_textView.setText(theWord);
        text_in_arabic.setText(arabicWord);
        text_in_english.setText(TheWordEnglish);
        example_in_english.setText(exampleEnglish);

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
                    mediaPlayer = MediaPlayer.create(ExclamationHolder.this, audio);
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
                    mediaPlayer = MediaPlayer.create(ExclamationHolder.this, exampleAudio);

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
                    mediaPlayer = MediaPlayer.create(ExclamationHolder.this, englishAudio);

                    // Start the audio file
                    mediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        //    fix me yo !
        // this code is going to help me check and uncheck just like the function of the like button on facebook
        // anyway i need to find a way to save this change once i leave this page .

//        SharedPrefs prefs = new SharedPrefs(MistakesHolder.this);
//        prefs.getBookingInfo();

        bookmark.setOnClickListener(new View.OnClickListener() {
            private boolean bookmarking = true;

            public void onClick(View v) {
                SharedPrefs prefs = new SharedPrefs(ExclamationHolder.this);
                if (bookmarking) {
                    bookmark.setImageResource(R.drawable.ic_bookmarked_blue);
                    bookmarking = false;
                } else {
                    bookmarking = true;
                    bookmark.setImageResource(R.drawable.ic_bookmark);

                    //   prefs.getBookingInfo();
                }
                prefs.saveBookingInfo(String.valueOf(bookmarking), String.valueOf(bookmark));


            }

        });

        // this code is going to help me check and uncheck just like the function of the like button on facebook
        // anyway i need to find a way to save this change once i leave this page .
        //  find a way to get shared preference works here .
        //try to add the text of the word to a string variable and sent it through a bundle to
        //  the favorite activity then try to add it to the array list you have .

        addToFavorite.setOnClickListener(new View.OnClickListener() {
            private boolean fun = true;

            public void onClick(View v) {
                if (fun) {
                    addToFavorite.setImageResource(R.drawable.ic_added_favorite);

                    Toast.makeText(getApplicationContext(), "added to favorite", Toast.LENGTH_LONG).show();

                    fun = false;
                } else {
                    fun = true;
                    addToFavorite.setImageResource(R.drawable.ic_addto_favorite);
                    Toast.makeText(getApplicationContext(), "removed from favorite", Toast.LENGTH_LONG).show();
                }
            }
        });


        //  fine a way to get the part above works as planned .
    } //  end of oncreate

    //  this code allows the and setup the up navigation from activity to the fragment i came from
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
}//  end of Colors holer
