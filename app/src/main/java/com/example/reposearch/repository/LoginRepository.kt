package com.example.reposearch.repository

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.AccessToken
import com.example.reposearch.enums.EResultType
import com.example.reposearch.localapi.ILoginLocalApi
import com.example.reposearch.network.RestApiService
import com.example.reposearch.repository.interfaces.ILoginRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val loginLocalApi: ILoginLocalApi,
    private val restApiService: RestApiService
) : ILoginRepository {

    private val _msgToken = MutableSharedFlow<EResultType>()
    override val msgToken: SharedFlow<EResultType> = _msgToken.asSharedFlow()

    override suspend fun getAccessToken(code: String) {
        try {
            val accessToken = restApiService.getAccessToken(
                AppDefaultValues.CLIENT_ID,
                AppDefaultValues.CLIENT_SECRET,
                code
            )
            if (accessToken.isSuccessful) {
                loginLocalApi.saveToken(accessToken.body() ?: AccessToken(""))

            }

            _msgToken.emit(EResultType.SUCCESS)

        } catch (e: Exception) {
            _msgToken.emit(EResultType.ERROR)
        }
    }
}