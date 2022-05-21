package com.example.reposearch.usecases.observerUseCases

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.Flow

interface ILoginObserverUseCase {
    suspend fun subscribeToken(): Flow<EResultType>
}
