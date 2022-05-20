package com.example.reposearch.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Json(name = "login")
    val username : String,
    val name: String,
    val email: String,
    val bio: String,
    val location: String,
    val followers: Int,
    val following: Int,
) : Parcelable
