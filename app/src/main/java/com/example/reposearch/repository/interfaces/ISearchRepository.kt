package com.example.reposearch.repository.interfaces

interface ISearchRepository {
    suspend fun getRepos(name: String)
}
