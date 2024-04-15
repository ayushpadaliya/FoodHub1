package com.example.foodhub.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class CartAdpater extends RecyclerView.Adapter<CartAdpater.view_cart> {
    LayoutInflater layoutInflater;


    @NonNull
    @Override
    public view_cart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.cart,parent,false);
        return new view_cart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_cart holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class view_cart  extends RecyclerView.ViewHolder {
        public view_cart(@NonNull View itemView) {
            super(itemView);
        }
    }
}
