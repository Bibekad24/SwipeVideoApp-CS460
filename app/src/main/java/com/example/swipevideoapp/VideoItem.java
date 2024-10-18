package com.example.swipevideoapp;

import java.util.UUID;

/**
 * Represents a video item with a unique ID, URL, title, and description.
 */
public class VideoItem {

    public String videoID;        // Unique video ID
    public String videoURL;       // URL of the video
    public String videoTitle;     // Title of the video
    public String videoDescription; // Description of the video

    /**
     * Default constructor for VideoItem.
     * Automatically generates a unique video ID.
     */
    public VideoItem() {
        this.videoID = UUID.randomUUID().toString();  // Automatically generate a unique ID
    }

    /**
     * Parameterized constructor for VideoItem.
     * Automatically generates a unique video ID.
     *
     * @param videoURL The URL of the video.
     * @param videoTitle The title of the video.
     * @param videoDescription The description of the video.
     */
    public VideoItem(String videoURL, String videoTitle, String videoDescription) {
        this.videoID = UUID.randomUUID().toString();  // Automatically generate a unique ID
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
    }

    /**
     * Gets the unique video ID.
     *
     * @return The unique video ID.
     */
    public String getVideoID() {
        return videoID;
    }

    /**
     * Gets the URL of the video.
     *
     * @return The video URL.
     */
    public String getVideoURL() {
        return videoURL;
    }

    /**
     * Sets the URL of the video.
     *
     * @param videoURL The video URL.
     */
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    /**
     * Gets the title of the video.
     *
     * @return The video title.
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * Sets the title of the video.
     *
     * @param videoTitle The video title.
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    /**
     * Gets the description of the video.
     *
     * @return The video description.
     */
    public String getVideoDescription() {
        return videoDescription;
    }

    /**
     * Sets the description of the video.
     *
     * @param videoDescription The video description.
     */
    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }
}
