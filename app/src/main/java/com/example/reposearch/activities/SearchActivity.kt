package com.example.reposearch.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle

import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.reposearch.R
import com.example.reposearch.adapters.RepoAdapter
import com.example.reposearch.adapters.ReposLoaderStateAdapter
import com.example.reposearch.databinding.ActivitySearchBinding
import com.example.reposearch.viewModels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel by lazy { ViewModelProvider(this).get(SearchViewModel::class.java) }
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        RepoAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.lifecycleOwner = this
        //   initSearchViewListener()
        with(binding) {
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = ReposLoaderStateAdapter(),
                footer = ReposLoaderStateAdapter()
            )
        }


        adapter.addLoadStateListener { state ->
            with(binding) {
                recyclerView.isVisible = state.refresh != LoadState.Loading
                progress.isVisible = state.refresh == LoadState.Loading
            }
        }
        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.repositories.collectLatest(
                adapter::submitData
            )
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchCondition: String?): Boolean {
                if (!searchCondition.isNullOrEmpty()) {
                    viewModel.setNameRepo(searchCondition)
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