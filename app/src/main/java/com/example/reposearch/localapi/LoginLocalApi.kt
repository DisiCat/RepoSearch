package com.example.reposearch.localapi

import com.example.reposearch.data.AccessToken
import com.example.reposearch.localapi.ILoginLocalApi
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