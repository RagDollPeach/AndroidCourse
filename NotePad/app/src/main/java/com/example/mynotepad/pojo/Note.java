package com.example.mynotepad.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Comparable<Note>, Parcelable {

    private String title;
    private String note;
    private long date;

    public Note(String title, String note, long date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public Note(Parcel in) {
        title = in.readString();
        note = in.readString();
        date = in.readLong();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(note);
        parcel.writeLong(date);
    }
}
