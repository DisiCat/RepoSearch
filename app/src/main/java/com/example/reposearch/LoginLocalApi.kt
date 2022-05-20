package com.example.reposearch

import com.example.reposearch.data.AccessToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginLocalApi @Inject constructor() : ILoginLocalApi {
    private var accessToken : AccessToken? = null

    override fun saveToken(token :AccessToken)  {
        accessToken = token
    }

    override fun getToken() = accessToken
}