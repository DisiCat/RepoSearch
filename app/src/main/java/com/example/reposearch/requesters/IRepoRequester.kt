package com.example.reposearch.requesters

import com.example.reposearch.data.RepositoryModel

interface IRepoRequester {
    suspend fun sendRepositoryRequest(repoName: String, page: Pair<Int, Int>): List<RepositoryModel>
}
