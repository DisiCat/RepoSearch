package com.example.reposearch

import com.example.reposearch.enums.EResultType
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    suspend fun getAccessToken(code: String)
}
