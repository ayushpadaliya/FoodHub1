package com.example.foodhub.Activity.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.Activity.DbHandler.RestaurantDb;
import com.example.foodhub.Activity.FoodDetailsActivity;
import com.example.foodhub.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.view_restaurants> {
    Context context;
    LayoutInflater layoutInflater;
    List<RestaurantDb> restaurantDbList;


    public RestaurantsAdapter(Context context, List<RestaurantDb> restaurantDbList) {
        this.context = context;
        this.restaurantDbList=restaurantDbList;
    }

    @NonNull
    @Override
    public view_restaurants onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.resturant,parent,false);
        return new view_restaurants(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_restaurants holder, int position) {
        holder.imageView.setImageResource(restaurantDbList.get(position).getImageId());
        holder.name.setText(restaurantDbList.get(position).getName());
        holder.rating.setText(restaurantDbList.get(position).getRating());
        holder.text.setText(restaurantDbList.get(position).getNumber());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FoodDetailsActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class view_restaurants extends RecyclerView.ViewHolder {

        MaterialCardView cardView;
        ImageView imageView;
        TextView rating,text,name;
        public view_restaurants(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.restaurant_card);
            imageView=itemView.findViewById(R.id.rest_image);
            rating=itemView.findViewById(R.id.rating);
            text=itemView.findViewById(R.id.txt3);
            name=itemView.findViewById(R.id.restHeader);

        }
    }
}
