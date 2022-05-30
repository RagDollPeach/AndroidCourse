package com.example.mynotepad.pojo;

import java.io.Serializable;

public class Note implements Serializable, Comparable<Note> {

    private String title;
    private String note;
    private long date;

    public Note(String title, String note, long date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int compareTo(Note note) {
        return this.getName().compareTo(note.getName());
    }
}
