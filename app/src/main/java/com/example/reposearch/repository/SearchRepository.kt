package com.example.reposearch.repository

import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.parseModels.Repositories
import com.example.reposearch.network.RestApiService
import com.example.reposearch.repository.interfaces.ISearchRepository
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.http.Url
import java.net.URLDecoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(
    private val restApiService: RestApiService
) : ISearchRepository {
    override suspend fun getRepos(name: String) {

        val result = restApiService.getRepos("star", "desc",30, name)

        val test: Repositories? = result.body()
        test?.totalCount
    }
}