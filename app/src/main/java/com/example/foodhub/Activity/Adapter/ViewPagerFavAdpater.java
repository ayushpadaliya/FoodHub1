package com.example.foodhub.Activity.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodhub.Activity.Fragments.FoodItemFragment;
import com.example.foodhub.Activity.Fragments.HistoryFragment;
import com.example.foodhub.Activity.Fragments.RestaurantFragment;
import com.example.foodhub.Activity.Fragments.UpcomingFragment;

public class ViewPagerFavAdpater extends FragmentStateAdapter {
    public ViewPagerFavAdpater(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FoodItemFragment();
            case 1:
                return new RestaurantFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
