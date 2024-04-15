package com.example.foodhub.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.view_review> {

    LayoutInflater layoutInflater;


    @NonNull
    @Override
    public view_review onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.reviewlayout,parent,false);
        return new view_review(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_review holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class view_review  extends RecyclerView.ViewHolder {
        public view_review(@NonNull View itemView) {
            super(itemView);
        }
    }
}
