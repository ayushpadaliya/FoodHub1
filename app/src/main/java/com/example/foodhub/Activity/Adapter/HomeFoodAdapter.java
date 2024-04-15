package com.example.foodhub.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.Activity.DbHandler.HomeDB;
import com.example.foodhub.Activity.FastFoodActivity;
import com.example.foodhub.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class HomeFoodAdapter extends RecyclerView.Adapter<HomeFoodAdapter.View_food> {
    LayoutInflater layoutInflater;
    Context context;
    List<HomeDB.Message> messageList;
    List<com.google.android.material.card.MaterialCardView> cardList=new ArrayList<>();


    public HomeFoodAdapter(Context context, List<HomeDB.Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }



    @NonNull
    @Override
    public View_food onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.foodround,parent,false);
        return new View_food(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_food holder, int position) {
        holder.imageView.setImageResource(messageList.get(position).getImages());
        holder.textView.setText(messageList.get(position).getProduct());
        if (!cardList.contains(holder.cardView)) {
            cardList.add(holder.cardView);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (MaterialCardView item:cardList)
                {
                    item.setCardBackgroundColor(context.getColorStateList(R.color.black));
                }
                holder.cardView.setBackgroundTintList(context.getColorStateList(R.color.MainColor));
                context.startActivity(new Intent(context, FastFoodActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class View_food extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        com.google.android.material.card.MaterialCardView cardView;
        public View_food(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.layPic);
            textView=itemView.findViewById(R.id.layout_text);
            cardView=itemView.findViewById(R.id.layout_color);
        }
    }
}
