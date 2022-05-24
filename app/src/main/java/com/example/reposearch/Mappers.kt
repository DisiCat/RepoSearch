package com.example.reposearch

import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.data.parseModels.Items

internal fun Items.toRepositoryModel(): RepositoryModel {
    return RepositoryModel(
        name = this.fullName ?: "",
        star_count = stargazersCount ?: 0
    )
}