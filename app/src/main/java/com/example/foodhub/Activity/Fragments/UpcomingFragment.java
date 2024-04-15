package com.example.foodhub.Activity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodhub.Activity.Adapter.LastOrderAdapter;
import com.example.foodhub.Activity.Adapter.UpcomingAdapter;
import com.example.foodhub.Activity.DbHandler.LastedDbHandler;
import com.example.foodhub.R;

import java.util.ArrayList;
import java.util.List;


public class UpcomingFragment extends Fragment {

    List<LastedDbHandler> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_upcoming, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.upcoming_recycle);
        UpcomingAdapter upcomingAdapter=new UpcomingAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(upcomingAdapter);
        list.add(new LastedDbHandler(R.drawable.jimmy,"Jimmy John’s",getActivity()));
        list.add(new LastedDbHandler(R.drawable.subway,"Subway",getActivity()));
        RecyclerView recyclerView1=view.findViewById(R.id.lastedRecycle);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(linearLayoutManager1);
        LastOrderAdapter lastOrderAdapter=new LastOrderAdapter(list,getActivity());
        recyclerView1.setAdapter(lastOrderAdapter);
        return view;
    }
}