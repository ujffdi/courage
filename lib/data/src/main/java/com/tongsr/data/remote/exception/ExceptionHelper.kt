package com.tongsr.data.remote.exception

import com.google.gson.JsonParseException
import com.tongsr.data.remote.*
import kotlinx.coroutines.CancellationException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/27
 * @email ujffdtfivkg@gmail.com
 * @description 捕获异常
 */

/**
 * 捕获异常信息
 * @param e Throwable
 */
fun handleApiException(e: Throwable): ApiException {
    return when (e) {
        is UnknownHostException -> {
            ApiException(API_ERROR_NET, "網絡異常")
        }
        is JSONException, JsonParseException(e.message) -> {
            ApiException(API_ERROR_JSON_PARSE, "數據異常")
        }
        is SocketTimeoutException -> {
            ApiException(API_ERROR_SOCKET_TIMEOUT, e.message ?: "")
        }
        is ConnectException -> {
            ApiException(API_ERROR_CONNECT, "連接錯誤")
        }
        is HttpException -> {
            ApiException(API_ERROR_HTTP, "http code ${e.code()}")
        }
        is ApiException -> {
            e
        }
        is CancellationException -> {
            ApiException(API_ERROR_CANCELLATION, "Cancellation Exception")
        }
        else -> {
            ApiException(API_ERROR_UNKNOWN, "未知錯誤")
        }
    }
}