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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return this.getTitle().compareTo(note.getTitle());
    }
}
