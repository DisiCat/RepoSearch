package com.example.reposearch.usecases

import com.example.reposearch.repository.SearchRepository
import com.example.reposearch.repository.interfaces.ISearchRepository
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: ISearchRepository
) : ISearchUseCase {
    override suspend fun getRepos(name: String) {
        searchRepository.getRepos(name)
    }
}