package com.example.reposearch.repository

import androidx.paging.PagingSource
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.network.ReposPageSource
import com.example.reposearch.repository.interfaces.ISearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(
    private val reposPageSource: ReposPageSource.Factory
) : ISearchRepository {

    override fun reposAll(nameRepo: String): PagingSource<Int, RepositoryModel> {
        return reposPageSource.create(nameRepo)
    }

}