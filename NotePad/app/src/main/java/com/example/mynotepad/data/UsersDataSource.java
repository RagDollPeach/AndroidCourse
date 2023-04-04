package com.example.mynotepad.data;

import com.example.mynotepad.interfaces.UserInterface;
import com.example.mynotepad.pojo.User;

import java.util.ArrayList;

public class UsersDataSource implements UserInterface {

    private static UsersDataSource dataSource;
    private ArrayList<User> usersList = new ArrayList<>();

    private UsersDataSource() {
    }

    public static UsersDataSource getInstance() {
        if (dataSource == null) {
            dataSource = new UsersDataSource();
        }
        return dataSource;
    }

    @Override
    public ArrayList<User> userList() {
        return usersList;
    }

    @Override
    public void addUser(User user) {
        usersList.add(user);
    }

    @Override
    public void removeUser(User user) {
        usersList.remove(user);
    }

    @Override
    public void removeUser(int index) {
        usersList.remove(index);
    }
}
