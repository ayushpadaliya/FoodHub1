package com.example.foodhub.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class FastFoodAdapter extends RecyclerView.Adapter<FastFoodAdapter.view_fast> {
LayoutInflater layoutInflater;

    @NonNull
    @Override
    public view_fast onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.fast,parent,false);
        return new view_fast(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_fast holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class view_fast extends RecyclerView.ViewHolder {
        public view_fast(@NonNull View itemView) {
            super(itemView);
        }
    }
}
