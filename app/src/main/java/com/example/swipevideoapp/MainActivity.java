package com.example.swipevideoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity class that displays a list of videos in a ViewPager2.
 * The activity initializes a list of video items and binds them to a ViewPager2 adapter.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization should go.
     * The method sets up the ViewPager2 and populates it with video items.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the ViewPager2 that displays the videos
        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        // List to hold video items
        List<VideoItem> videoItemsList = new ArrayList<>();

        // Adding videos to the list using the parameterized constructor of VideoItem
        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-dbfa7.appspot.com/o/855029-hd_1920_1080_30fps%20(1).mp4?alt=media&token=fcd6901a-4e70-4de4-97c2-56e6a4322256",
                "Cat Playing",
                "Cat loves to play a lot."
        ));

        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-dbfa7.appspot.com/o/bird_small_animal_feathers_river_679.mp4?alt=media&token=511a7512-5b56-4e58-b857-d672e8abbdaa",
                "Bird in Nature",
                "Bird drinking water near river."
        ));

        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-dbfa7.appspot.com/o/butterfly_flower_insect_nature_515.mp4?alt=media&token=d231ba79-55f1-4e88-a0e6-d3f5cfcb677b",
                "Butterfly",
                "Butterfly in garden."
        ));

        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-dbfa7.appspot.com/o/file_example_MP4_640_3MG.mp4?alt=media&token=cadc377c-f08b-4c58-94a0-63cb6673c15a",
                "Earth - Our Home",
                "The blue planet's rotation."
        ));

        // Setting up the adapter to bind the video items to the ViewPager2
        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}
