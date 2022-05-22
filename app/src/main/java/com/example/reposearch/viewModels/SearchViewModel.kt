package com.example.reposearch.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reposearch.usecases.SearchUseCase
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: ISearchUseCase
) : ViewModel() {

    fun getRepos(name: String) {
        viewModelScope.launch {
            searchUseCase.getRepos(name)
        }
    }
}