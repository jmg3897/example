package com.gobikebank.example.fixhistory.legacy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gobikebank.example.databinding.ItemFixHistoryListBinding
import com.gobikebank.example.fixhistory.common.model.FixHistories.FixHistory

class FixHistoryListAdapter(
    private val onClickFixHistory: (String) -> Unit
) :
    ListAdapter<FixHistory, FixHistoryListAdapter.FixHistoryViewHolder>(diff) {
    inner class FixHistoryViewHolder(private val binding: ItemFixHistoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fixHistory: FixHistory) {
            binding.fixHistory = fixHistory
            binding.itemFixHistoryContainer.setOnClickListener {
                onClickFixHistory.invoke(fixHistory.serialNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixHistoryViewHolder {
        val binding =
            ItemFixHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FixHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixHistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<FixHistory>() {
            override fun areItemsTheSame(oldItem: FixHistory, newItem: FixHistory): Boolean {
                return oldItem.serialNumber == newItem.serialNumber
            }

            override fun areContentsTheSame(oldItem: FixHistory, newItem: FixHistory): Boolean {
                return oldItem == newItem
            }
        }

        private val TAG = FixHistoryListAdapter::class.java.simpleName
    }
}