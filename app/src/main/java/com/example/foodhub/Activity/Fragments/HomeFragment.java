package com.example.foodhub.Activity.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodhub.Activity.Adapter.HomeFoodAdapter;
import com.example.foodhub.Activity.Adapter.PopularItemAdapter;
import com.example.foodhub.Activity.Adapter.RestaurantsAdapter;
import com.example.foodhub.Activity.Adapter.SidebarAdapter;
import com.example.foodhub.Activity.DbHandler.HomeDB;
import com.example.foodhub.Activity.DbHandler.PopularItems;
import com.example.foodhub.Activity.DbHandler.RestaurantDb;
import com.example.foodhub.Activity.DbHandler.SideBarDB;
import com.example.foodhub.Activity.Utils.VariableBag;
import com.example.foodhub.Activity.WelcomeActivity;
import com.example.foodhub.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    DrawerLayout drawerLayout;
    ImageView imageView;
    ImageView logout;
    RelativeLayout mainContentContainer;
    RecyclerView recyclerView;
    SideBarDB sideBarDB;
    List<SideBarDB>dbList;
    RecyclerView recyclerViewRestaurants,recyclerViewPopular;
    RestaurantsAdapter restaurantsAdapter;
    PopularItemAdapter popularItemAdapter;
    HomeDB homeDB;
    HomeFoodAdapter homeFoodAdapter;
    ImageView profile;
    List<HomeDB.Message> food;
    List<RestaurantDb> restaurantDbList;
    List<PopularItems> popularItemsList;
    LayoutInflater layoutInflater;
    ImageView headerIcon,homeLogoutIcon;

   /* @Override
    public void onResume() {
        super.onResume();
        startActivity(new Intent(getContext(), HomeFragment.class));
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        imageView=view.findViewById(R.id.home_sideIcon);
        homeDB=new HomeDB(getActivity());
        food=new ArrayList<>();

        headerIcon=view.findViewById(R.id.header_icon);
        Glide.with(requireActivity()).load(String.valueOf(VariableBag.pathImage)).apply(RequestOptions.circleCropTransform()).into(headerIcon);
        homeLogoutIcon=view.findViewById(R.id.homeLogoutIcon);
        homeLogoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(getActivity(), GoogleSignInOptions.DEFAULT_SIGN_IN);
                googleSignInClient.revokeAccess().addOnCompleteListener(getActivity(),
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                //add sign out code also
                                FirebaseAuth.getInstance().signOut();
//                                Toast.makeText(HomeActivity.this, "SignOut", Toast.LENGTH_SHORT).show();
                                //intent for login screen and finish this screen
                                Intent intent= new Intent(getActivity(), WelcomeActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });


            }
        });
        profile=view.findViewById(R.id.homeProfile);
        Log.d("imagepath","profile"+ VariableBag.pathImage);
        Glide.with(requireActivity()).load(String.valueOf(VariableBag.pathImage)).apply(RequestOptions.circleCropTransform()).into(profile);
        homeDB.addMessage("burger",R.drawable.burger);
        homeDB.addMessage("Donat",R.drawable.donat);
        homeDB.addMessage("Pizza",R.drawable.pizaa);
        homeDB.addMessage("Mexican",R.drawable.maxican);
        homeDB.addMessage("Asian",R.drawable.asian);

        drawerLayout=view.findViewById(R.id.drawerLayout);
        mainContentContainer=view.findViewById(R.id.home_main);

        recyclerView=view.findViewById(R.id.foodRecycle);
        homeFoodAdapter=new HomeFoodAdapter(getActivity(),homeDB.getMessage());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeFoodAdapter);

        restaurantDbList=new ArrayList<>();

        restaurantDbList.add(new RestaurantDb("McDonald’s",R.drawable.mcd,"4.5","(25+)",getActivity()));
        restaurantDbList.add(new RestaurantDb("Starbuck",R.drawable.starbucks,"4.7","(99+)",getActivity()));
        recyclerViewRestaurants=view.findViewById(R.id.home_recycleRestaurants);
        restaurantsAdapter=new RestaurantsAdapter(getActivity(),restaurantDbList);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewRestaurants.setLayoutManager(linearLayoutManager1);
        recyclerViewRestaurants.setAdapter(restaurantsAdapter);

        popularItemsList=new ArrayList<>();
        popularItemsList.add(new PopularItems("Salmon Salad",R.drawable.salmon,"4.5","(25+)","5.50","Baked salmon fish",getActivity()));
        popularItemsList.add(new PopularItems("pizza",R.drawable.salmon1,"4.2","(99+)","8.25","margarita",getActivity()));
        recyclerViewPopular=view.findViewById(R.id.home_recyclePopular);
        popularItemAdapter=new PopularItemAdapter(getActivity(),popularItemsList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerViewPopular.setLayoutManager(gridLayoutManager);
        recyclerViewPopular.setAdapter(popularItemAdapter);


        dbList=new ArrayList<>();
        dbList.add(new SideBarDB(getActivity(),"My Orders",R.drawable.sideorder));
        dbList.add(new SideBarDB(getActivity(),"My Profile",R.drawable.sideprofile));
        dbList.add(new SideBarDB(getActivity(),"Delivery Address",R.drawable.sidelocation));
        dbList.add(new SideBarDB(getActivity(),"Payment Methods",R.drawable.sidewallet));
        dbList.add(new SideBarDB(getActivity(),"Contact Us",R.drawable.sidemessage));
        dbList.add(new SideBarDB(getActivity(),"Settings",R.drawable.sidesetting));
        dbList.add(new SideBarDB(getActivity(),"Helps & FAQs",R.drawable.sidehelp));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);

                } else {
                    drawerLayout.openDrawer(GravityCompat.START);

                }
            }
        });
/*        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*/
        RecyclerView sidebarRecycle=view.findViewById(R.id.sidebarRecycle);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity());
        sidebarRecycle.setLayoutManager(linearLayoutManager2);
        sidebarRecycle.setAdapter(new SidebarAdapter(getActivity(),dbList));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                float slideX = drawerView.getWidth() * slideOffset;
                mainContentContainer.setTranslationX(slideX);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        return view;
    }

}