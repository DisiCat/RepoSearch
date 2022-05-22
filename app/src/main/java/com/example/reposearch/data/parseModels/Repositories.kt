package com.example.reposearch.data.parseModels

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Repositories(
    @Json(name = "total_count") var totalCount: Int? = null,
    @Json(name = "incomplete_results") var incompleteResults: Boolean? = null,
    @Json(name = "items") var items: List<Items> = listOf<Items>()
)
