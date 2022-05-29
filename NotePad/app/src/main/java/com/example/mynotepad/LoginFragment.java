package com.example.mynotepad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class LoginFragment extends Fragment {

    private String userName;
    private String userLastName;

    EditText name;
    EditText lastName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.edit_name);
        lastName = view.findViewById(R.id.edit_last_name);
        MaterialButton loginButton = view.findViewById(R.id.login_button);

        MaterialButton backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager().popBackStack());

        loginButton.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Ну типо авторизовался :D", Toast.LENGTH_SHORT).show();
            hideKeyboard(requireActivity());
            requireActivity().getSupportFragmentManager().popBackStack();


        });
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