package com.example.reposearch.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.utils.ISharedPreferencesUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val sharedPreferencesUtils: ISharedPreferencesUtils
) : ViewModel() {
    private val _historyList = MutableLiveData<List<RepositoryModel>?>()
    val historyList: LiveData<List<RepositoryModel>?>
        get() = _historyList

    init {
        val listFromStorage =
            sharedPreferencesUtils.getRepositoriesList(AppDefaultValues.REPOSITORIES_LIST)
        listFromStorage?.let {
            _historyList.value =
                if (listFromStorage.size >= 20) listFromStorage.takeLast(20)
                    .reversed() else listFromStorage
        }
    }
}