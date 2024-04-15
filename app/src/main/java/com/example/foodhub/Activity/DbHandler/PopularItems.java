package com.example.foodhub.Activity.DbHandler;

import android.content.Context;

public class PopularItems {


    String name;
    int imageId;
    String rating ;
    String number;
    String price;

    String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PopularItems(String name, int imageId, String rating, String number, String price, String desc, Context context) {
        this.name = name;
        this.imageId = imageId;
        this.rating = rating;
        this.number = number;
        this.price = price;
        this.desc = desc;
        this.context = context;
    }

    Context context;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
