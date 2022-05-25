package com.example.reposearch.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.reposearch.AppDefaultValues
import com.example.reposearch.data.RepositoryModel
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesUtils @Inject constructor(
    @ApplicationContext context: Context,
    private val moshi: Moshi
) : ISharedPreferencesUtils {

    private var editor: SharedPreferences.Editor? = null
    private var settings: SharedPreferences? = null
    private val _context: Context = context

    override fun addRepositoriesList(name: String, list: List<RepositoryModel>) {
        if (settings == null) {
            initShared()
        }
        val json = Gson().toJson(list).toString()

        editor?.putString(name, json)
        editor?.apply()
    }

    override fun getRepositoriesList(name: String?): List<RepositoryModel>? {
        if (settings == null) {
            initShared()
        }
        val json = settings?.getString(name, null) ?: return null
        return try {
            val type = Types.newParameterizedType(
                List::class.java,
                RepositoryModel::class.java
            )
            val adapter = moshi.adapter<List<RepositoryModel>>(type)
            adapter.fromJson(json)
        } catch (ex: Exception) {
            null
        }
    }

    private fun initShared() {
        val packageName = _context.packageName
        val storage = "$packageName +${AppDefaultValues.APP_LOCAL_STORAGE}"
        settings = _context.getSharedPreferences(storage, Context.MODE_PRIVATE)
        editor = settings?.edit()
    }
}