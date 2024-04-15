package com.example.foodhub.Activity.DbHandler;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class HomeDB {
    Context context;
    private List<Message> messages;


    public HomeDB(Context context) {
        this.context = context;
        this.messages=new ArrayList<>();
    }

    private List<Message> message;


    public List<Message> getMessage() {
        return messages;
    }


    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public void addMessage(String product, int images) {
        Message message = new Message();
        message.setProduct(product);
        message.setImages(images);
        messages.add(message);
    }
    public class Message {

        String product;
        int images;
        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public int getImages() {
            return images;
        }

        public void setImages(int images) {
            this.images = images;
        }

    }
}
