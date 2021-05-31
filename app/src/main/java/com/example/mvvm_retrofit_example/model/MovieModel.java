package com.example.mvvm_retrofit_example.model;

import com.google.gson.annotations.SerializedName;

public class MovieModel {
    private String title;
    private String price;
    @SerializedName("image")
    private String imageUrl;

    public MovieModel(String title, String price, String imageUrl) {
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
