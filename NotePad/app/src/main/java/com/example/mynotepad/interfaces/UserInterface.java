package com.example.mynotepad.interfaces;

import com.example.mynotepad.pojo.User;

import java.util.ArrayList;

public interface UserInterface {

    ArrayList<User> userList();

    void addUser(User user);

    void removeUser(User user);

    void removeUser(int index);
}
