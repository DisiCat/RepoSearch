package com.example.reposearch.repository

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.enums.EResultType
import com.example.reposearch.localapi.ILoginLocalApi
import com.example.reposearch.network.RestApiService
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
            loginLocalApi.saveToken(accessToken)

            _msgToken.emit(EResultType.SUCCESS)

        } catch (e: Exception) {
            _msgToken.emit(EResultType.ERROR)
        }
    }
}