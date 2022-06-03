package com.example.mynotepad;

import androidx.fragment.app.Fragment;

import com.example.mynotepad.pojo.Note;

import java.util.List;

public interface RvOnClickListener {

    void switchFragment(Note note);
}
