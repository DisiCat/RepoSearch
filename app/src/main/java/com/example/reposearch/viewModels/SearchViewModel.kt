package com.example.reposearch.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCaseProvider: Provider<ISearchUseCase>,
    private val searchUseCase: ISearchUseCase
) : ViewModel() {
    private val _repoName = MutableStateFlow("")
    val repoName: StateFlow<String> = _repoName.asStateFlow()
    private var reposPagingSource: PagingSource<*, *>? = null

    val repositories: StateFlow<PagingData<RepositoryModel>> = repoName
        .map(::newPager)
        .flatMapLatest { pager -> pager.flow }.cachedIn(viewModelScope)
        .stateIn(
            viewModelScope, SharingStarted.Lazily,
            PagingData.empty()
        )

    private fun newPager(nameRepo: String): Pager<Int, RepositoryModel> {
        return Pager(PagingConfig(pageSize = 15, enablePlaceholders = false)) {
            val searchUseCase = searchUseCaseProvider.get()
            searchUseCase(nameRepo).also { reposPagingSource = it }
        }
    }

    fun setNameRepo(name: String) {
        _repoName.tryEmit(name)
    }

    fun saveCurrentReposInShared(repository: RepositoryModel?) {
        repository?.let {
            if (!repository.isRead) {
                searchUseCase.saveRepositoryInStorage(repository)
            }
        }

    }

}