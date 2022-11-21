package com.example.intent

import android.os.Parcel
import android.os.Parcelable

data class NameObject(
    val nama: String?,
    val umur: Int,
    val nickname: String?,
    val alamat: String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(umur)
        parcel.writeString(nickname)
        parcel.writeString(alamat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NameObject> {
        override fun createFromParcel(parcel: Parcel): NameObject {
            return NameObject(parcel)
        }

        override fun newArray(size: Int): Array<NameObject?> {
            return arrayOfNulls(size)
        }
    }
}
