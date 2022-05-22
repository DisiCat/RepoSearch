package com.example.reposearch.usecases.observerUseCases

import com.example.reposearch.repository.interfaces.ILoginRepository
import com.example.reposearch.usecases.interfaces.ILoginObserverUseCase
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