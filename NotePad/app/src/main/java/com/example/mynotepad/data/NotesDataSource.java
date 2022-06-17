package com.example.mynotepad.data;

import com.example.mynotepad.interfaces.INotesDataSource;
import com.example.mynotepad.pojo.Note;

import java.util.ArrayList;

public class NotesDataSource implements INotesDataSource {

    private static NotesDataSource dataSource;
    private ArrayList<Note> notesList = new ArrayList<>();

    @Override
    public ArrayList<Note> getNotesList() {
        return notesList;
    }

    private NotesDataSource() {

    }

    public static NotesDataSource getInstance() {
        if (dataSource == null) {
            dataSource = new NotesDataSource();
        }
        return dataSource;
    }

    @Override
    public void addNote(Note note) {
        notesList.add(note);
    }

    @Override
    public void removeNote(int position) {
        notesList.remove(position);
    }

    @Override
    public void removeNote(Note note) {
        notesList.remove(note);
    }

    @Override
    public void removeAll() {
        notesList.clear();
    }
}
