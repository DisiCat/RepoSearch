package com.example.reposearch.usecases.observerUseCases

import com.example.reposearch.enums.EResultType
import com.example.reposearch.repository.ILoginRepository
import com.example.reposearch.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginObserverUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) : ILoginObserverUseCase {

    override suspend fun subscribeToken() = flow {
        loginRepository.msgToken.collect {
            emit(it)
        }
    }
}