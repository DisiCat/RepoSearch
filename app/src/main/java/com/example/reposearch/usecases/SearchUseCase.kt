package com.example.reposearch.usecases

import androidx.paging.PagingSource
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.repository.SearchRepository
import com.example.reposearch.repository.interfaces.ISearchRepository
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: ISearchRepository
) : ISearchUseCase {

    override operator fun invoke(nameRepo: String): PagingSource<Int, RepositoryModel>{
        return searchRepository.reposAll(nameRepo)
    }

}