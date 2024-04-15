package com.example.foodhub.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.foodhub.Activity.Fragments.AddressFragment;
import com.example.foodhub.Activity.Fragments.FavoritesFragment;
import com.example.foodhub.Activity.Fragments.HomeFragment;
import com.example.foodhub.Activity.Fragments.NotificationFragment;
import com.example.foodhub.Activity.Fragments.OrderFragment;
import com.example.foodhub.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    androidx.viewpager2.widget.ViewPager2 viewPager2;
    HomeFragment homeFragment;
    AddressFragment addressFragment;
    OrderFragment orderFragment;
    FavoritesFragment fragment;
    NotificationFragment notificationFragment;
    ArrayList<Fragment> FragmentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        homeFragment=new HomeFragment();
        orderFragment=new OrderFragment();
        fragment=new FavoritesFragment();
        addressFragment=new AddressFragment();
        notificationFragment=new NotificationFragment();
        FragmentList.add(homeFragment);
        FragmentList.add(addressFragment);
        FragmentList.add(orderFragment);
        FragmentList.add(fragment);
        FragmentList.add(notificationFragment);
        viewPager2=findViewById(R.id.viewpage);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { int itemId = menuItem.getItemId(); // Get the ID of the selected item

                // Define constant values to match your menu item IDs
                final int HOME_ID = R.id.bottom_home;
                final int ORDER_ID = R.id.bottom_order;
                final int BAG_ID = R.id.bottom_bag;
                final int LIKE_ID = R.id.bottom_like;
                final int NOTIFICATION_ID = R.id.bottom_notification;

                if (itemId == HOME_ID) {
                    viewPager2.setCurrentItem(0);
                    return true;
                } else if (itemId == ORDER_ID) {
                    viewPager2.setCurrentItem(1);
                    return true;
                } else if (itemId == BAG_ID) {
                    viewPager2.setCurrentItem(2);
                    return true;
                } else if (itemId == LIKE_ID) {
                    viewPager2.setCurrentItem(3);
                    return true;
                }
                else if (itemId==NOTIFICATION_ID) {
                    viewPager2.setCurrentItem(4);
                    return true;
                }
                return false;
            };
        });
        viewPager2.setUserInputEnabled(false);
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return FragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return FragmentList.size();
            }

        });

    }
}