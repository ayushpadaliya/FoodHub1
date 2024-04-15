package com.example.foodhub.Activity.DbHandler;

import android.content.Context;

public class SideBarDB {
    String name;
    int imageId;

    public SideBarDB(Context context,String name,int imageId) {
        this.context = context;
        this.name=name;
        this.imageId=imageId;
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
}
