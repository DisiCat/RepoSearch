package com.example.reposearch.network

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.data.parseModels.Items
import com.example.reposearch.data.parseModels.Repositories
import com.example.reposearch.toRepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Response
import javax.inject.Inject

class RepoRequester @Inject constructor(
    private val restApiService: RestApiService
) : IRepoRequester {

    override suspend fun sendRepositoryRequest(
        repoName: String,
        page: Pair<Int, Int>
    ): List<RepositoryModel> = coroutineScope {
        val list = mutableListOf<RepositoryModel>()

        val firstRepositoryJob = async(Dispatchers.IO) {
            val response = restApiService.getRepos(
                "star",
                "desc",
                AppDefaultValues.PAGE_COUNT,
                page.first,
                repoName
            )
            list += createList(response)
        }

        val secondRepositoryJob = async(Dispatchers.IO) {
            val response = restApiService.getRepos(
                "star",
                "desc",
                AppDefaultValues.PAGE_COUNT,
                page.second,
                repoName
            )
            list += createList(response)
        }

        firstRepositoryJob.await()
        secondRepositoryJob.await()
        return@coroutineScope list.sortedByDescending { it.star_count }
    }

    private fun createList(response: Response<Repositories>): List<RepositoryModel> {
        val result = mutableListOf<RepositoryModel>()
        if (response.isSuccessful) {
            response.body()?.let {
                result += it.items.map { it1: Items -> it1.toRepositoryModel() }
            }
        }
        return result
    }
}