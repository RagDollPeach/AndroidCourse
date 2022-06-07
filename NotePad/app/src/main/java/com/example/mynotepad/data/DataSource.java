package com.example.mynotepad.data;

import com.example.mynotepad.intefaces.IDataSource;
import com.example.mynotepad.pojo.Note;

import java.util.ArrayList;

public class DataSource implements IDataSource {

    private static DataSource dataSource;
    private ArrayList<Note> notesList = new ArrayList<>();

    @Override
    public ArrayList<Note> getNotesList() {
        return notesList;
    }

    private DataSource() {

    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
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
