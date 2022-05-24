package com.example.reposearch.usecases.interfaces

import androidx.paging.PagingSource
import com.example.reposearch.data.RepositoryModel

interface ISearchUseCase {
    operator fun invoke(nameRepo: String): PagingSource<Int, RepositoryModel>
}
