package com.tongsr.core.extend

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.tongsr.core.component.SingleLiveEvent

/**
 * @author Lebin
 * @version 1.0
 * @date 2021/11/24
 * @description
 */

/**
 * 简化LiveData的订阅操作，参数可为null
 */
fun <T> LiveData<T>.observeNullable(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner) {
        block(it)
    }
}

/**
 * 简化LiveData的订阅操作，参数不为null
 */
fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner) {
        if (it != null) block(it)
    }
}

/**
 * 简化LiveData的订阅操作，参数不为null，永久观察
 */
fun <T> LiveData<T>.observeNonNullForever(block: (T) -> Unit) {
    this.observeForever {
        if (it != null) {
            block(it)
        }
    }
}

/**
 * 简化SingleLiveEvent的订阅操作，参数可为null
 */
fun <T> SingleLiveEvent<T>.observeNullable(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner) {
        block(it)
    }
}

/**
 * 简化SingleLiveEvent的订阅操作，参数不为null
 */
fun <T> SingleLiveEvent<T>.observeNonNull(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner) {
        if (it != null) block(it)
    }
}