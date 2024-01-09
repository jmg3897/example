package com.gobikebank.example.fixhistory.legacy

import android.view.View

object ViewUtils {
    fun View.setOnSingleClickListener(onSingleClick: (View?) -> Unit) {
        val oneClick = OnSingleClickListener {
            onSingleClick(it)
        }
        setOnClickListener(oneClick)
    }
}