package com.example.mynotepad.pojo

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator

data class User(var name: String, var lastName: String, var login: String, var password: String) :
    Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun describeContents(): Int {
        return -1
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeString(login)
        parcel.writeString(password)
    }

    companion object CREATOR : Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}