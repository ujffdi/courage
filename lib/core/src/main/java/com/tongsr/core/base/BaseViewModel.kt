package com.tongsr.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tongsr.data.remote.entity.WanApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/24
 * @email ujffdtfivkg@gmail.com
 * @description BaseViewModel
 */
abstract class BaseViewModel : ViewModel() {

}

/**
 * 对请求统一封装处理。写成 BaseViewModel 的高阶函数是限制在其他地方调用该函数。编码的一种规范
 */
fun <T> BaseViewModel.executeRequest(
    request: suspend () -> Flow<WanApiResult<T>>,
    onStart: () -> Unit?,
    onCompletion: () -> Unit?,
    onError: () -> Unit?,
    onSuccess: (T) -> Unit
) {
    viewModelScope.launch {
        try {
            request().onStart {
                // 请求开始
                onStart()
            }.onCompletion {
                // 请求结束
                onCompletion()
            }.catch { e ->
                // 异常
                onError()
            }.collect {
                if (it.errorCode == 0) {
                    onSuccess(it.data)
                } else {
                    onError()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            onError()
        }
    }
}



