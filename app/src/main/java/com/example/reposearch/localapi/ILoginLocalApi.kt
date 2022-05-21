package com.example.reposearch.localapi

import com.example.reposearch.data.AccessToken

interface ILoginLocalApi {
    fun saveToken(token : AccessToken)
    fun getToken() : AccessToken?
}
