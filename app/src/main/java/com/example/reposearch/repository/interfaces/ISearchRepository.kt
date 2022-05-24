package com.example.reposearch.repository.interfaces

import androidx.paging.PagingSource
import com.example.reposearch.data.RepositoryModel

interface ISearchRepository {
    fun reposAll(nameRepo: String) : PagingSource<Int, RepositoryModel>
}
