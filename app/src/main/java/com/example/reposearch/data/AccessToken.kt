package com.example.reposearch.data

import com.squareup.moshi.Json

data class AccessToken(
    @Json(name = "access_token") val accessToken: String

)
