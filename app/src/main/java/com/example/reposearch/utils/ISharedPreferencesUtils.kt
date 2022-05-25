package com.example.reposearch.utils

import com.example.reposearch.data.RepositoryModel

interface ISharedPreferencesUtils {
    fun addRepositoriesList(name: String, list: List<RepositoryModel>)
   fun getRepositoriesList(name: String?): List<RepositoryModel>?
}
