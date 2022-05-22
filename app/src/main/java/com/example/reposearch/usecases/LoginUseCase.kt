package com.example.reposearch.usecases

import com.example.reposearch.repository.interfaces.ILoginRepository
import com.example.reposearch.usecases.interfaces.ILoginUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) : ILoginUseCase {

    override suspend fun getAccessToken(code: String) {
        loginRepository.getAccessToken(code)
    }
}