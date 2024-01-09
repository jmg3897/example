package com.gobikebank.example.fixhistory.legacy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gobikebank.example.fixhistory.common.model.FixHistories.FixHistory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixHistoryViewModel @Inject constructor(
//    private val bikeBankRepository: BikeBankRepository
) : ViewModel() {

    private var _fixHistoryList = MutableLiveData<List<FixHistory>>()
    val fixHistoryList: LiveData<List<FixHistory>>
        get() = _fixHistoryList

    private var _showLoadingState = MutableLiveData<Boolean>()
    val showLoadingState: LiveData<Boolean>
        get() = _showLoadingState

    fun getFixHistoryList(bikeSSN: String) {
        viewModelScope.launch {
            try {
                _showLoadingState.value = true
//                bikeBankRepository.getFixHistoryList(bikeSSN)?.let {
//                    _fixHistoryList.value = it
//                }
                _showLoadingState.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        private val TAG = FixHistoryViewModel::class.java.simpleName
    }
}