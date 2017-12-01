package com.intermediatepractice;

/**
 * Created by SYAMSUL on 01/12/2017.
 */

public class MainDao {
    private String title;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MainDao(String title, String imageUrl) {

        this.title = title;
        this.imageUrl = imageUrl;
    }
}
