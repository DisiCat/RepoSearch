package com.example.reposearch.data

import com.squareup.moshi.Json


data class User(
    @Json(name = "login")
    val username : String,
    val name: String,
    val email: String,
    val bio: String,
    val location: String,
    val followers: Int,
    val following: Int,
)
