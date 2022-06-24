package com.example.recyclerview2

import android.os.Parcel
import android.os.Parcelable

data class Onigiri(
    val image: Int,
    val name: String,
    val text: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Onigiri> {
        override fun createFromParcel(parcel: Parcel): Onigiri {
            return Onigiri(parcel)
        }

        override fun newArray(size: Int): Array<Onigiri?> {
            return arrayOfNulls(size)
        }
    }
}

