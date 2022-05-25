package com.example.reposearch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reposearch.R
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.databinding.RepositoryItemLayoutBinding

class HistoryAdapter(
    private var historyRepoList: List<RepositoryModel>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(private val itemRepoBinding: RepositoryItemLayoutBinding) :
        RecyclerView.ViewHolder(itemRepoBinding.root) {

        fun bind(item: RepositoryModel) {
            with(itemRepoBinding) {
                nameRepoTextView.text = item.name
                countStarTextView.text = item.star_count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HistoryViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.repository_item_layout,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyRepoList[position])
    }

    override fun getItemCount(): Int {
        return historyRepoList.size
    }

    fun submitList(accountListNew: List<RepositoryModel>?) {
        if (accountListNew == null) {
            historyRepoList = listOf()
            notifyDataSetChanged()
            return
        }
    }
}