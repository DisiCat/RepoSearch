package com.example.reposearch

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) : ILoginUseCase {

    override suspend fun getAccessToken(code: String) {
        loginRepository.getAccessToken(code)
    }
}