package com.example.mynotepad.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotepad.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class LoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText name = view.findViewById(R.id.edit_name);
        EditText lastName = view.findViewById(R.id.edit_last_name);
        MaterialButton loginButton = view.findViewById(R.id.login_button);

        MaterialButton backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager().popBackStack());

        loginButton.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Ну типо авторизовался :D", Toast.LENGTH_SHORT).show();
            hideKeyboard(requireActivity());
            requireActivity().getSupportFragmentManager().popBackStack();
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.menu_login);
        MenuItem item1 = menu.findItem(R.id.menu_about);
        MenuItem item2 = menu.findItem(R.id.menu_find);
        if (item != null && item1 != null) {
            item.setVisible(false);
            item1.setVisible(false);
            item2.setVisible(false);
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}