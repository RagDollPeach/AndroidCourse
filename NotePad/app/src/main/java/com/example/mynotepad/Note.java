package com.example.mynotepad;

import java.time.LocalDate;


public class Note {

    private String title;
    private String note;
    private LocalDate date;

    public Note() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
