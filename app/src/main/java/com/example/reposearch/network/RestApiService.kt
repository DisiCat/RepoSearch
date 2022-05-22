package com.example.reposearch.network

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.AccessToken
import com.example.reposearch.data.User
import com.example.reposearch.data.parseModels.Repositories
import retrofit2.Response
import retrofit2.http.*

interface RestApiService {

    @Headers("Accept: application/json")
    @POST(AppDefaultValues.TOKEN_URL)
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ) : Response<AccessToken>


    @Headers("Content-Type: application/json")
    @GET("user")
    suspend fun getUserData(
        @Header("authorization") token: String
    ): Response<User>

    @Headers("Accept: application/json")
    @POST(AppDefaultValues.REPO_URL)
    suspend fun getRepos(
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("q") q : List<String>
    ) : Response<Repositories>

}