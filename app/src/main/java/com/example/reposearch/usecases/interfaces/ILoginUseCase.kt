package com.example.reposearch.usecases.interfaces

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    suspend fun getAccessToken(code : String)
}