package com.example.reposearch

import com.example.reposearch.enums.EResultType
import com.example.reposearch.network.RestApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val loginLocalApi: ILoginLocalApi,
    private val restApiService: RestApiService
) : ILoginRepository {


    override suspend fun getAccessToken(code: String) {
        val accessToken = restApiService.getAccessToken(
            AppDefaultValues.CLIENT_ID,
            AppDefaultValues.CLIENT_SECRET,
            code
        )
        loginLocalApi.saveToken(accessToken)
    }
}