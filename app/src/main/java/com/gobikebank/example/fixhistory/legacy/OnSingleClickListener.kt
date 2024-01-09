package com.gobikebank.example.fixhistory.legacy

import android.view.View

/****************************************************************************************************
 * 버튼 눌렀을 때 API 호출을 하는 경우, 첫 번째 클릭 이후 몇 초간 버튼 클릭을 하지 못하도록 막아서 여러번 API가 호출되는 현상을 막음
 ****************************************************************************************************/
class OnSingleClickListener(
    private val intervalTime: Long = 600L,
    private val action: (View?) -> Unit
) : View.OnClickListener {
    private var lastClickTime: Long = 0

    override fun onClick(v: View?) {
        val systemTime = System.currentTimeMillis()
        if (systemTime - lastClickTime > intervalTime) {
            lastClickTime = systemTime
            action.invoke(v)
        }
    }
}