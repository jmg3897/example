package com.gobikebank.example.fixhistory.legacy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.gobikebank.example.R
import com.gobikebank.example.databinding.ActivityFixHistoryBinding
import com.gobikebank.example.fixhistory.common.data.Dummy
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixHistoryActivity : BaseActivity<ActivityFixHistoryBinding>(R.layout.activity_fix_history) {
    private val viewModel: FixHistoryViewModel by viewModels()
    private lateinit var adapter: FixHistoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initToolbar()
        setAdapter()

        adapter.submitList(Dummy.dataProvider())

//        getFixHistoryList()
//        observeLiveData()
    }

    private fun initToolbar() {
        binding.fixHistoryToolbar.bikebankCustomerToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setAdapter() {
        adapter = FixHistoryListAdapter(
            onClickFixHistory = { idx ->
                startDetailFixHistoryActivity(idx)
            }
        )
        binding.fixHistoryRecyclerview.adapter = adapter
    }

    private fun startDetailFixHistoryActivity(idx: String) {
//        startActivity(
//            Intent(
//                this, DetailFixHistoryActivity::class.java
//            ).putExtra(DetailFixHistoryActivity.DETAIL_FIX_HISTORY_IDX_KEY, idx)
//        )
    }

    companion object {
        const val BIKE_SSN_KEY = "FIX_HISTORY_BIKE_SSN_KEY"
    }
}