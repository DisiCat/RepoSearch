package com.example.reposearch.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reposearch.R
import com.example.reposearch.adapters.HistoryAdapter
import com.example.reposearch.databinding.ActivityHistoryBinding
import com.example.reposearch.viewModels.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private var historyAdapter: HistoryAdapter? = null
    private val viewModel by lazy { ViewModelProvider(this).get(HistoryViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)
        binding.lifecycleOwner = this
        initHistoryList()
    }

    private fun initHistoryList() {
        viewModel.historyList.observe(this) {
            if (it == null || it.count() == 0) {
                if (historyAdapter != null)
                    historyAdapter?.submitList(it)
            } else {
                lifecycleScope.launchWhenCreated {
                    if (binding.recyclerView.adapter == null) {
                        historyAdapter = HistoryAdapter(it)
                        binding.recyclerView.layoutManager =
                            LinearLayoutManager(applicationContext)
                        binding.recyclerView.adapter = historyAdapter

                    } else {
                        historyAdapter?.submitList(it)
                    }
                }
            }
        }
    }
}