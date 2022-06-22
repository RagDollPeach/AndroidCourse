package com.example.mynotepad.pojo;

import java.io.Serializable;

public class City implements Serializable {

    private final int index;
    private final String name;

    public City(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
