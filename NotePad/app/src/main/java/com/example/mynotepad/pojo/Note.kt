package com.example.mynotepad.pojo

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator

data class Note(var title: String,var note: String,var date: Long) : Comparable<Note>, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readLong()
    )

    override fun compareTo(other: Note): Int {
        return this.title.compareTo(other.title)
    }

    override fun describeContents(): Int {
      return -1
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(title)
        p0?.writeString(note)
        p0?.writeLong(date)
    }

    companion object CREATOR : Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}