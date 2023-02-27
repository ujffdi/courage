package com.tongsr.core.component.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * @author Tongsr
 * @version 1.0
 * @date 2022/8/9
 * @email ujffdtfivkg@gmail.com
 * @description 扩展函数
 */

/**
 * 扩展方法，用于获取View
 * @receiver ViewGroup parent
 * @param layoutResId Int
 * @return View
 */
fun ViewGroup.getItemView(@LayoutRes layoutResId: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutResId, this, false)
}

/**
 * 获取 LayoutInflater
 */
fun ViewGroup.getLayoutInflater(): LayoutInflater {
    return LayoutInflater.from(this.context)
}