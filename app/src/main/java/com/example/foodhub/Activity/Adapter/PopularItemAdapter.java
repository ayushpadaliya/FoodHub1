package com.example.foodhub.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.Activity.DbHandler.PopularItems;
import com.example.foodhub.R;

import java.util.List;

public class PopularItemAdapter extends RecyclerView.Adapter<PopularItemAdapter.view_populer> {
        LayoutInflater layoutInflater;
        Context context;
        List<PopularItems> popularItemsList;

    public PopularItemAdapter(Context context, List<PopularItems> popularItemsList) {
        this.context = context;
        this.popularItemsList = popularItemsList;
    }

    @NonNull
    @Override
    public view_populer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.populeritems,parent,false);
        return new PopularItemAdapter.view_populer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_populer holder, int position) {
        holder.imageView.setImageResource(popularItemsList.get(position).getImageId());
        holder.header.setText(popularItemsList.get(position).getName());
        holder.price.setText(popularItemsList.get(position).getPrice());
        holder.desc.setText(popularItemsList.get(position).getDesc());
        holder.number.setText(popularItemsList.get(position).getNumber());
        holder.rating.setText(popularItemsList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class view_populer extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView header,desc,rating,number,price;
        public view_populer(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.populer_image);
            header=itemView.findViewById(R.id.populer_text);
            desc=itemView.findViewById(R.id.populer_text2);
            rating=itemView.findViewById(R.id.popRating);
            number=itemView.findViewById(R.id.popTxt3);
            price=itemView.findViewById(R.id.price);
        }
    }
}
