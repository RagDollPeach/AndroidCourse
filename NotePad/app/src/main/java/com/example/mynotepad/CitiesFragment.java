package com.example.mynotepad;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class CitiesFragment extends Fragment {

    private final String CURRENT_CITY = "current_city";
    private City city;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            city = (City) savedInstanceState.getSerializable(CURRENT_CITY);
        }
        initList(view);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CURRENT_CITY, city);
        super.onSaveInstanceState(outState);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setPadding(300,0, 0, 0);
            tv.setTextColor(Color.parseColor("#FF000000"));
            tv.setTextSize(34);
            tv.setText(city);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(view1 -> {
                CitiesFragment.this.city = new City(position, city);
                showCoatOfArms(CitiesFragment.this.city);
            });
        }
    }

    private void showCoatOfArms(City city) {
        showPortraitCoastOfArms(city);
    }

//    private void showLandCoastOfArms(City city) {
//        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(city);
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//
//        fragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, coatOfArmsFragment)
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                .commit();
//    }

    private void showPortraitCoastOfArms(City city) {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(city);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, coatOfArmsFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}