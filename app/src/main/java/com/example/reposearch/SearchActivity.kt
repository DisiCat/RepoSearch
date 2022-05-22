package com.example.reposearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.reposearch.databinding.ActivitySearchBinding
import com.example.reposearch.viewModels.LoginViewModel
import com.example.reposearch.viewModels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel by lazy { ViewModelProvider(this).get(SearchViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.lifecycleOwner = this
        //   initSearchViewListener()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchCondition: String?): Boolean {
                if (!searchCondition.isNullOrEmpty()) {
                    viewModel.getRepos(searchCondition)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }

    /* private fun initSearchViewListener() {
         binding.searchView.setOnClickListener {
             View.OnClickListener {
                 binding.searchView.onActionViewExpanded()
             }
         }
     }*/

}