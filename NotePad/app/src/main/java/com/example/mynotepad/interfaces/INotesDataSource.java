package com.example.mynotepad.interfaces;

import com.example.mynotepad.pojo.Note;

import java.util.ArrayList;

public interface INotesDataSource {

    ArrayList<Note> getNotesList();

    void addNote(Note note);

    void removeNote(int position);

    void removeNote(Note note);

    void removeAll();
}
