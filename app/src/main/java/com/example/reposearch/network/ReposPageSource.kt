package com.example.reposearch.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.reposearch.data.RepositoryModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ReposPageSource @AssistedInject constructor(
    private val repoRequester: IRepoRequester,
    @Assisted("nameRepo") private val nameRepo: String

) : PagingSource<Int, RepositoryModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryModel> {
        if (nameRepo.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }

        return try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER

            val repositories = repoRequester.sendRepositoryRequest(
                nameRepo,
                Pair(first = pageNumber, second = pageNumber + 1)
            )

            val nextPageNumber = if (repositories.isEmpty()) null else pageNumber + 2
            val prevPageNumber = if (pageNumber > 2) -2 else null
            LoadResult.Page(repositories, prevPageNumber, nextPageNumber)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositoryModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(2) ?: anchorPage.nextKey?.minus(2)
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("nameRepo") nameRepo: String): ReposPageSource
    }

    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}