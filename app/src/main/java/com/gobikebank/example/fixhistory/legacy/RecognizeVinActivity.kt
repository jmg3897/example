package com.gobikebank.example.fixhistory.legacy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.gobikebank.example.fixhistory.legacy.ViewUtils.setOnSingleClickListener
import com.gobikebank.example.R
import com.gobikebank.example.databinding.ActivityRecognizeVinBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecognizeVinActivity :
    BaseActivity<ActivityRecognizeVinBinding>(R.layout.activity_recognize_vin) {
    private val viewModel: RecognizeVinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.activity = this
        binding.viewModel = viewModel

        setOnClickListener()
//        getDataFromQrFragment()
        initToolbar()
//        observeLiveData()
    }

    private fun initToolbar() {
        viewModel.setToolbarTitle(getString(R.string.fix_history_text))

        binding.recognizeVinToolbar.bikebankCustomerToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun setOnClickListener() {
        binding.recognizeVinLookUpButton.setOnSingleClickListener {
            setOnClickLookUpButton()
        }
    }

    private fun setOnClickLookUpButton() {
        startFixHistoryActivity()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        hideKeyboard()
        return true
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun startFixHistoryActivity() {
        startActivity(
            Intent(
                this, FixHistoryActivity::class.java
            ).putExtra(FixHistoryActivity.BIKE_SSN_KEY, viewModel.insertedVin.value)
        )
    }

    private fun makeToastMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val RECOGNIZE_VIN_TOOLBAR_TITLE_KEY = "RECOGNIZE_VIN_TOOLBAR_TITLE_KEY"
        private const val EMPTY_INSERTED = ""
        private const val EMPTY_MESSAGE = ""
    }
}