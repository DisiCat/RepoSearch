package com.example.reposearch.data

data class RepositoryModel(
    var name : String,
    var star_count : Int,
    var repo_url : String,
    var isRead : Boolean = false
)
