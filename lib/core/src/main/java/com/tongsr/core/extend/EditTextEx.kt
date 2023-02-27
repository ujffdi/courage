package com.tongsr.core.extend

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/11/21
 * @email ujffdtfivkg@gmail.com
 * @description EditText 一些扩展函数
 */


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}