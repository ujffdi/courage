package com.tongsr.data.remote.adapter.sync

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import java.lang.reflect.Type
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/23
 * @email ujffdtfivkg@gmail.com
 * @description ResponseFlowCallAdapter
 */
class ResponseFlowCallAdapter<R>(private val responseBodyType: R) :
    CallAdapter<R, Flow<Response<R>>> {
    override fun responseType() = responseBodyType as Type

    override fun adapt(call: Call<R>): Flow<Response<R>> = responseFlow(call)
}

fun <T> responseFlow(call: Call<T>): Flow<Response<T>> = flow {
    suspendCancellableCoroutine<Response<T>> { continuation ->
        continuation.invokeOnCancellation {
            call.cancel()
        }
        try {
            val response = call.execute()
            continuation.resume(response)
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.let {
        emit(it)
    }
}.take(1)