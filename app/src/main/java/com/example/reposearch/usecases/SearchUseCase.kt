package com.example.reposearch.usecases

import androidx.paging.PagingSource
import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.repository.interfaces.ISearchRepository
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import com.example.reposearch.utils.ISharedPreferencesUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: ISearchRepository,
    private val sharedPreferencesUtils: ISharedPreferencesUtils
) : ISearchUseCase {

    override operator fun invoke(nameRepo: String): PagingSource<Int, RepositoryModel> {
        return searchRepository.reposAll(nameRepo)
    }

    override fun saveRepositoryInStorage(repository: RepositoryModel) {
        var list: MutableList<RepositoryModel>? =
            sharedPreferencesUtils.getRepositoriesList(AppDefaultValues.REPOSITORIES_LIST)
                ?.toMutableList()

        if (list != null) {
            list.add(repository)
        } else {
            list = mutableListOf(repository)
        }

        sharedPreferencesUtils.addRepositoriesList(
            AppDefaultValues.REPOSITORIES_LIST,
            list.toList()
        )
    }


}