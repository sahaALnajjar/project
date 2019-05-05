package com.example.android.myproject.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.android.myproject.R;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    ListView videoListView;
    ArrayList<String> arrayVideoList;
    ArrayAdapter videoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_layout);

        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoView = findViewById(R.id.myVideoView);
        videoListView = findViewById(R.id.VideoListView);

        arrayVideoList = new ArrayList<>();
        arrayVideoList.add("Lesson one");
        arrayVideoList.add("Lesson two");
        arrayVideoList.add("Lesson three");
        arrayVideoList.add("Lesson four");
        arrayVideoList.add("Lesson five");


        videoAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayVideoList);

        videoListView.setAdapter(videoAdapter);


        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {


                switch (position) {
                    case 0:

                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_one));

//                        DisplayMetrics metrics = new DisplayMetrics();
//                        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//                        android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) videoView.getLayoutParams();
//                        params.width = metrics.widthPixels;
//                        params.height = metrics.heightPixels;
//                        params.leftMargin = 0;
//                        videoView.setLayoutParams(params);

                        // setting the video view to visible to display the requested video
                        videoView.setVisibility(View.VISIBLE);
                        // and after completion the video view is set back to gone so the view will diaper
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                videoView.setVisibility(View.GONE);
                            }
                        });
                        break;

                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_two));
                        // setting the video view to visible to display the requested video
                        videoView.setVisibility(View.VISIBLE);
                        // and after completion the video view is set back to gone so the view will diaper
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                videoView.setVisibility(View.GONE);
                            }
                        });
                        break;

                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_three));
                        // setting the video view to visible to display the requested video
                        videoView.setVisibility(View.VISIBLE);
                        // and after completion the video view is set back to gone so the view will diaper
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                videoView.setVisibility(View.GONE);
                            }
                        });
                        break;

                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_four));
                        // setting the video view to visible to display the requested video
                        videoView.setVisibility(View.VISIBLE);
                        // and after completion the video view is set back to gone so the view will diaper
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                videoView.setVisibility(View.GONE);
                            }
                        });
                        break;

                    case 4:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video5));
                        // setting the video view to visible to display the requested video
                        videoView.setVisibility(View.VISIBLE);
                        // and after completion the video view is set back to gone so the view will diaper
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                videoView.setVisibility(View.GONE);
                            }
                        });
                        break;

                }


                //  to show stop   , forward and backward on the video view itself
                MediaController mediaController = new MediaController(VideoActivity.this);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.requestFocus();
                videoView.start();


            }
        });


    } // end of onCreate


    // this code allows the and setup the up navigation from activity to the fragment i came from

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } // end of onOptionsItemSelected


} // end of videoActivity




