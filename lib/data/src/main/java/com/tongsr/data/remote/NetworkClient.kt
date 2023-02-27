package com.tongsr.data.remote

import android.util.Log.VERBOSE
import com.tongsr.data.remote.adapter.FlowCallAdapterFactory
import com.tongsr.data.remote.logging.Level
import com.tongsr.data.remote.logging.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/22
 * @email ujffdtfivkg@gmail.com
 * @description 网络客户端
 */
object NetworkClient {

    private const val DEFAULT_TIMEOUT_SECONDS = 15L

    /**
     * 创建 Retrofit 客户端
     *
     * @param baseUrl baseUrl
     * @param timeoutSeconds 默认超时时间
     * @param okHttpClient OkHttpClient
     * @param interceptors 拦截器
     */
    fun create(
        baseUrl: String,
        timeoutSeconds: Long = DEFAULT_TIMEOUT_SECONDS,
        okHttpClient: OkHttpClient? = null,
        interceptors: List<Interceptor>? = null
    ): Retrofit {
        val client = okHttpClient ?: OkHttpClient.Builder()
            .connectTimeout(timeoutSeconds, TimeUnit.SECONDS)
            .readTimeout(timeoutSeconds, TimeUnit.SECONDS)
            .writeTimeout(timeoutSeconds, TimeUnit.SECONDS)
            .addInterceptor(
                LoggingInterceptor.Builder()
                    .setLevel(Level.BASIC)
                    .log(VERBOSE)
                    .build()
            ).apply {
                interceptors?.forEach {
                    addInterceptor(it)
                }
            }
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(FlowCallAdapterFactory.create(true))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    /**
     * WanApp Api 客户端
     */
    val wanApiClient = create(WAN_BASE_URL)

}