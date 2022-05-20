package com.example.reposearch.network

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.AccessToken
import com.example.reposearch.data.User
import retrofit2.http.*

interface RestApiService {

    @Headers("Accept: application/json")
    @POST(AppDefaultValues.TOKEN_URL)
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ) : AccessToken


    @Headers("Content-Type: application/json")
    @GET("user")
    suspend fun getUserData(
        @Header("authorization") token: String
    ): User

}