package com.example.reposearch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.reposearch.R
import com.example.reposearch.data.RepositoryModel
import com.example.reposearch.databinding.RepositoryItemLayoutBinding

class RepoAdapter(context: Context) :
    PagingDataAdapter<RepositoryModel, RepoViewHolder>(RepositoryDiffItemCallback) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            layoutInflater.inflate(
                R.layout.repository_item_layout,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val _viewBinding by viewBinding(RepositoryItemLayoutBinding::bind)

    fun bind(repository: RepositoryModel?) {
        with(_viewBinding){
            nameRepoTextView.text = repository?.name
            countStarTextView.text = repository?.star_count.toString()
        }
    }
}


private object RepositoryDiffItemCallback : DiffUtil.ItemCallback<RepositoryModel>() {

    override fun areItemsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean {
        return oldItem.name == newItem.name && oldItem.star_count == newItem.star_count
    }
}