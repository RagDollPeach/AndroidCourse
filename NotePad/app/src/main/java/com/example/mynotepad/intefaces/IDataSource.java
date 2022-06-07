package com.example.mynotepad.intefaces;

import com.example.mynotepad.pojo.Note;

import java.util.ArrayList;

public interface IDataSource {

    ArrayList<Note> getNotesList();

    void addNote(Note note);

    void removeNote(int position);

    void removeNote(Note note);

    void removeAll();
}
