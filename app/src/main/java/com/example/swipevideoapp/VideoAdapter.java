package com.example.swipevideoapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter for handling video playback in a RecyclerView.
 * This class binds video data to views in each item of the RecyclerView.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoItem> videoItems;

    /**
     * Constructor for VideoAdapter.
     *
     * @param videoItems List of video items to be displayed.
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    /**
     * Creates a new ViewHolder when there are no existing view holders that can be reused.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new VideoViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false)
        );
    }

    /**
     * Binds the data from a VideoItem to the provided ViewHolder.
     * Stops any previous video playback when binding new data.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        // Stop previous video playback
        if (holder.videoView.isPlaying()) {
            holder.videoView.stopPlayback();
        }
        holder.setVideoData(videoItems.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of video items.
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * ViewHolder class that represents the video item views in the RecyclerView.
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle1, textVideoDescription1, textVideoID1;  // TextView for video title, description, and ID
        VideoView videoView;  // VideoView to display the video
        ProgressBar progressBar;  // ProgressBar to show loading state

        /**
         * Constructor for VideoViewHolder.
         *
         * @param itemView The view for a single item in the RecyclerView.
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
            textVideoID1 = itemView.findViewById(R.id.textVideoID);  // Find the video ID TextView
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        /**
         * Sets the data for the current video item, including title, description, and ID.
         * Prepares the video for playback and adjusts scaling.
         *
         * @param videoItem The VideoItem containing data for the video.
         */
        void setVideoData(VideoItem videoItem) {
            if (videoItem != null && videoItem.videoURL != null) {
                textVideoTitle1.setText(videoItem.videoTitle);
                textVideoDescription1.setText(videoItem.videoDescription);
                textVideoID1.setText("ID: " + videoItem.getVideoID());  // Set the video ID dynamically
                videoView.setVideoPath(videoItem.videoURL);

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressBar.setVisibility(View.GONE);
                        mp.start();

                        // Adjust video scaling based on screen ratio
                        float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                        float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                        float scale = videoRatio / screenRatio;

                        if (scale >= 1f) {
                            videoView.setScaleX(scale);
                        } else {
                            videoView.setScaleY(1f / scale);
                        }
                    }
                });

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.start(); // Loop the video when it finishes
                    }
                });
            } else {
                // Handle null or invalid video data
                textVideoTitle1.setText("No Video");
                textVideoDescription1.setText("No description available");
                textVideoID1.setText("ID: N/A");  // Handle invalid or missing video ID
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}
