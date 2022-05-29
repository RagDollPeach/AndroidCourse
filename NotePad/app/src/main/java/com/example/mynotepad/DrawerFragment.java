package com.example.mynotepad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DrawerFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        TextView name = view.findViewById(R.id.text_view_name);
        TextView lastname = view.findViewById(R.id.text_view_lastname);

        if (!MainActivity.usersList.isEmpty()) {
            name.setText(MainActivity.usersList.get(0).getName());
            lastname.setText(MainActivity.usersList.get(0).getLastName());
            MainActivity.usersList.remove(MainActivity.usersList.get(0));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}