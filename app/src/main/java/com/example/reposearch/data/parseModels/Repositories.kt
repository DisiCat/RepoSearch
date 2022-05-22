package com.example.reposearch.data.parseModels

import com.squareup.moshi.Json

data class Repositories(
    @Json(name = "total_count") var totalCount: Int? = null,
    @Json(name = "incomplete_results") var incompleteResults: Boolean? = null,
    @Json(name = "items") var items: ArrayList<Items> = arrayListOf()
)
