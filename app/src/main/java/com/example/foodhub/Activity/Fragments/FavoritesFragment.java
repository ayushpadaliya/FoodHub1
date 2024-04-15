package com.example.foodhub.Activity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.foodhub.Activity.Adapter.ViewPager;
import com.example.foodhub.Activity.Adapter.ViewPagerFavAdpater;
import com.example.foodhub.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FavoritesFragment extends Fragment {

    ViewPager2 viewPager2;

    com.google.android.material.tabs.TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_favorites, container, false);
        tabLayout=view.findViewById(R.id.tabLayoutFav);
        viewPager2=view.findViewById(R.id.viewPagerFav);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(0).setText("Food items");
        tabLayout.getTabAt(1).setText("Restaurants");
        ViewPagerFavAdpater favAdapter=new ViewPagerFavAdpater(getActivity());
        viewPager2.setAdapter(favAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            if (position == 0) {
                tab.setText("Food items");
            }
            else {
                tab.setText("Restaurants");
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