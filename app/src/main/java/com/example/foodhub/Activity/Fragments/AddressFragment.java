package com.example.foodhub.Activity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.foodhub.R;

import java.util.ArrayList;
import java.util.List;

public class AddressFragment extends Fragment {

    Spinner spinner,spinner1;
    List<String> stateList=new ArrayList<>();
    List<String> stateList1=new ArrayList<>();
//    List<String> stateList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_address, container, false);
        spinner=view.findViewById(R.id.spinner);
        spinner1=view.findViewById(R.id.spinner2);
        stateList.add("Select State");
        stateList.add("gujarat");
        stateList.add("goa") ;


        stateList1.add("Select District");
        stateList1.add("dwarka");
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<>(getActivity(),R.layout.spinneritem,stateList);
        ArrayAdapter<String> spinnerAdapter1=new ArrayAdapter<>(getActivity(),R.layout.spinneritem,stateList1);

        spinner.setAdapter(spinnerAdapter);
        spinner1.setAdapter(spinnerAdapter1);
        return view;
    }
}