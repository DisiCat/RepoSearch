package com.example.reposearch.usecases.interfaces

interface ISearchUseCase {
    suspend fun getRepos(name: String)
}
