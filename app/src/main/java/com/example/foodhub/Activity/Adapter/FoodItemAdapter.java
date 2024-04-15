package com.example.foodhub.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.view_item>{

    LayoutInflater layoutInflater;

    @NonNull
    @Override
    public view_item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.fooditem,parent,false);
        return new view_item(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_item holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class view_item extends RecyclerView.ViewHolder {
        public view_item(@NonNull View itemView) {
            super(itemView);
        }
    }
}
