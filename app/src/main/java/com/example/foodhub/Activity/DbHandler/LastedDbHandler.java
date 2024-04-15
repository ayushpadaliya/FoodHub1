package com.example.foodhub.Activity.DbHandler;

import android.content.Context;

public class LastedDbHandler {

int image;
String name;
Context context;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LastedDbHandler(int image, String name, Context context) {
        this.image = image;
        this.name = name;
        this.context = context;
    }
}
