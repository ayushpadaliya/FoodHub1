package com.example.foodhub.Activity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.foodhub.Activity.Adapter.ViewPager;
import com.example.foodhub.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OrderFragment extends Fragment {
    ViewPager2 viewPager2;
    com.google.android.material.tabs.TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_order, container, false);

        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager2=view.findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(0).setText("Upcoming");
        tabLayout.getTabAt(1).setText("History");
        ViewPager adapter = new ViewPager(requireActivity());
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            if (position == 0) {
                tab.setText("Upcoming");
            }
            else {
                tab.setText("History");
            }
        }).attach();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}