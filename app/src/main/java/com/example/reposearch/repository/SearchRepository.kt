package com.example.reposearch.repository

import com.example.reposearch.data.parseModels.Repositories
import com.example.reposearch.network.RestApiService
import com.example.reposearch.repository.interfaces.ISearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(
    private val restApiService: RestApiService
) : ISearchRepository {
    override suspend fun getRepos(name: String) {
       val  result =restApiService.getRepos("star","desc", listOf(name))

        val test : Repositories? = result.body()
        test?.totalCount
    }
}