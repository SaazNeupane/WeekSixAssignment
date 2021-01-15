package com.example.week6softuser

import android.os.Parcel
import android.os.Parcelable

data class Data (
    val Fullname: String? = null,
    val Age: Int? = null,
    val Gender: String?= null,
    val Address: String? = null
): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Fullname)
        parcel.writeValue(Age)
        parcel.writeString(Gender)
        parcel.writeString(Address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}