package com.example.mynotepad.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mynotepad.R;
import com.example.mynotepad.data.UsersDataSource;
import com.example.mynotepad.interfaces.DrawerLoc;
import com.example.mynotepad.interfaces.IDrawerHeaderHandler;
import com.example.mynotepad.interfaces.UserInterface;
import com.example.mynotepad.pojo.User;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class RegisterFragment extends Fragment {

    private User user;

    private UserInterface dataSource = UsersDataSource.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toolbar toolbar = requireActivity().findViewById(R.id.tool_bar);
        toolbar.setTitle("Регистрация");
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText name = view.findViewById(R.id.reg_name);
        EditText lastName = view.findViewById(R.id.reg_last_name);
        EditText login = view.findViewById(R.id.reg_login);
        EditText password = view.findViewById(R.id.reg_password);

        DrawerLoc loc = (DrawerLoc) requireActivity();
        IDrawerHeaderHandler activity = (IDrawerHeaderHandler) requireActivity();

        if (activity.getName().equals("Имя") && activity.getLastName().equals("Фамилия")) {
            loc.locDrawer();
        } else {
            loc.unLocDrawer();
        }

        MaterialButton registerButton = view.findViewById(R.id.reg_button);
        registerButton.setOnClickListener(view1 -> {
            if (name.getText() == null && lastName.getText() == null && login.getText() == null && password.getText() == null) {
                Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {

                boolean checkLogin = dataSource.userList().stream().anyMatch(user1 -> user1.getLogin().equals(login.getText().toString()));

                if (!dataSource.userList().isEmpty() && checkLogin) {
                    Toast.makeText(requireContext(), "Такой логин уже зарегестрирован", Toast.LENGTH_LONG).show();
                } else {
                    user = new User(name.getText().toString()
                            , lastName.getText().toString()
                            , login.getText().toString()
                            , password.getText().toString());
                    dataSource.addUser(user);
                    hideKeyboard(requireActivity());
                    enableFragment(new LoginFragment(), "fragment_login");
                }
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken()
                    , InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void enableFragment(Fragment fragment, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentName)
                .commit();
    }
}