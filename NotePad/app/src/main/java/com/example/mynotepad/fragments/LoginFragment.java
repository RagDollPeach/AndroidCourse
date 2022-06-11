package com.example.mynotepad.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import java.util.List;

public class LoginFragment extends Fragment {

    EditText login;
    EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        Toolbar toolbar = requireActivity().findViewById(R.id.tool_bar);
        toolbar.setTitle("Авторизация");
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        login = view.findViewById(R.id.edit_login);
        password = view.findViewById(R.id.edit_password);
        MaterialButton loginButton = view.findViewById(R.id.login_button);

        DrawerLoc loc = (DrawerLoc) requireActivity();
        IDrawerHeaderHandler activity = (IDrawerHeaderHandler) requireActivity();

        if (activity.getName().equals("Имя") && activity.getLastName().equals("Фамилия")) {
            loc.locDrawer();
        } else {
            loc.unLocDrawer();
        }
        UserInterface userData = UsersDataSource.getInstance();
        List<User> list = userData.userList();

        loginButton.setOnClickListener(view1 -> {
            if (list.isEmpty()) {
                Toast.makeText(requireContext(), "Зарегистрируйтесь", Toast.LENGTH_LONG).show();
            } else {
                for (User user : list) {
                    if ((login.getText() != null) &&
                            (login.getText().toString().equals(user.getLogin()) &&
                                    password.getText().toString().equals(user.getPassword()))) {

                        activity.setName(user.getName());
                        activity.setLastName(user.getLastName());
                        hideKeyboard(requireActivity());
                        enableFragment(new MainFragment(), "fragment_main");
                        Toast.makeText(requireContext(), "Авторизация успешна", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(requireContext(), "Токого пользователя нет, зарегестрируйтесь", Toast.LENGTH_LONG).show();
            }
            hideKeyboard(requireActivity());
        });

        MaterialButton registerButton = view.findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> enableFragment(new RegisterFragment(), "fragment_register"));

    }

    @Override
    public void onDestroyView() {
        hideKeyboard(requireActivity());
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.menu_login);
        MenuItem item1 = menu.findItem(R.id.menu_about);
        MenuItem item2 = menu.findItem(R.id.menu_find);
        MenuItem mainItem = menu.findItem(R.id.drawer_main);
        if (item != null) {
            item.setVisible(false);
        }
        if (item1 != null) {
            item1.setVisible(false);
        }
        if (item2 != null) {
            item2.setVisible(false);
        }
        if (mainItem != null && mainItem.isVisible()) {
            mainItem.setVisible(false);
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

    public void enableFragment(Fragment fragment, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentName)
                .commit();

    }
}