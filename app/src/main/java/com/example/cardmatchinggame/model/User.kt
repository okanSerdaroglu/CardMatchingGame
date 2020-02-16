package com.example.cardmatchinggame.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var nickname: String,
    var password: String
) : Parcelable