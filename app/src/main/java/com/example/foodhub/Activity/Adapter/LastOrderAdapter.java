package com.example.foodhub.Activity.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.Activity.DbHandler.LastedDbHandler;
import com.example.foodhub.R;

import java.util.List;

public class LastOrderAdapter extends RecyclerView.Adapter<LastOrderAdapter.view_last>{

    LayoutInflater layoutInflater;
    List<LastedDbHandler> list;
    Context context;

    public LastOrderAdapter(List<LastedDbHandler> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public view_last onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.lastorder,parent,false);

        return new view_last(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_last holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class view_last extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public view_last(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.lastImage);
            textView=itemView.findViewById(R.id.lastMainName);


        }
    }
}
