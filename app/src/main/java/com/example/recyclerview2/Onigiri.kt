package com.example.recyclerview2

import android.os.Parcel
import android.os.Parcelable

data class Onigiri(
    val image: Int, // 画像
    val name: String, //おにぎりの名前
    val text: String //説明
    ) : Parcelable {
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

