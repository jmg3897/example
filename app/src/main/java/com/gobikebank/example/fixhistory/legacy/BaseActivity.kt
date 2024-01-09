package com.gobikebank.example.fixhistory.legacy

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<T : ViewDataBinding>(
    @LayoutRes private val layout: Int
) : AppCompatActivity() {

    protected lateinit var binding: T
    protected lateinit var TAG: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        TAG = this.javaClass.simpleName

        binding.lifecycleOwner = this
    }
}