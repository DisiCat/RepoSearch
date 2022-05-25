package com.example.reposearch.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.addRepeatingJob
import androidx.paging.LoadState
import com.example.reposearch.R
import com.example.reposearch.adapters.RepoAdapter
import com.example.reposearch.adapters.ReposLoaderStateAdapter
import com.example.reposearch.databinding.ActivitySearchBinding
import com.example.reposearch.viewModels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil


@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel by lazy { ViewModelProvider(this).get(SearchViewModel::class.java) }
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        RepoAdapter(::clickOnRepo, this)
    }
    private var shouldAllowBack = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.lifecycleOwner = this

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
                    closeKeyboard()
                    viewModel.setNameRepo(searchCondition)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }

    override fun onResume() {
        super.onResume()
        binding.searchView.clearFocus()
    }

    private fun backPressed() {
        val toast = Toast.makeText(
            applicationContext,
            R.string.back_pressed_text,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    override fun onBackPressed() {
        if (!shouldAllowBack) {
            backPressed()
            shouldAllowBack = true
        } else {
            super.onBackPressed()
        }
    }

    private fun clickOnRepo(url: String?, position: Int) {
        viewModel.saveCurrentReposInShared(adapter.getRepo(position))
        adapter.snapshot()[position]?.isRead = true
        adapter.notifyItemChanged(position)
        UIUtil.hideKeyboard(this)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun closeKeyboard() {
        UIUtil.hideKeyboard(this)
    }
}