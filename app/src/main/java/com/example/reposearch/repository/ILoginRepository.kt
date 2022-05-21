package com.example.reposearch.repository

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface ILoginRepository {
    suspend fun getAccessToken(code: String)
    val msgToken: SharedFlow<EResultType>
}
