package com.example.foodhub.Activity.DbHandler;

import android.content.Context;

public class RestaurantDb {

    String name;
    int imageId;
    String rating ;
    String number;

    public RestaurantDb(String name, int imageId, String rating, String number, Context context) {
        this.name = name;
        this.imageId = imageId;
        this.rating = rating;
        this.number = number;
        this.context = context;
    }

    Context context;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
