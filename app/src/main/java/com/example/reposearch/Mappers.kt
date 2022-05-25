package com.example.reposearch

import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.data.parseModels.Items

internal fun Items.toRepositoryModel(
    list: List<RepositoryModel>?
): RepositoryModel {
    return RepositoryModel(

        id = id ?: 0,
        name = this.fullName ?: "",
        star_count = stargazersCount ?: 0,
        repo_url = htmlUrl ?: "",
        isRead = list?.any { it.id == id } ?: false
    )
}