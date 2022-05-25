package com.example.reposearch.repository.interfaces

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.SharedFlow

interface ILoginRepository {
    suspend fun getAccessToken(code: String)
    val msgToken: SharedFlow<EResultType>
}
