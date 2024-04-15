package com.example.foodhub.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.view_upcoming> {
    LayoutInflater layoutInflater;


    @NonNull
    @Override
    public view_upcoming onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.upcoming,parent,false);
        return new UpcomingAdapter.view_upcoming(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_upcoming holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class view_upcoming extends RecyclerView.ViewHolder {
        public view_upcoming(@NonNull View itemView) {
            super(itemView);
        }
    }
}
