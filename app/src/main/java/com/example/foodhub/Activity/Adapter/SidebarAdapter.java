package com.example.foodhub.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.Activity.DbHandler.SideBarDB;
import com.example.foodhub.Activity.ProfileDetailsActivity;
import com.example.foodhub.Activity.RatingActivity;
import com.example.foodhub.Activity.ReviewsActivity;
import com.example.foodhub.R;

import java.util.List;

public class SidebarAdapter extends RecyclerView.Adapter<SidebarAdapter.view_sidebar> {

    LayoutInflater layoutInflater;
    Context context;
    List<SideBarDB> dbList;

    public SidebarAdapter(Context context, List<SideBarDB> dbList) {
        this.context = context;
        this.dbList = dbList;
    }

    @NonNull
    @Override
    public view_sidebar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.sidebarlayout,parent,false);
        return new view_sidebar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_sidebar holder, int position) {
            holder.textView.setText(dbList.get(position).getName());
            holder.imageView.setImageResource(dbList.get(position).getImageId());
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.textView.getText().equals("My Profile"))
                    {
                        context.startActivity(new Intent(context, ProfileDetailsActivity.class));
                    }
                    else if (holder.textView.getText().equals("Settings"))
                    {
                        context.startActivity(new Intent(context, RatingActivity.class));
                    }
                    else if(holder.textView.getText().equals("My Orders"))
                    {
                        context.startActivity(new Intent(context, ReviewsActivity.class));
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class view_sidebar extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;
        public view_sidebar(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textSide);
            imageView=itemView.findViewById(R.id.imageSide);
            relativeLayout=itemView.findViewById(R.id.relativeSidebar);
        }
    }
}
